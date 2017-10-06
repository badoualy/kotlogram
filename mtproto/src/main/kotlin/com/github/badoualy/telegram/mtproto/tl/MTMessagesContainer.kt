package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.util.*

class MTMessagesContainer() : TLObject(), Iterable<MTProtoMessage> {

    val messages = TreeSet(Comparator<MTProtoMessage> { m1, m2 ->
        Math.signum((m1.messageId - m2.messageId).toDouble()).toInt()
    })

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(messages: Collection<MTProtoMessage>) : this() {
        this.messages.addAll(messages)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeInt(messages.size)
        for (message in messages) {
            message.serializeBody(tlSerializer)
        }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with(tlDeserializer) {
        val size = readInt()
        messages.clear()
        (0 until size)
                .map { MTProtoMessage().apply { deserializeBody(tlDeserializer) } }
                .toCollection(messages)

        Unit
    }

    override fun toString() = "msg_container#73f1f8dc"

    override fun iterator(): Iterator<MTProtoMessage> = messages.iterator()

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1945237724
    }
}
