package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.readBytes
import com.github.badoualy.telegram.tl.StreamUtils.writeByteArray
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

abstract class DhGenResult constructor(var nonce: ByteArray, var serverNonce: ByteArray, var newNonceHash: ByteArray) : TLObject() {

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeByteArray(nonce, stream)
        writeByteArray(serverNonce, stream)
        writeByteArray(newNonceHash, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        nonce = readBytes(16, stream)
        serverNonce = readBytes(16, stream)
        newNonceHash = readBytes(16, stream)
    }
}
