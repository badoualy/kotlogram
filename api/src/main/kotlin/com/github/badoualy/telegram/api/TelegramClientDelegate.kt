package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthKeyCreation
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.exception.RpcErrorException
import com.github.badoualy.telegram.mtproto.util.Log
import com.github.badoualy.telegram.tl.api.TLNearestDc
import com.github.badoualy.telegram.tl.api.requests.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.api.requests.TLRequestInitConnection
import com.github.badoualy.telegram.tl.api.requests.TLRequestInvokeWithLayer18
import java.io.IOException

internal interface TelegramClientDelegate {
    var mtProtoHandler: MTProtoHandler?
    var authKey: AuthKey?
    var dataCenter: DataCenter?

    /**
     * Disconnect from current data center and connect to the new one
     * @param dcId id of the new data center [1, 5]
     */
    fun migrate(dcId: Int)

    /** Closes all connections and stop all threads used by the client. */
    fun close()
}

internal class TelegramClientDelegateImpl(val application: TelegramApp, val apiStorage: TelegramApiStorage,
                                          val preferredDataCenter: DataCenter) : TelegramClientDelegate {

    private val TAG = "TelegramClientDelegateImpl"

    override var mtProtoHandler: MTProtoHandler? = null
    override var authKey: AuthKey? = null
    override var dataCenter: DataCenter? = null

    private var generateAuthKey: Boolean

    init {
        authKey = apiStorage.loadAuthKey()
        dataCenter = apiStorage.loadDc()
        generateAuthKey = authKey == null

        if (dataCenter == null) {
            if (!generateAuthKey) {
                apiStorage.deleteAuthKey()
                throw RuntimeException("Found an authorization key in storage, but the DC configuration was not found, deleting authorization key")
            }
            Log.d(TAG, "No data center found in storage, using preferred ${preferredDataCenter.toString()}")
            dataCenter = preferredDataCenter
        }

        init(generateAuthKey)
    }

    private fun init(checkNearestDc: Boolean = true) {
        mtProtoHandler = if (generateAuthKey) MTProtoHandler(generateAuthKey()) else MTProtoHandler(dataCenter!!, authKey!!)
        mtProtoHandler!!.startWatchdog()

        try {
            // Call to initConnection to setup information about this app for the user to see in "active sessions"
            // Also will indicate to Telegram which layer to use through InvokeWithLayer
            val nearestDc = mtProtoHandler!!
                    .executeMethod(TLRequestInvokeWithLayer18(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, TLRequestHelpGetNearestDc())))
                    .toBlocking().first()
            if (checkNearestDc)
                checkNearestDc(nearestDc)
        } catch(e: IOException) {
            mtProtoHandler?.close()
            if (e is RpcErrorException && e.error.errorCode == -404)
                throw RuntimeException("Your authorization key seems to be invalid (error " + e.error.errorCode + ")")
            throw RuntimeException("An unknown error has occurred", e)
        }
    }

    private fun generateAuthKey(): AuthResult {
        val authResult = AuthKeyCreation.createAuthKey(dataCenter!!) ?: throw RuntimeException("Couldn't generate authorization key")
        authKey = authResult.authKey
        apiStorage.saveAuthKey(authKey!!)
        apiStorage.saveDc(dataCenter!!)
        return authResult
    }

    @Throws(IOException::class)
    private fun checkNearestDc(nearestDc: TLNearestDc) {
        if (nearestDc.thisDc != nearestDc.nearestDc) {
            if (!generateAuthKey) {
                // Key was provided, yet selected DC is not the nearest
                // TODO: Should handle authKey migration via auth.exportAuthorization
                mtProtoHandler?.close()
                throw RuntimeException("You tried to connect to an incorrect data center (DC${nearestDc.thisDc}) with an authorization key in storage, please connect to the nearest (DC${nearestDc.nearestDc})")
            }
            migrate(nearestDc.nearestDc)
        } else {
            Log.d(TAG, "Connected to the nearest DC${nearestDc.thisDc}")
        }
    }

    override fun migrate(dcId: Int) {
        Log.d(TAG, "Migrating to DC$dcId")
        mtProtoHandler?.close()
        authKey = null
        dataCenter = Kotlogram.PROD_DCS[dcId - 1]
        apiStorage.deleteAuthKey()
        apiStorage.deleteDc()
        generateAuthKey = true

        init(checkNearestDc = false)
    }

    override fun close() = mtProtoHandler?.close() ?: Unit
}