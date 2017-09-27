package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTMessageDetailedInfo @JvmOverloads constructor(var msgId: Long = 0,
                                                      var answerMsgId: Long = 0,
                                                      var bytes: Int = 0,
                                                      var state: Int = 0) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeLong(msgId)
        writeLong(answerMsgId)
        writeInt(bytes)
        writeInt(state)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        msgId = readLong(stream)
        answerMsgId = readLong(stream)
        bytes = readInt(stream)
        state = readInt(stream)
    }

    override fun toString(): String {
        return "msg_detailed_info#276d3ec6"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 661470918
    }
}
