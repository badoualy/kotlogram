package com.github.badoualy.telegram.mtproto.tl.auth

class DhGenFailure @JvmOverloads constructor(nonce: ByteArray = ByteArray(0), serverNonce: ByteArray = ByteArray(0),
                                             newNonceHash: ByteArray = ByteArray(0)) : DhGenResult(nonce, serverNonce, newNonceHash) {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    override fun toString(): String {
        return "dh_gen_fail#a69dae02"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -1499615742
    }
}
