package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.readLong
import com.github.badoualy.telegram.tl.StreamUtils.writeLong
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTPong @JvmOverloads constructor(var messageId: Long = 0, var pingId: Long = 0) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeLong(messageId, stream)
        writeLong(pingId, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        messageId = readLong(stream)
        pingId = readLong(stream)
    }

    override fun toString(): String {
        return "pong#347773c5"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 880243653
    }
}
