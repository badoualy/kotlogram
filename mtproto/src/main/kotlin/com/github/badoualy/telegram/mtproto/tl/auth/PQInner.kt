package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

open class PQInner @JvmOverloads constructor(var pq: ByteArray = ByteArray(0),
                                             var p: ByteArray = ByteArray(0),
                                             var q: ByteArray = ByteArray(0),
                                             var nonce: ByteArray = ByteArray(0),
                                             var serverNonce: ByteArray = ByteArray(0),
                                             var newNonce: ByteArray = ByteArray(0)) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeTLBytes(pq)
        writeTLBytes(p)
        writeTLBytes(q)
        writeByteArray(nonce)
        writeByteArray(serverNonce)
        writeByteArray(newNonce)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        pq = readTLBytesAsBytes()
        p = readTLBytesAsBytes()
        q = readTLBytesAsBytes()
        nonce = readBytes(16)
        serverNonce = readBytes(16)
        newNonce = readBytes(32)
    }

    override fun toString() = "p_q_inner_data#83c95aec"

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -2083955988
    }
}
