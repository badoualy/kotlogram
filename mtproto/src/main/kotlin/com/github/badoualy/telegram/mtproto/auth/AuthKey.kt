package com.github.badoualy.telegram.mtproto.auth

import com.github.badoualy.telegram.mtproto.secure.CryptoUtils
import java.math.BigInteger

open class AuthKey(val key: ByteArray) {
    // see https://core.telegram.org/mtproto/description#key-identifier
    // SHA1 generates 20 bytes long hash, authKeyId is the lower 8 bytes
    val keyId = CryptoUtils.substring(CryptoUtils.SHA1(key), 12, 8)

    fun getKeyIdAsLong() = BigInteger(keyId).longValueExact()
}

class TempAuthKey(key: ByteArray, val expiresAt: Int) : AuthKey(key)