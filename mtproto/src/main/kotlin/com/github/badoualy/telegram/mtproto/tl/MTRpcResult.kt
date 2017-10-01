package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

class MTRpcResult @JvmOverloads constructor(var messageId: Long = 0,
                                            var content: ByteArray = ByteArray(0),
                                            var contentLen: Int = 0) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeLong(messageId)
        writeByteArray(content, 0, contentLen)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        messageId = readLong()
        contentLen = tlDeserializer.available()
        content = tlDeserializer.readBytes(contentLen)
    }

    override fun toString(): String {
        return "rpc_result#f35c6d01"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -212046591
    }
}
