package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTRpcResult @JvmOverloads constructor(var messageId: Long = 0, var content: ByteArray = ByteArray(0), var contentLen: Int = 0) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeLong(messageId, stream)
        writeByteArray(content, 0, contentLen, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        messageId = readLong(stream)
        contentLen = stream.available()
        content = ByteArray(contentLen)
        readBytes(content, 0, contentLen, stream)
    }

    override fun toString(): String {
        return "rpc_result#f35c6d01"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -212046591
    }
}
