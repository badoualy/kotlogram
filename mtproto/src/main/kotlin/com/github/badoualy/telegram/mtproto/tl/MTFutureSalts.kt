package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.core.TLVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTFutureSalts @JvmOverloads constructor(var requestId: Long = 0,
                                              var now: Int = 0,
                                              var salts: TLVector<MTFutureSalt> = TLObjectVector())
    : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeLong(requestId)
        writeInt(now)
        writeInt(salts.size)
        for (salt in salts) {
            salt.serializeBody(tlSerializer)
        }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        requestId = readLong()
        now = readInt()
        val count = readInt()
        salts.clear()
        (0 until count).map { MTFutureSalt() }
                .onEach { it.deserializeBody(tlDeserializer) }
                .toCollection(salts)
        Unit
    }

    override fun toString(): String {
        return "future_salts#ae500895"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -1370486635
    }
}
