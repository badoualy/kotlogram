package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.DeserializeException
import com.github.badoualy.telegram.tl.StreamUtils.readBytes
import com.github.badoualy.telegram.tl.StreamUtils.writeByteArray
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLMethod
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
        val response = context.deserializeMessage(stream) ?: throw DeserializeException("Unable to deserialize response")
        if (response !is ResPQ) {
            throw DeserializeException("Response has incorrect type")
        }

        return response
    }

    override fun getClassId(): Int {
        return CLASS_ID
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
        @JvmStatic @JvmField
        val CLASS_ID = 1615239032
    }
}
