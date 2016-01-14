package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthKeyCreation
import com.github.badoualy.telegram.mtproto.exception.RpcErrorException
import com.github.badoualy.telegram.mtproto.util.Log
import com.github.badoualy.telegram.tl.api.requests.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.api.requests.TLRequestInitConnection
import com.github.badoualy.telegram.tl.api.requests.TLRequestInvokeWithLayer18
import java.io.IOException

internal interface TelegramClientDelegate {
    var mtProtoHandler: MTProtoHandler?
    var authKey: AuthKey?
    var dataCenter: DataCenter?

    fun migrate(dcId: Int)
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

        if (dataCenter == null && !generateAuthKey) {
            apiStorage.deleteAuthKey()
            apiStorage.deleteDc()
            throw RuntimeException("Found an authorization key in storage, but the nearest DC configuration was not found, deleting authorization key and nearest data center")
        }

        if (dataCenter == null) {
            Log.d(TAG, "No data center found in storage, using preferred " + preferredDataCenter.toString())
            dataCenter = preferredDataCenter
        }

        init()
    }

    private fun init(attemptCount: Int = 0, checkNearestDc: Boolean = true) {
        mtProtoHandler = if (generateAuthKey) initWithoutKey() else MTProtoHandler(dataCenter!!, authKey!!)
        mtProtoHandler!!.startWatchdog()
        if (checkNearestDc)
            checkNearestDc(attemptCount)
    }

    private fun initWithoutKey(): MTProtoHandler {
        val authResult = AuthKeyCreation.createAuthKey(dataCenter!!)
        if (authResult != null) {
            authKey = authResult.authKey
            apiStorage.saveAuthKey(authKey!!)
            apiStorage.saveDc(dataCenter!!)
            return MTProtoHandler(authResult)
        } else {
            throw RuntimeException("Couldn't generate authorization key")
        }
    }

    private fun checkNearestDc(attemptCount: Int) {
        // Call to initConnection to setup information about this app for the user to see in "active sessions"
        // Also will indicate to Telegram that we're using layer 18
        try {
            // List all DC
            //val config = invokeWithLayer18_(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, TLRequestHelpGetConfig())) as TLConfig
            //for (dc in config.dcOptions) Log.d(TAG, "DC${dc.id} at ${dc.ipAddress}:${dc.port} with hostname ${dc.hostname}")

            val nearestDc = mtProtoHandler!!
                    .executeMethod(TLRequestInvokeWithLayer18(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, TLRequestHelpGetNearestDc())))
                    .toBlocking().first()
            if (nearestDc.thisDc != nearestDc.nearestDc) {
                mtProtoHandler?.close()
                Log.d(TAG, "Current DC${nearestDc.thisDc} is not the nearest, connecting to DC${nearestDc.nearestDc}")

                if (attemptCount > 0)
                    throw RuntimeException("TLRequestHelpGetNearestDc returned inconsistent values: got two different values for two consecutive calls")

                if (!generateAuthKey) {
                    // Key was provided, yet selected DC is not the nearest
                    // TODO: Should handle authKey migration via auth.exportAuthorization
                    throw RuntimeException("You tried to connect to an incorrect data center (DC${nearestDc.thisDc}) with an authorization key stored, please connect to the nearest (DC${nearestDc.nearestDc})")
                } else {
                    // We have to re-open connection to new dc
                    authKey = null
                    dataCenter = Kotlogram.PROD_DCS[nearestDc.nearestDc - 1]
                    apiStorage.deleteAuthKey()
                    Log.d(TAG, "Updated dataCenter to DC${nearestDc.nearestDc} ${dataCenter.toString()}")
                    generateAuthKey = true
                    init(attemptCount + 1)
                }
            } else {
                Log.d(TAG, "Connected to the nearest DC${nearestDc.thisDc}")
            }
        } catch(e: IOException) {
            mtProtoHandler?.close()
            if (e is RpcErrorException && e.error.errorCode == -404)
                throw RuntimeException("Your authorization key seems to be invalid (error " + e.error.errorCode + ")")
            throw RuntimeException("An unknown error has occurred", e)
        }
    }

    override fun migrate(dcId: Int) {
        Log.d(TAG, "Migrating to DC$dcId")
        mtProtoHandler?.close()
        authKey = null
        dataCenter = Kotlogram.PROD_DCS[dcId - 1]
        apiStorage.deleteAuthKey()
        generateAuthKey = true

        init(checkNearestDc = false)
    }
}