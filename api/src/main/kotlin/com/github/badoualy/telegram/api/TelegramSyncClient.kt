package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.api.utils.InputFileLocation
import com.github.badoualy.telegram.mtproto.secure.CryptoUtils
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputClientProxy
import com.github.badoualy.telegram.tl.api.TelegramSyncApiWrapper
import com.github.badoualy.telegram.tl.api.account.TLPassword
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import io.reactivex.schedulers.Schedulers
import java.io.OutputStream

/**
 * A Telegram client to make synchronous rpc calls.
 */
abstract class TelegramSyncClient : TelegramSyncApiWrapper() {

    abstract val app: TelegramApp

    abstract fun downloadFile(inputFileLocation: InputFileLocation, size: Int, outputStream: OutputStream)

    /** Convenience method wrapping the argument with [TelegramApp] values and without flashcall */
    fun authSendCode(phoneNumber: String) = authSendCode(false, phoneNumber, null)

    /** Convenience method wrapping the argument with [TelegramApp] values */
    fun authSendCode(allowFlashcall: Boolean, phoneNumber: String, currentNumber: Boolean?) =
            with(app) {
                @Suppress("DEPRECATION")
                authSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash)
            }

    @Deprecated("Use one of the overload for more convenience",
                ReplaceWith("authSendCode(phoneNumber)"))
    override fun authSendCode(allowFlashcall: Boolean, phoneNumber: String, currentNumber: Boolean?, apiId: Int, apiHash: String) =
            super.authSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash)

    /** Convenience method wrapping the argument with salt */
    fun authCheckPassword(password: String): TLAuthorization {
        val tlPassword = accountGetPassword() as? TLPassword ?:
                throw RpcErrorException(400, "NO_PASSWORD")
        val hash = CryptoUtils.encodePasswordHash(tlPassword.currentSalt.data, password)

        @Suppress("DEPRECATION")
        return authCheckPassword(TLBytes(hash))
    }

    @Deprecated("Use authCheckPassword for more convenience",
                ReplaceWith("authCheckPassword(password)"))
    override fun authCheckPassword(passwordHash: TLBytes) = super.authCheckPassword(passwordHash)

    /** Convenience method wrapping the argument with TelegramApp values and casting result with good type */
    fun <T : TLObject> initConnection(query: TLMethod<T>) = with(app) {
        @Suppress("DEPRECATION")
        initConnection(apiId, deviceModel,
                       systemVersion, appVersion,
                       systemLangCode, langPack, langCode,null,
                       query)
    }

    @Deprecated("Use initConnection for more convenience", ReplaceWith("initConnection(query)"))
    override fun <T : TLObject> initConnection(apiId: Int,
                                               deviceModel: String,
                                               systemVersion: String, appVersion: String,
                                               systemLangCode: String,
                                               langPack: String,
                                               langCode: String,
                                               proxy: TLInputClientProxy?,
                                               query: TLMethod<T>?) =
            super.initConnection(apiId, deviceModel, systemVersion, appVersion,
                                 systemLangCode, langPack, langCode,null, query)

    /** Convenience method wrapping the argument for a plain text message */
    fun messagesSendMessage(peer: TLAbsInputPeer, message: String, randomId: Long) =
            messagesSendMessage(true, false, false, false,
                                peer, null, message, randomId,
                                null, null)
}

/**
 * A [TelegramSyncClient] implementation that'll delegate the request execution to a [TelegramClient]
 * and transform the calls to a synchronous behavior using
 * [io.reactivex.Single.blockingGet] or [io.reactivex.Observable.blockingIterable]
 */
internal class TelegramSyncClientImpl(val client: TelegramClient) : TelegramSyncClient() {

    override val app: TelegramApp
        get() = client.app

    override fun <T : TLObject> executeMethod(method: TLMethod<T>): T = try {
        client.executeMethod(method).blockingGet()
    } catch (e: RuntimeException) {
        throw e.unwrapRpcError()
    }

    override fun downloadFile(inputFileLocation: InputFileLocation, size: Int, outputStream: OutputStream) {
        try {
            client.downloadFile(inputFileLocation, size)
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.io())
                    .blockingIterable()
                    .forEach {
                        outputStream.write(it.bytes.data)
                    }

            outputStream.flush()
            outputStream.close()
        } catch (e: RuntimeException) {
            throw   e.unwrapRpcError()
        }
    }

    companion object {
        @Throws(Throwable::class)
        fun Throwable.unwrapRpcError() =
                when (cause) {
                    is RpcErrorException -> cause as RpcErrorException
                    else -> this
                }
    }
}