package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.mtproto.exception.RpcErrorException
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode
import com.github.badoualy.telegram.tl.api.upload.TLFile
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

    /** Convenience method to download an user profile photo */
    @JvmOverloads
    @Throws(RpcErrorException::class, IOException::class)
    fun getUserPhoto(user: TLUserFull, big: Boolean = true): TLFile? {
        val userPhoto = user.profilePhoto

        val photoLocation = when (userPhoto) {
            is TLUserProfilePhoto -> if (big) userPhoto.photoBig else userPhoto.photoSmall
            else -> null
        } ?: return null

        val inputLocation = TLInputFileLocation(photoLocation.volumeId, photoLocation.localId, photoLocation.secret)
        return uploadGetFile(inputLocation, 0, 0)
    }

    /** Convenience method to download an user profile photo */
    @JvmOverloads
    @Throws(RpcErrorException::class, IOException::class)
    fun getUserPhoto(user: TLAbsUser, big: Boolean = true): TLFile? {
        val userPhoto = when (user) {
            is TLUserSelf -> user.photo
            is TLUserContact -> user.photo
            is TLUserRequest -> user.photo
            is TLUserForeign -> user.photo
            is TLUserEmpty, is TLUserDeleted -> null
            else -> null
        } ?: return null

        val photoLocation = when (userPhoto) {
            is TLUserProfilePhoto -> if (big) userPhoto.photoBig else userPhoto.photoSmall
            else -> null
        } ?: return null

        val inputLocation = TLInputFileLocation(photoLocation.volumeId, photoLocation.localId, photoLocation.secret)
        return uploadGetFile(inputLocation, 0, 0)
    }

    /** Convenience method to download a chat photo */
    @JvmOverloads
    @Throws(RpcErrorException::class, IOException::class)
    fun getChatPhoto(chat: TLChatFull, big: Boolean = true): TLFile? {
        val chatPhoto = chat.chatPhoto

        val photoLocation = when (chatPhoto) {
            is TLChatPhoto -> if (big) chatPhoto.photoBig else chatPhoto.photoSmall
            else -> null
        } ?: return null

        val inputLocation = TLInputFileLocation(photoLocation.volumeId, photoLocation.localId, photoLocation.secret)
        return uploadGetFile(inputLocation, 0, 0)
    }

    /** Convenience method to download a chat photo */
    @JvmOverloads
    @Throws(RpcErrorException::class, IOException::class)
    fun getChatPhoto(chat: TLAbsChat, big: Boolean = true): TLFile? {
        val chatPhoto = when (chat) {
            is TLChat -> chat.photo
            is TLChatEmpty, is TLChatForbidden -> null
            else -> null
        } ?: return null

        val photoLocation = when (chatPhoto) {
            is TLChatPhoto -> if (big) chatPhoto.photoBig else chatPhoto.photoSmall
            else -> null
        } ?: return null

        val inputLocation = TLInputFileLocation(photoLocation.volumeId, photoLocation.localId, photoLocation.secret)
        return uploadGetFile(inputLocation, 0, 0)
    }
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