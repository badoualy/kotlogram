package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.readInt
import com.github.badoualy.telegram.tl.StreamUtils.writeInt
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.*

class MTMessagesContainer : TLObject {

    val messages = TreeSet(Comparator<MTMessage> { m1, m2 ->
        Math.signum((m1.messageId - m2.messageId).toDouble()).toInt()
    })

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(messages: Array<MTMessage>) {
        Collections.addAll(this.messages, *messages)
    }

    constructor() {

    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeInt(messages.size)
        for (message in messages) {
            message.serializeBody(tlSerializer)
        }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        val size = readInt()
        messages.clear()
        for (i in 0 until size) {
            val message = MTMessage()
            message.deserializeBody(tlDeserializer)
            messages.add(message)
        }
    }

    override fun toString(): String {
        return "msg_container#73f1f8dc"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1945237724
    }
}
