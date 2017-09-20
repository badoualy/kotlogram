package com.github.badoualy.telegram.mtproto.tl.auth

class DhGenFailure @JvmOverloads constructor(nonce: ByteArray = ByteArray(0),
                                             serverNonce: ByteArray = ByteArray(0),
                                             newNonceHash: ByteArray = ByteArray(0))
    : DhGenResult(nonce, serverNonce, newNonceHash) {

    override val constructorId: Int = CONSTRUCTOR_ID

    override fun toString() = "dh_gen_fail#a69dae02"

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -1499615742
    }
}
