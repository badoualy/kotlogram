package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTFutureSalt @JvmOverloads constructor(var validSince: Int = 0,
                                             var validUntil: Int = 0,
                                             var salt: Long = 0) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeInt(validSince)
        writeInt(validUntil)
        writeLong(salt)
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
