package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ServerDhInner @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0),
                                              var serverNonce: ByteArray = ByteArray(0),
                                              var g: Int = 0,
                                              var dhPrime: ByteArray = ByteArray(0),
                                              var g_a: ByteArray = ByteArray(0),
                                              var serverTime: Int = 0) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeByteArray(nonce)
        writeByteArray(serverNonce)
        writeInt(g)
        writeTLBytes(dhPrime)
        writeTLBytes(g_a)
        writeInt(serverTime)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        nonce = readBytes(16)
        serverNonce = readBytes(16)
        g = readInt()
        dhPrime = readTLBytesAsBytes()
        g_a = readTLBytesAsBytes()
        serverTime = readInt()
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -1249309254
    }
}
