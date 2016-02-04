package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.readInt
import com.github.badoualy.telegram.tl.StreamUtils.writeInt
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.*

class MTMessagesContainer : TLObject {

    val messages = TreeSet(Comparator<MTMessage> { mtMessage, mtMessage2 -> Math.signum((mtMessage.messageId - mtMessage2.messageId).toDouble()).toInt() })

    constructor(messages: Array<MTMessage>) {
        Collections.addAll(this.messages, *messages)
    }

    constructor() {

    }

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeInt(messages.size, stream)
        for (message in messages) {
            message.serializeBody(stream)
        }
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        val size = readInt(stream)
        messages.clear()
        for (i in 0..size - 1) {
            val message = MTMessage()
            message.deserializeBody(stream, context)
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
