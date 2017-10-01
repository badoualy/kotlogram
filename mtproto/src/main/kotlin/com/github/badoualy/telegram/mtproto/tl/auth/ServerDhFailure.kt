package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.readBytes
import com.github.badoualy.telegram.tl.StreamUtils.writeByteArray
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ServerDhFailure @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0),
                                                var serverNonce: ByteArray = ByteArray(0),
                                                var newNonceHash: ByteArray = ByteArray(0))
    : ServerDhParams() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeByteArray(nonce)
        writeByteArray(serverNonce)
        writeByteArray(newNonceHash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        nonce = readBytes(16)
        serverNonce = readBytes(16)
        newNonceHash = readBytes(16)
    }

    override fun toString() = "server_DH_params_fail#79cb045d"

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 2043348061
    }
}
