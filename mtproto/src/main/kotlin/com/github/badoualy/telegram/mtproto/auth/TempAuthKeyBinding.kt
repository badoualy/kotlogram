package com.github.badoualy.telegram.mtproto.auth


import com.github.badoualy.telegram.mtproto.MTProtoHandler
import com.github.badoualy.telegram.mtproto.secure.MTProtoMessageEncryption
import com.github.badoualy.telegram.mtproto.secure.RandomUtils
import com.github.badoualy.telegram.mtproto.tl.MTMessage
import com.github.badoualy.telegram.mtproto.tl.auth.BindAuthKeyInner
import com.github.badoualy.telegram.tl.api.request.TLRequestAuthBindTempAuthKey
import com.github.badoualy.telegram.tl.core.TLBytes
import java.io.IOException
import java.math.BigInteger
import java.util.*


/**
 * Helper class to execute the "Bind a temporary authorization key" flow
 * @see [bindTempAuthKey](https://core.telegram.org/method/auth.bindTempAuthKey)
 */
object TempAuthKeyBinding {

    private val TAG = "TempAuthKeyBinding"

    /**
     * Binds a temporary authorization key temp_auth_key_id to the permanent authorization key perm_auth_key_id.
     * Each permanent key may only be bound to one temporary key at a time, binding a new temporary key overwrites the previous one.
     * @param tempAuthKey temporary key to be bound
     * *
     * @param authKey permanent key
     * *
     * @param mtProtoHandler current handler using the temporary auth key
     * *
     * @return true if the key was bound, false else
     */
    @Throws(IOException::class)
    @JvmStatic
    fun bindKey(tempAuthKey: TempAuthKey, authKey: AuthKey, mtProtoHandler: MTProtoHandler): Boolean {
        if (!Arrays.equals(mtProtoHandler.authKey!!.keyId, tempAuthKey.keyId))
            throw IllegalStateException("The MTProtoHandler must use the temporary authorization key that you want to bind")

        val nonce = BigInteger(RandomUtils.randomByteArray(8)).toLong()

        val bindingMessage = BindAuthKeyInner(nonce,
                                              tempAuthKey.keyIdAsLong, authKey.keyIdAsLong,
                                              mtProtoHandler.session.id, tempAuthKey.expiresAt)

        val randomPart1 = RandomUtils.randomByteArray(8) // replace session_id
        val randomPart2 = RandomUtils.randomLong() // replace salt

        // Build inner message
        val msgId = 0L //TimeOverlord.generateMessageId()
        val mtBindingMessage = MTMessage(msgId, 0, bindingMessage.serialize())
        val encryptedMessage = MTProtoMessageEncryption.encrypt(authKey, randomPart1, randomPart2, mtBindingMessage)

        // Build request
        val request = TLRequestAuthBindTempAuthKey(authKey.keyIdAsLong, nonce,
                                                   tempAuthKey.expiresAt,
                                                   TLBytes(encryptedMessage.data))
        @Suppress("UNUSED_VARIABLE")
        val message = MTMessage(msgId, 0, request.serialize())

        return false
    }
}
