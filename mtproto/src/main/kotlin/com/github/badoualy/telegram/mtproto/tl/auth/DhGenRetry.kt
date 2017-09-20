package com.github.badoualy.telegram.mtproto.tl.auth

class DhGenRetry @JvmOverloads constructor(nonce: ByteArray = ByteArray(0),
                                           serverNonce: ByteArray = ByteArray(0),
                                           newNonceHash: ByteArray = ByteArray(0))
    : DhGenResult(nonce, serverNonce, newNonceHash) {

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = "dh_gen_retry#46dc1fb9"

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1188831161
    }
}
