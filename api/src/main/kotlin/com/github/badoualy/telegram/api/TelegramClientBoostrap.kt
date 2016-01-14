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
}

internal class TelegramClientDelegateImpl(val application: TelegramApp, val apiStorage: TelegramApiStorage,
                                          val preferredDataCenter: DataCenter) : TelegramClientDelegate {

    private val TAG = "TelegramClientDelegateImpl"

    override var mtProtoHandler: MTProtoHandler? = null
    override var authKey: AuthKey? = null

    private var dataCenter: DataCenter
    private var generateAuthKey: Boolean

    init {
        authKey = apiStorage.loadAuthKey()
        val nearestDc = apiStorage.loadNearestDc()

        if (authKey != null && nearestDc == null)
            throw RuntimeException("Found an authorization key in storage, but the nearest DC configuration was not found")

        dataCenter = nearestDc ?: preferredDataCenter
        generateAuthKey = authKey == null

        mtProtoHandler = init()
    }

    private fun init(attemptCount: Int = 0): MTProtoHandler {
        val mtProtoHandler = if (generateAuthKey) initWithoutKey() else MTProtoHandler(dataCenter, authKey!!)
        this.mtProtoHandler = mtProtoHandler
        mtProtoHandler.startWatchdog()

        checkNearestDc(attemptCount)
        return mtProtoHandler
    }

    private fun initWithoutKey(): MTProtoHandler {
        val authResult = AuthKeyCreation.createAuthKey(dataCenter)
        if (authResult != null) {
            val mtProtoHandler = MTProtoHandler(authResult)
            apiStorage.saveAuthKey(authResult.authKey)
            return mtProtoHandler
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
                    dataCenter = Kotlogram.PROD_DCS[nearestDc.nearestDc - 1]
                    Log.d(TAG, "Updated dataCenter to DC${nearestDc.nearestDc} ${dataCenter.toString()}")
                    apiStorage.deleteAuthKey()
                    apiStorage.saveNearestDc(dataCenter)
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

}