package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLVector
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTFutureSalts @JvmOverloads constructor(var requestId: Long = 0, var now: Int = 0, var salts: TLVector<MTFutureSalt> = TLVector()) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeLong(requestId, stream)
        writeInt(now, stream)
        writeInt(salts.size, stream)
        for (salt in salts) {
            salt.serializeBody(stream)
        }
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        requestId = readLong(stream)
        now = readInt(stream)
        val count = readInt(stream)
        salts.clear()
        for (i in 0..count - 1) {
            val salt = MTFutureSalt()
            salt.deserializeBody(stream, context)
            salts.add(salt)
        }
    }

    override fun toString(): String {
        return "future_salts#ae500895"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -1370486635
    }
}
