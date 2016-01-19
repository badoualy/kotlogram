package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.DataCenter
import com.github.badoualy.telegram.tl.api.TelegramReactiveApiWrapper
import com.github.badoualy.telegram.tl.api.requests.TLRequestInitConnection
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import rx.Observable

internal class DefaultTelegramReactiveClient internal constructor(application: TelegramApp, apiStorage: TelegramApiStorage,
                                                                  preferredDataCenter: DataCenter) :
        TelegramReactiveApiWrapper(),
        TelegramReactiveClient,
        TelegramClientDelegate by TelegramClientDelegateImpl(application, apiStorage, preferredDataCenter, null) {

    private val TAG = "TelegramReactiveClient"

    override fun <T : TLObject> executeRpcQuery(method: TLMethod<T>): Observable<T> {
        return mtProtoHandler!!.executeMethod(method)
        // TODO: handle migration after error 303
    }

    override fun authSendCode(phoneNumber: String, smsType: Int) = super.authSendCode(phoneNumber, smsType, application.apiId, application.apiHash, application.langCode)

    override fun <T : TLObject> initConnection(query: TLMethod<T>) = executeRpcQuery(TLRequestInitConnection(application.apiId, application.deviceModel, application.systemVersion, application.appVersion, application.langCode, query))
}