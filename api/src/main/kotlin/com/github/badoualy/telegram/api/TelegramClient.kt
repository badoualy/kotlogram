package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.api.auth.TLSentCode
import com.github.badoualy.telegram.tl.api.request.TLRequestUploadGetFile
import com.github.badoualy.telegram.tl.api.upload.TLFile
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException

interface TelegramClient : TelegramApi {

    /** Changes the request timeout with the supplied value (in ms) */
    fun setTimeout(timeout: Long)

    /** Close connection to Telegram and stop everything */
    fun close()

    /** Close connection, and clean the threads if cleanUp is true */
    fun close(cleanUp: Boolean)

    /**
     * Queue a method to be executed with the next message.
     * @param method method to execute
     * @param timeout validity duration in ms, if nothing is sent during this period, this method will be discarded
     */
    open fun <T : TLObject> queueMethod(method: TLMethod<T>, timeout: Long): Unit?

    @Throws(RpcErrorException::class, IOException::class)
    fun <T : TLObject> executeRpcQuery(method: TLMethod<T>): T

    @Throws(RpcErrorException::class, IOException::class)
    fun <T : TLObject> executeRpcQuery(method: TLMethod<T>, dcId: Int): T

    /** Convenience method wrapping the argument with TelegramApp values */
    @Throws(RpcErrorException::class, IOException::class)
    fun authSendCode(phoneNumber: String, smsType: Int): TLSentCode

    /** Convenience method wrapping the argument with TelegramApp values */
    @Throws(RpcErrorException::class, IOException::class)
    fun authSendCode(allowFlashcall: Boolean, phoneNumber: String, currentNumber: Boolean): TLSentCode

    @Deprecated("Use authSendCode for more convenience", ReplaceWith("authSendCode(allowFlashcall, phoneNumber, currentNumber)"))
    override fun authSendCode(allowFlashcall: Boolean, phoneNumber: String?, currentNumber: Boolean, apiId: Int, apiHash: String?, langCode: String?): TLSentCode

    @Throws(RpcErrorException::class, IOException::class)
    override fun <T : TLObject?> invokeWithLayer(layer: Int, query: TLMethod<T>?): T

    /** Convenience method wrapping the argument with TelegramApp values and casting result with good type */
    @Suppress("UNCHECKED_CAST")
    @Throws(RpcErrorException::class, IOException::class)
    fun <T : TLObject> initConnection(query: TLMethod<T>): T

    @Deprecated("Use initConnection for more convenience", ReplaceWith("initConnection(query)"))
    override fun <T : TLObject?> initConnection(apiId: Int, deviceModel: String, systemVersion: String, appVersion: String, langCode: String, query: TLMethod<T>): T

    /** Convenience method wrapping the argument for a plain text message */
    fun messagesSendMessage(peer: TLAbsInputPeer, message: String, randomId: Long): TLAbsUpdates?

    /** Convenience method to download an user profile photo */
    @Throws(RpcErrorException::class, IOException::class)
    fun getUserPhoto(user: TLAbsUser, big: Boolean = true): TLFile? {
        val userPhoto = when (user) {
            is TLUser -> user.photo
            is TLUserEmpty -> null
            else -> null
        } ?: return null

        val photoLocation = when (userPhoto) {
            is TLUserProfilePhoto -> if (big) userPhoto.photoBig else userPhoto.photoSmall
            else -> null
        } ?: return null

        if (photoLocation !is TLFileLocation)
            return null

        val inputLocation = TLInputFileLocation(photoLocation.volumeId, photoLocation.localId, photoLocation.secret)
        val request = TLRequestUploadGetFile(inputLocation, 0, 0)
        return executeRpcQuery(request, photoLocation.dcId)
    }

    /** Convenience method to download a chat photo */
    @Throws(RpcErrorException::class, IOException::class)
    fun getChatPhoto(chat: TLAbsChat, big: Boolean = true): TLFile? {
        val chatPhoto = when (chat) {
            is TLChat -> chat.photo
            is TLChannel -> chat.photo
            is TLChatEmpty, is TLChatForbidden -> null
            else -> null
        } ?: return null

        val photoLocation = when (chatPhoto) {
            is TLChatPhoto -> if (big) chatPhoto.photoBig else chatPhoto.photoSmall
            else -> null
        } ?: return null

        if (photoLocation !is TLFileLocation)
            return null

        val inputLocation = TLInputFileLocation(photoLocation.volumeId, photoLocation.localId, photoLocation.secret)
        val request = TLRequestUploadGetFile(inputLocation, 0, 0)
        return executeRpcQuery(request, photoLocation.dcId)
    }

    /** Convenience method to download a channel photo */
    @Throws(RpcErrorException::class, IOException::class)
    fun getChannelPhoto(chat: TLAbsChat, big: Boolean = true) = getChatPhoto(chat, big)
}