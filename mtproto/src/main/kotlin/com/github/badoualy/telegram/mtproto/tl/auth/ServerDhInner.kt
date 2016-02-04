package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ServerDhInner @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0), var serverNonce: ByteArray = ByteArray(0),
                                              var g: Int = 0, var dhPrime: ByteArray = ByteArray(0),
                                              var g_a: ByteArray = ByteArray(0), var serverTime: Int = 0) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeByteArray(nonce, stream)
        writeByteArray(serverNonce, stream)
        writeInt(g, stream)
        writeTLBytes(dhPrime, stream)
        writeTLBytes(g_a, stream)
        writeInt(serverTime, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        nonce = readBytes(16, stream)
        serverNonce = readBytes(16, stream)
        g = readInt(stream)
        dhPrime = readTLBytes(stream)
        g_a = readTLBytes(stream)
        serverTime = readInt(stream)
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -1249309254
    }
}
