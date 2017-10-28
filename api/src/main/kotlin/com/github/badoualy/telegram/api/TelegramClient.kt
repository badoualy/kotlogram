package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.api.utils.InputFileLocation
import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.secure.CryptoUtils
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TelegramApi
import com.github.badoualy.telegram.tl.api.TelegramApiWrapper
import com.github.badoualy.telegram.tl.api.account.TLPassword
import com.github.badoualy.telegram.tl.api.upload.TLFile
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import io.reactivex.Observable
import io.reactivex.Single
import java.io.Closeable
import java.io.OutputStream

abstract class TelegramClient : TelegramApiWrapper(), TelegramApi, Closeable {

    abstract val app: TelegramApp

    abstract var closed: Boolean
        protected set

    /** Changes the request timeout with the supplied value (in ms) */
    abstract var timeout: Long

    /** Changes the timeout value for an exported handler to expire (and be closed) with the supplied value (in ms) */
    abstract var exportedClientTimeout: Long

    /**
     * Number of attempts to re-execute a request when an error occurs.
     * A method will not be re-executed if the result is a [com.github.badoualy.telegram.mtproto.tl.MTRpcError]
     */
    abstract var requestRetryCount: Int

    protected abstract var tag: LogTag

    /** Init the client (connect to Telegram). You should not be calling this in your main [Thread] */
    abstract fun init()

    abstract fun <T : TLObject> executeMethod(method: TLMethod<T>, dcId: Int): Single<T>

    abstract fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>): Observable<T>

    abstract fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>, dcId: Int): Observable<T>

    //abstract fun getDownloaderClient(): TelegramClient

    abstract fun sync(): TelegramSyncClient

    abstract fun downloadFile(inputFileLocation: InputFileLocation, size: Int): Observable<TLFile>

    //fun getUserPhoto(user: TLAbsUser, big: Boolean = true)

    //fun getChatPhoto(chat: TLAbsChat, big: Boolean = true)

    //fun getChannelPhoto(chat: TLAbsChat, big: Boolean = true)

    // region convenience overloads
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
    fun authCheckPassword(password: String) =
            accountGetPassword()
                    .flatMap { tlPassword ->
                        tlPassword as? TLPassword ?: throw RpcErrorException(400, "NO_PASSWORD")
                        CryptoUtils.encodePasswordHash(tlPassword.currentSalt.data,
                                                       password)?.let { hash ->
                            @Suppress("DEPRECATION")
                            authCheckPassword(TLBytes(hash))
                        }
                    }

    @Deprecated("Use authCheckPassword for more convenience",
                ReplaceWith("authCheckPassword(password)"))
    override fun authCheckPassword(passwordHash: TLBytes) = super.authCheckPassword(passwordHash)

    /** Convenience method wrapping the argument with TelegramApp values and casting result with good type */
    fun <T : TLObject> initConnection(query: TLMethod<T>) = with(app) {
        @Suppress("DEPRECATION")
        initConnection(apiId, deviceModel,
                       systemVersion, appVersion,
                       systemLangCode, langPack, langCode,
                       query)
    }

    @Deprecated("Use initConnection for more convenience", ReplaceWith("initConnection(query)"))
    override fun <T : TLObject> initConnection(apiId: Int,
                                               deviceModel: String,
                                               systemVersion: String, appVersion: String,
                                               systemLangCode: String,
                                               langPack: String,
                                               langCode: String,
                                               query: TLMethod<T>?) =
            super.initConnection(apiId, deviceModel, systemVersion, appVersion,
                                 systemLangCode, langPack, langCode, query)

    /** Convenience method wrapping the argument for a plain text message */
    fun messagesSendMessage(peer: TLAbsInputPeer, message: String, randomId: Long) =
            messagesSendMessage(true, false, false, false,
                                peer, null, message, randomId,
                                null, null)
}