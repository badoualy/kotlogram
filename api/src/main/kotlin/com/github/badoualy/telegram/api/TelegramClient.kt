package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.secure.CryptoUtils
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TelegramApi
import com.github.badoualy.telegram.tl.api.TelegramApiWrapper
import com.github.badoualy.telegram.tl.api.account.TLPassword
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization
import com.github.badoualy.telegram.tl.api.auth.TLSentCode
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import io.reactivex.Single
import java.io.Closeable

abstract class TelegramClient : TelegramApiWrapper(), TelegramApi, Closeable {

    abstract val application: TelegramApp

    abstract fun isClosed(): Boolean

    abstract fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>): List<T>

    abstract fun <T : TLObject> executeMethods(methods: List<TLMethod<T>>, dcId: Int): List<T>

    // region convenience overloads
    /** Convenience method wrapping the argument with [TelegramApp] values and without flashcall */
    fun authSendCode(phoneNumber: String) = authSendCode(false, phoneNumber, null)

    /** Convenience method wrapping the argument with [TelegramApp] values */
    fun authSendCode(allowFlashcall: Boolean, phoneNumber: String, currentNumber: Boolean?) =
            with(application) {
                @Suppress("DEPRECATION")
                authSendCode(allowFlashcall, phoneNumber, currentNumber, apiId, apiHash)
            }

    @Deprecated("Use one of the overload for more convenience",
                ReplaceWith("authSendCode(phoneNumber)"))
    abstract override fun authSendCode(allowFlashcall: Boolean, phoneNumber: String, currentNumber: Boolean?, apiId: Int, apiHash: String): Single<TLSentCode>

    /** Convenience method wrapping the argument with salt */
    fun authCheckPassword(password: String): Single<TLAuthorization> =
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
    abstract override fun authCheckPassword(passwordHash: TLBytes): Single<TLAuthorization>

    /** Convenience method wrapping the argument with TelegramApp values and casting result with good type */
    fun <T : TLObject> initConnection(query: TLMethod<T>) = with(application) {
        @Suppress("DEPRECATION")
        initConnection(apiId, deviceModel,
                       systemVersion, appVersion,
                       systemLangCode, langPack, langCode,
                       query)
    }

    @Deprecated("Use initConnection for more convenience", ReplaceWith("initConnection(query)"))
    abstract override fun <T : TLObject> initConnection(apiId: Int,
                                                        deviceModel: String,
                                                        systemVersion: String, appVersion: String,
                                                        systemLangCode: String,
                                                        langPack: String,
                                                        langCode: String,
                                                        query: TLMethod<T>?): Single<T>

    /** Convenience method wrapping the argument for a plain text message */
    fun messagesSendMessage(peer: TLAbsInputPeer, message: String, randomId: Long) =
            messagesSendMessage(true, false, false, false,
                                peer, null, message, randomId,
                                null, null)
}