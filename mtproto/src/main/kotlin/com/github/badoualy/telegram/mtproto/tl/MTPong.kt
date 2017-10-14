package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

class MTPong @JvmOverloads constructor(var messageId: Long = 0, var pingId: Long = 0) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeLong(messageId)
        writeLong(pingId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        messageId = readLong()
        pingId = readLong()
    }

    override fun toString(): String {
        return "pong#347773c5"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 880243653
    }
}
