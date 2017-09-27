package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.exception.DeserializationException
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ReqSetDhClientParams @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0),
                                                     var serverNonce: ByteArray = ByteArray(0),
                                                     var encrypted: ByteArray = ByteArray(0))
    : TLMethod<DhGenResult>() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeByteArray(nonce)
        writeByteArray(serverNonce)
        writeTLBytes(encrypted)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        nonce = readBytes(16, stream)
        serverNonce = readBytes(16, stream)
        encrypted = readTLBytes(stream)
    }

    @Throws(IOException::class)
    override fun deserializeResponse(stream: InputStream, context: TLContext): DhGenResult {
        val response = context.deserializeMessage(stream) ?: throw DeserializationException(
                "Unable to deserialize response")
        if (response !is DhGenResult) {
            throw DeserializationException("Response has incorrect type")
        }
        return response
    }

    override fun toString() = "set_client_DH_params#f5045f1f"

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -184262881
    }
}