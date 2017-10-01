package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

// TODO: doc, fake object
class MTMessage @JvmOverloads constructor(var messageId: Long = 0,
                                          var seqNo: Int = 0,
                                          var payload: ByteArray = ByteArray(0),
                                          var payloadLength: Int = payload.size) : TLObject() {

    override val constructorId: Int = 0

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeLong(messageId)
        writeInt(seqNo)
        writeInt(payloadLength)
        writeByteArray(payload, 0, payloadLength)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        messageId = readLong()
        seqNo = readInt()
        payloadLength = readInt()
        payload = ByteArray(payloadLength)
        readBytes(payload, 0, payloadLength)
        Unit
    }

    override fun toString(): String {
        return "MTMessage: {id: $messageId, seqNo: $seqNo}"
    }
}
