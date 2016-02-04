package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.readBytes
import com.github.badoualy.telegram.tl.StreamUtils.writeByteArray
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.exception.DeserializationException
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class ReqPQ constructor(nonce: ByteArray? = null) : TLMethod<ResPQ>() {

    var nonce: ByteArray = ByteArray(0)
        set(nonce) {
            if (nonce.size != 16) {
                throw IllegalArgumentException("nonce might be not null and 16 bytes length")
            }
            field = nonce
        }

    init {
        if (nonce?.size ?: 0 != 16)
            throw IllegalArgumentException("nonce might be not null and 16 bytes length")
        this.nonce = nonce!!
    }

    @Throws(IOException::class)
    override fun deserializeResponse(stream: InputStream, context: TLContext): ResPQ {
        val response = context.deserializeMessage(stream) ?: throw DeserializationException("Unable to deserialize response")
        if (response !is ResPQ) {
            throw DeserializationException("Response has incorrect type")
        }

        return response
    }

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeByteArray(nonce, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        nonce = readBytes(16, stream)
    }

    override fun toString(): String {
        return "req_pq#60469778"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1615239032
    }
}
