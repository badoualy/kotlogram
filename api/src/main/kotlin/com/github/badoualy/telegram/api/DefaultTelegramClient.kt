package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.mtproto.auth.AuthKeyCreation
import com.github.badoualy.telegram.mtproto.auth.AuthResult
import com.github.badoualy.telegram.mtproto.exception.RpcErrorException
import com.github.badoualy.telegram.mtproto.util.Log
import com.github.badoualy.telegram.tl.api.TelegramApiWrapper
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization
import com.github.badoualy.telegram.tl.api.requests.TLRequestHelpGetNearestDc
import com.github.badoualy.telegram.tl.api.requests.TLRequestInitConnection
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException

internal class DefaultTelegramClient internal constructor(val application: TelegramApp, val apiStorage: TelegramApiStorage,
                                                          val preferredDataCenter: DataCenter) :
        TelegramApiWrapper(),
        TelegramClient,
        TelegramClientDelegate by TelegramClientDelegateImpl(application, apiStorage, preferredDataCenter) {

    private val TAG = "TelegramClient"

    @Throws(IOException::class)
    override fun <T : TLObject> executeRpcQuery(method: TLMethod<T>): T {
        // BlockingObservable.first() will throw a RuntimeException if onError() is called by observable
        try {
            return mtProtoHandler!!.executeMethod(method).toBlocking().first()
        } catch(exception: RuntimeException) {
            when (exception.cause) {
                is RpcErrorException -> {
                    val error = (exception.cause as RpcErrorException).error
                    if (error.errorCode == 303) {
                        // DC error
                        Log.e(TAG, "Received DC error: " + error.message)
                        if (error.message.startsWith("PHONE_MIGRATE_")) {
                            migrate(error.message.removePrefix("PHONE_MIGRATE_").toInt())
                            return executeRpcQuery(method)
                        }
                    }
                    throw exception.cause as IOException
                }
                is IOException -> throw exception.cause as IOException
                else -> throw exception
            }
        }
    }

    override fun authSendCode(phoneNumber: String, smsType: Int) = super.authSendCode(phoneNumber, smsType, application.apiId, application.apiHash, application.langCode)

    override fun <T : TLObject> initConnection(query: TLMethod<T>) = executeRpcQuery(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, query))
}