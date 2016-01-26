package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.AuthKeyCreation
import com.github.badoualy.telegram.mtproto.exception.RpcErrorException
import com.github.badoualy.telegram.mtproto.util.Log
import com.github.badoualy.telegram.tl.api.TelegramApiWrapper
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthImportAuthorization
import com.github.badoualy.telegram.tl.api.request.TLRequestInitConnection
import com.github.badoualy.telegram.tl.api.request.TLRequestInvokeWithLayer
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException

internal class DefaultTelegramClient internal constructor(application: TelegramApp, apiStorage: TelegramApiStorage,
                                                          preferredDataCenter: DataCenter) :
        TelegramApiWrapper(),
        TelegramClient,
        TelegramClientDelegate by TelegramClientDelegateImpl(application, apiStorage, preferredDataCenter, null) {

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
                        } else if (error.message.startsWith("FILE_MIGRATE_")) {
                            val migratedHandler = getMigratedMTProtoHandler(error.message.removePrefix("FILE_MIGRATE_").toInt())
                            try {
                                val result = migratedHandler.executeMethod(method).toBlocking().first()
                                migratedHandler.close()
                                return result
                            } catch (e: IOException) {
                                migratedHandler.close()
                            }
                        }
                    }
                    throw exception.cause as RpcErrorException
                }
                is IOException -> throw exception.cause as IOException
                else -> throw exception
            }
        }
    }

    @Throws(IOException::class)
    override fun authSendCode(phoneNumber: String, smsType: Int) = super.authSendCode(phoneNumber, smsType, application.apiId, application.apiHash, application.langCode)

    @Throws(IOException::class)
    override fun <T : TLObject> initConnection(query: TLMethod<T>) = executeRpcQuery(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, query))

    @Throws(IOException::class)
    private fun getMigratedMTProtoHandler(dcId: Int): MTProtoHandler {
        val dc = Kotlogram.PROD_DCS[dcId - 1]
        val exportedAuthorization = authExportAuthorization(dcId)

        val authResult = AuthKeyCreation.createAuthKey(dc) ?: throw IOException("Couldn't create authorization key on DC$dcId")
        val mtProtoHandler = MTProtoHandler(authResult, null)
        mtProtoHandler.startWatchdog()
        initConnection(mtProtoHandler, TLRequestAuthImportAuthorization(exportedAuthorization.id, exportedAuthorization.bytes))

        return mtProtoHandler
    }
}