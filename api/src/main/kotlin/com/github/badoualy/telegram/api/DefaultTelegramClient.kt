package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthKeyCreation
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.exception.RpcErrorException
import com.github.badoualy.telegram.mtproto.util.Log
import com.github.badoualy.telegram.tl.api.TelegramApiWrapper
import com.github.badoualy.telegram.tl.api.requests.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.api.requests.TLRequestInitConnection
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException

internal class DefaultTelegramClient internal constructor(val application: TelegramApp, val apiStorage: TelegramApiStorage,
                                                          val preferredDataCenter: DataCenter) : TelegramApiWrapper(), TelegramClient {

    private val TAG = "TelegramClient"

    internal var mtProtoHandler: MTProtoHandler? = null
        private set
    internal var authKey: AuthKey? = null
        private set

    private val generateKey: Boolean
    private var dataCenter: DataCenter

    init {
        authKey = apiStorage.loadAuthKey()
        val nearestDc = apiStorage.loadNearestDc()

        if (authKey != null && nearestDc == null)
            throw RuntimeException("Found an authorization key in storage, but the nearest DC configuration was not found")

        dataCenter = nearestDc ?: preferredDataCenter
        generateKey = authKey == null

        mtProtoHandler = if (generateKey) initWithoutKey() else MTProtoHandler(dataCenter, authKey!!)
        mtProtoHandler?.startWatchdog()

        checkNearestDc()
    }

    private fun initWithoutKey(): MTProtoHandler {
        val authResult: AuthResult? = AuthKeyCreation.createAuthKey(dataCenter)
        if (authResult != null) {
            val mtProtoHandler = MTProtoHandler(authResult)
            apiStorage.saveAuthKey(authResult.authKey)

            return mtProtoHandler
        } else {
            throw RuntimeException("Error creating authorization key")
        }
    }

    private fun checkNearestDc(attemptCount: Int = 0) {
        // Call to initConnection to setup information about this app for the user to see in "active sessions"
        // Also will indicate to Telegram that we're using layer 18
        try {
            //val config = invokeWithLayer18_(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, TLRequestHelpGetConfig())) as TLConfig
            //for (dc in config.dcOptions) Log.d(TAG, "DC${dc.id} at ${dc.ipAddress}:${dc.port} with hostname ${dc.hostname}")

            val nearestDc = invokeWithLayer18(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, TLRequestHelpGetNearestDc()))
            if (nearestDc.thisDc != nearestDc.nearestDc) {
                mtProtoHandler?.close()
                Log.d(TAG, "Current DC${nearestDc.thisDc} is not the nearest, connecting to DC${nearestDc.nearestDc}")

                if (attemptCount > 0)
                    throw RuntimeException("TLRequestHelpGetNearestDc returned inconsistent values: got two different values for two consecutive calls")

                if (!generateKey) {
                    // Key was provided, yet selected DC is not the nearest
                    throw RuntimeException("You tried to connect to an incorrect data center (DC${nearestDc.thisDc}) with an authorization key stored, please connect to the nearest (DC${nearestDc.nearestDc})")
                } else {
                    // We have to re-open connection to new dc
                    dataCenter = Kotlogram.PROD_DCS[nearestDc.nearestDc - 1]
                    apiStorage.saveNearestDc(dataCenter)
                    mtProtoHandler = initWithoutKey()
                    mtProtoHandler?.startWatchdog()
                    checkNearestDc(attemptCount + 1) // We recall for the "init connection" call
                }
            }
        } catch(e: IOException) {
            mtProtoHandler?.close()
            if (e is RpcErrorException && e.error.errorCode == -404)
                throw RuntimeException("Your authorization key seems to be invalid (error " + e.error.errorCode + ")")
            throw RuntimeException("An unknown error has occurred", e)
        }
    }

    override fun close() = mtProtoHandler!!.close()

    @Throws(IOException::class)
    override fun <T : TLObject> executeRpcQuery(method: TLMethod<T>): T {
        // BlockingObservable.first() will throw a RuntimeException if onError() is called by observable
        try {
            return mtProtoHandler!!.executeMethod(method).toBlocking().first()
        } catch(exception: RuntimeException) {
            when (exception.cause) {
                is IOException -> throw exception.cause as IOException
                else -> throw exception
            }
        }
    }

    override fun authSendCode(phoneNumber: String, smsType: Int) = super.authSendCode(phoneNumber, smsType, application.apiId, application.apiHash, application.langCode)

    override fun <T : TLObject> initConnection(query: TLMethod<T>) = executeRpcQuery(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, query))
}