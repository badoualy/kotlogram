package com.github.badoualy.telegram.mtproto.auth

import com.github.badoualy.telegram.mtproto.secure.CryptoUtils
import com.github.badoualy.telegram.mtproto.transport.MTProtoConnection
import java.math.BigInteger
import java.nio.ByteBuffer

open class AuthKey(val key: ByteArray) {

    constructor(key: ByteBuffer) : this(key.array())

    init {
        if (key.size != 256)
            throw RuntimeException("AuthKey must be 256 Bytes found ${key.size} bytes")
    }

    // see https://core.telegram.org/mtproto/description#key-identifier
    // SHA1 generates 20 bytes long hash, authKeyId is the lower 8 bytes
    val keyId = CryptoUtils.substring(CryptoUtils.SHA1(key), 12, 8)!!

    val keyIdAsLong = BigInteger(keyId).toLong()
}

class TempAuthKey(key: ByteArray, val expiresAt: Int) : AuthKey(key)

/**
 * Result of the "Creating an Authorization Key" flow execution
 * @see <a href="https://core.telegram.org/mtproto/auth_key">Creating an Authorization Key</a>
 * */
class AuthResult(val authKey: AuthKey, val serverSalt: Long, val connection: MTProtoConnection)