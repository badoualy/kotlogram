package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTPingDelayDisconnect @JvmOverloads constructor(var pingId: Long = 0, var disconnectDelay: Int = 0) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeLong(pingId, stream)
        writeInt(disconnectDelay, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        pingId = readLong(stream)
        disconnectDelay = readInt(stream)
    }

    override fun toString(): String {
        return "ping_delay_disconnect#f3427b8c"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -213746804
    }
}
