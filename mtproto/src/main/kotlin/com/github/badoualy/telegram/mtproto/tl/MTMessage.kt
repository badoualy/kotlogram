package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTMessage @JvmOverloads constructor(var messageId: Long = 0, var seqNo: Int = 0, var payload: ByteArray = ByteArray(0), var  payloadLength: Int = payload.size) : TLObject() {

    override fun getConstructorId(): Int {
        return 0
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeLong(messageId, stream)
        writeInt(seqNo, stream)
        writeInt(payloadLength, stream)
        writeByteArray(payload, 0, payloadLength, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        messageId = readLong(stream)
        seqNo = readInt(stream)
        payloadLength = readInt(stream)
        payload = ByteArray(payloadLength)
        readBytes(payload, 0, payloadLength, stream)
    }

    override fun toString(): String {
        return "MTMessage: {id: $messageId, seqNo: $seqNo}"
    }
}
