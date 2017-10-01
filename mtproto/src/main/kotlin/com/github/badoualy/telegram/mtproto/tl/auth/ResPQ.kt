package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ResPQ @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0),
                                      var serverNonce: ByteArray = ByteArray(0),
                                      var pq: ByteArray = ByteArray(0),
                                      var fingerprints: TLLongVector = TLLongVector()) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeByteArray(nonce)
        writeByteArray(serverNonce)
        writeTLBytes(pq)
        writeTLVector(fingerprints)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        nonce = readBytes(16)
        serverNonce = readBytes(16)
        pq = readTLBytesAsBytes()
        fingerprints = readTLLongVector()
    }

    override fun toString(): String {
        return "resPQ#05162463"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 85337187
    }
}
