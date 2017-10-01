package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

class MTNewMessageDetailedInfo @JvmOverloads constructor(var answerMsgId: Long = 0,
                                                         var bytes: Int = 0,
                                                         var status: Int = 0) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeLong(answerMsgId)
        writeInt(bytes)
        writeInt(status)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        answerMsgId = readLong()
        bytes = readInt()
        status = readInt()
    }

    override fun toString(): String {
        return "msg_new_detailed_info#809db6df"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -2137147681
    }
}
