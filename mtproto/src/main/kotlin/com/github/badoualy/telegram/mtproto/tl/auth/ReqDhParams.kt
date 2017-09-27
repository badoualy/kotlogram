package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.DeserializationException
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ReqDhParams @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0),
                                            var serverNonce: ByteArray = ByteArray(0),
                                            var p: ByteArray = ByteArray(0),
                                            var q: ByteArray = ByteArray(0),
                                            var fingerPrint: Long = 0,
                                            var encryptedData: ByteArray = ByteArray(0))
    : TLMethod<ServerDhParams>() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeByteArray(nonce)
        writeByteArray(serverNonce)
        writeTLBytes(p)
        writeTLBytes(q)
        writeLong(fingerPrint)
        writeTLBytes(encryptedData)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        nonce = readBytes(16, stream)
        serverNonce = readBytes(16, stream)
        p = readTLBytes(stream)
        q = readTLBytes(stream)
        fingerPrint = readLong(stream)
        encryptedData = readTLBytes(stream)
    }

    @Throws(IOException::class)
    override fun deserializeResponse(stream: InputStream, context: TLContext): ServerDhParams {
        val response = context.deserializeMessage<TLObject>(stream) as? ServerDhParams
                ?: throw DeserializationException("Response has incorrect type")

        return response
    }

    override fun toString() = "req_DH_params#d712e4be"

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -686627650
    }
}
