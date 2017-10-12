package com.github.badoualy.telegram.mtproto.exception

import com.github.badoualy.telegram.mtproto.tl.MTMessagesContainer
import java.math.BigInteger

open class MTProtoException : Exception {
    constructor()
    constructor(message: String) : super(message)
    constructor(message: String, throwable: Throwable) : super(message, throwable)
    constructor(throwable: Throwable) : super(throwable)
}

open class SecurityException(message: String) : MTProtoException(message)
class FingerprintNotFoundException(s: String) : SecurityException(s)

class AuthorizationException(message: String) : MTProtoException(message)
class AuthKeyInvalidException(errorCode: Int) : MTProtoException("AUTH_KEY_INVALID (error code $errorCode)")
class AuthKeyIdDontMatchException(found: ByteArray, expected: ByteArray) : MTProtoException(
        "The authKey id received doesn't match current auth key, expected ${BigInteger(expected).toLong()}, " +
                "found ${BigInteger(found).toLong()}")

class MessageDecryptionException(message: String) : SecurityException(message)

class ContainerInvalidException(container: MTMessagesContainer) : MTProtoException(
        "Container has message(s) with invalid id: " +
                container.messages.joinToString() { it.messageId.toString() })