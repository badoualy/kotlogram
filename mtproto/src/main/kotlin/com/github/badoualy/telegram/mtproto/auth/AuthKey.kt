package com.github.badoualy.telegram.mtproto.auth

import com.github.badoualy.telegram.mtproto.net.MTProtoConnection
import com.github.badoualy.telegram.mtproto.secure.CryptoUtils
import java.nio.ByteBuffer
import java.nio.ByteOrder

open class AuthKey(val key: ByteArray) {

    /**
     * Key identifier of this [AuthKey]. Lower 8 bytes of the SHA1 hash.
     * @see <a href="https://core.telegram.org/mtproto/description#key-identifier">MTProto description - Key Identifier</a>
     */
    val keyId = CryptoUtils.SHA1(key).takeLast(8).toByteArray()

    val keyIdAsLong: Long
        get() = ByteBuffer.wrap(keyId)
                .apply { order(ByteOrder.LITTLE_ENDIAN) }
                .long

    constructor(key: ByteBuffer) : this(key.array())

    init {
        if (key.size != 256)
            throw RuntimeException("AuthKey must be 256 bytes found ${key.size} bytes")
    }
}

class TempAuthKey(key: ByteArray, val expiresAt: Int) : AuthKey(key)

/**
 * Result of the "Creating an Authorization Key" flow execution
 * @see <a href="https://core.telegram.org/mtproto/auth_key">Creating an Authorization Key</a>
 * */
class AuthResult(val authKey: AuthKey, val serverSalt: Long, val connection: MTProtoConnection)