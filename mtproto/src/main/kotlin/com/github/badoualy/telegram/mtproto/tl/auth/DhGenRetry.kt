package com.github.badoualy.telegram.mtproto.tl.auth

class DhGenRetry @JvmOverloads constructor(nonce: ByteArray = ByteArray(0), serverNonce: ByteArray = ByteArray(0),
                                           newNonceHash: ByteArray = ByteArray(0)) : DhGenResult(nonce, serverNonce, newNonceHash) {

    override fun getClassId(): Int {
        return CLASS_ID
    }

    override fun toString(): String {
        return "dh_gen_retry#46dc1fb9"
    }

    companion object {
        @JvmStatic @JvmField
        val CLASS_ID = 1188831161
    }
}
