package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

class ReqPQ constructor(nonce: ByteArray? = null) : TLMethod<ResPQ>() {

    var nonce: ByteArray = ByteArray(0)
        set(nonce) {
            if (nonce.size != 16) {
                throw IllegalArgumentException("nonce might be not null and 16 bytes length")
            }
            field = nonce
        }

    override val constructorId: Int = CONSTRUCTOR_ID

    init {
        if (nonce?.size ?: 0 != 16)
            throw IllegalArgumentException("nonce might be not null and 16 bytes length")
        this.nonce = nonce!!
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeByteArray(nonce)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        nonce = readBytes(16)
    }

    override fun toString(): String {
        return "req_pq#60469778"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1615239032
    }
}
