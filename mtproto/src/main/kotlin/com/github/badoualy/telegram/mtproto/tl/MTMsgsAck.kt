package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector
import com.github.badoualy.telegram.tl.StreamUtils.writeTLVector
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTMsgsAck @JvmOverloads constructor(var messages: TLLongVector = TLLongVector()) : TLObject() {

    constructor(msgIds: LongArray) : this() {
        messages.addAll(msgIds.toList())
    }

    constructor(msgIds: Array<Long>) : this() {
        messages.addAll(msgIds)
    }

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeTLVector(messages, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        messages = readTLLongVector(stream, context)
    }

    override fun toString(): String {
        return "msgs_ack#62d6b459"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1658238041
    }
}
