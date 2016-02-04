package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.readBytes
import com.github.badoualy.telegram.tl.StreamUtils.writeByteArray
import com.github.badoualy.telegram.tl.TLContext
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ServerDhFailure @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0), var serverNonce: ByteArray = ByteArray(0),
                                                var newNonceHash: ByteArray = ByteArray(0)) : ServerDhParams() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

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

    override fun toString(): String {
        return "server_DH_params_fail#79cb045d"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 2043348061
    }
}
