package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.exception.RpcErrorException
import com.github.badoualy.telegram.tl.api.TelegramApi
import com.github.badoualy.telegram.tl.api.TelegramReactiveApi
import com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import rx.Observable
import java.io.IOException

interface TelegramClient : TelegramApi {

    fun close()

    @Throws(RpcErrorException::class, IOException::class)
    fun <T : TLObject> executeRpcQuery(method: TLMethod<T>): T

    /** Convenience method wrapping the argument with TelegramApp values */
    @Throws(RpcErrorException::class, IOException::class)
    fun authSendCode(phoneNumber: String, smsType: Int): TLAbsSentCode

    @Deprecated("Use authSendCode for more convenience", ReplaceWith("authSendCode(phoneNumber, smsType)"))
    override fun authSendCode(phoneNumber: String?, smsType: Int, apiId: Int, apiHash: String?, langCode: String?): TLAbsSentCode

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject?> invokeWithLayer18(query: TLMethod<T>?): T

    /** Convenience method wrapping the argument with TelegramApp values and casting result with good type */
    @Suppress("UNCHECKED_CAST")
    @Throws(RpcErrorException::class, IOException::class)
    fun <T : TLObject> initConnection(query: TLMethod<T>): T

    @Deprecated("Use initConnection for more convenience", ReplaceWith("initConnection(query)"))
    override fun <T : TLObject?> initConnection(apiId: Int, deviceModel: String?, systemVersion: String?, appVersion: String?, langCode: String?, query: TLMethod<T>?): T
}

interface TelegramReactiveClient : TelegramReactiveApi {

    fun close()

    fun <T : TLObject> executeRpcQuery(method: TLMethod<T>): Observable<T>

    /** Convenience method wrapping the argument with TelegramApp values */
    fun authSendCode(phoneNumber: String, smsType: Int): Observable<TLAbsSentCode>

    @Deprecated("Use authSendCode for more convenience", ReplaceWith("authSendCode(phoneNumber, smsType)"))
    override fun authSendCode(phoneNumber: String?, smsType: Int, apiId: Int, apiHash: String?, langCode: String?): Observable<TLAbsSentCode>

    override fun <T : TLObject?> invokeWithLayer18(query: TLMethod<T>?): Observable<T>

    /** Convenience method wrapping the argument with TelegramApp values and casting result with good type */
    @Suppress("UNCHECKED_CAST")
    fun <T : TLObject> initConnection(query: TLMethod<T>): Observable<T>

    @Deprecated("Use initConnection for more convenience", ReplaceWith("initConnection(query)"))
    override fun <T : TLObject?> initConnection(apiId: Int, deviceModel: String?, systemVersion: String?, appVersion: String?, langCode: String?, query: TLMethod<T>?): Observable<T>
}