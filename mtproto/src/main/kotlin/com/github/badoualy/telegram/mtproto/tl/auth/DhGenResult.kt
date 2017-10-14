package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

abstract class DhGenResult constructor(var nonce: ByteArray,
                                       var serverNonce: ByteArray,
                                       var newNonceHash: ByteArray) : TLObject() {

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
}
