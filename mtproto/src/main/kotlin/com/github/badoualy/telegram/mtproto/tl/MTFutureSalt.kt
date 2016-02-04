package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTFutureSalt @JvmOverloads constructor(var validSince: Int = 0, var validUntil: Int = 0, var salt: Long = 0) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeInt(validSince, stream)
        writeInt(validUntil, stream)
        writeLong(salt, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        validSince = readInt(stream)
        validUntil = readInt(stream)
        salt = readLong(stream)
    }

    override fun toString(): String {
        return "future_salt#0949d9dc"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 0x0949d9dc
    }
}
