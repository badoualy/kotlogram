package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

open class PQInner @JvmOverloads constructor(var pq: ByteArray = ByteArray(0),
                                             var p: ByteArray = ByteArray(0), var q: ByteArray = ByteArray(0),
                                             var nonce: ByteArray = ByteArray(0), var serverNonce: ByteArray = ByteArray(0),
                                             var newNonce: ByteArray = ByteArray(0)) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeTLBytes(pq, stream)
        writeTLBytes(p, stream)
        writeTLBytes(q, stream)
        writeByteArray(nonce, stream)
        writeByteArray(serverNonce, stream)
        writeByteArray(newNonce, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        pq = readTLBytes(stream)
        p = readTLBytes(stream)
        q = readTLBytes(stream)
        nonce = readBytes(16, stream)
        serverNonce = readBytes(16, stream)
        newNonce = readBytes(32, stream)
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -2083955988
    }
}
