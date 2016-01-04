package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.auth.AuthKey
import com.github.badoualy.telegram.tl.api.TelegramReactiveApiWrapper
import com.github.badoualy.telegram.tl.api.requests.TLRequestInitConnection
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import rx.Observable

internal class DefaultTelegramReactiveClient internal constructor(val application: TelegramApp, val apiStorage: TelegramApiStorage,
                                                                  val preferredDataCenter: DataCenter) : TelegramReactiveApiWrapper(), TelegramReactiveClient {

    private val TAG = "TelegramReactiveClient"

    internal var mtProtoHandler: MTProtoHandler? = null
        private set
    internal var authKey: AuthKey? = null
        private set

    init {
        val delegateClient = DefaultTelegramClient(application, apiStorage, preferredDataCenter)
        authKey = delegateClient.authKey
        mtProtoHandler = delegateClient.mtProtoHandler
    }

    override fun close() = mtProtoHandler!!.close()

    override fun <T : TLObject> executeRpcQuery(method: TLMethod<T>): Observable<T> {
        return mtProtoHandler!!.executeMethod(method)
    }

    override fun authSendCode(phoneNumber: String, smsType: Int) = super.authSendCode(phoneNumber, smsType, application.apiId, application.apiHash, application.langCode)

    override fun <T : TLObject> initConnection(query: TLMethod<T>) = executeRpcQuery(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, query))
}