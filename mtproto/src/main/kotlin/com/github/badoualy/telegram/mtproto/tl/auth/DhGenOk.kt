package com.github.badoualy.telegram.mtproto.tl.auth

class DhGenOk @JvmOverloads constructor(nonce: ByteArray = ByteArray(0), serverNonce: ByteArray = ByteArray(0),
                                        newNonceHash: ByteArray = ByteArray(0)) : DhGenResult(nonce, serverNonce, newNonceHash) {

    override fun getConstructorId(): Int {
        return CLASS_ID
    }

    override fun toString(): String {
        return "dh_gen_ok#3bcbf734"
    }

    companion object {
        @JvmStatic @JvmField
        val CLASS_ID = 1003222836
    }
}
