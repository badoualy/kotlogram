package com.github.badoualy.telegram.mtproto.auth


import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.secure.MTProtoMessageEncryption
import com.github.badoualy.telegram.mtproto.secure.RandomUtils
import com.github.badoualy.telegram.mtproto.tl.MTProtoMessage
import com.github.badoualy.telegram.mtproto.tl.MTRpcResult
import com.github.badoualy.telegram.mtproto.tl.auth.BindAuthKeyInner
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthBindTempAuthKey
import com.github.badoualy.telegram.tl.core.TLBytes
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import java.io.IOException
import java.util.*


/**
 * Helper class to execute the "Bind a temporary authorization key" flow
 * @see <a href="https://core.telegram.org/method/auth.bindTempAuthKey">MTProto description - Bind auth key</a>
 */
object TempAuthKeyBinding {

    private val TAG = "TempAuthKeyBinding"

    /**
     * Binds a temporary authorization key temp_auth_key_id to the permanent authorization key perm_auth_key_id.
     * Each permanent key may only be bound to one temporary key at a time, binding a new temporary key overwrites the previous one.
     * @param tempAuthKey temporary key to be bound
     * @param authKey permanent key
     * @param mtProtoHandler current handler using the temporary auth key
     * @return true if the key was bound, false else
     */
    @Throws(IOException::class)
    @JvmStatic
    fun bindKey(tempAuthKey: TempAuthKey, authKey: AuthKey, mtProtoHandler: MTProtoHandler): Single<MTRpcResult> {
        if (!Arrays.equals(mtProtoHandler.authKey.keyId, tempAuthKey.keyId))
            throw IllegalArgumentException(
                    "The handler must use the temporary authorization key that you want to bind")

        // Generate inner binding message
        val bindInner = BindAuthKeyInner(nonce = RandomUtils.randomLong(),
                                         tempAuthKeyId = tempAuthKey.keyId,
                                         permAuthKeyId = authKey.keyId,
                                         tempSessionId = mtProtoHandler.session.id,
                                         expiresAt = tempAuthKey.expiresAt)

        val innerMessage = MTProtoMessage(messageId = mtProtoHandler.session.generateMessageId(),
                                          seqNo = 0,
                                          payload = bindInner.serialize())

        val encryptedInnerMessage = MTProtoMessageEncryption.generateEncryptedMessage(
                authKey = authKey,
                sessionId = RandomUtils.randomSessionId(),
                serverSalt = RandomUtils.randomLong(),
                message = innerMessage)

        // Actual request
        val request = TLRequestAuthBindTempAuthKey(authKey.keyIdAsLong,
                                                   bindInner.nonce,
                                                   bindInner.expiresAt,
                                                   TLBytes(encryptedInnerMessage.data))

        val message = MTProtoMessage(innerMessage.messageId,
                                     mtProtoHandler.session.generateSeqNo(request),
                                     request.serialize())

        val encryptedMessage = MTProtoMessageEncryption.generateEncryptedMessage(
                authKey = authKey,
                sessionId = mtProtoHandler.session.id,
                serverSalt = mtProtoHandler.session.salt,
                message = message)

        return mtProtoHandler.rpcResultObservable
                .filter { it.messageId == innerMessage.messageId }
                .doOnSubscribe { mtProtoHandler.sendMessage(encryptedMessage.data) }
                .subscribeOn(Schedulers.io())
                .observeOn(Schedulers.computation())
                .singleOrError()
    }
}
