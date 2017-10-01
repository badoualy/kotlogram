package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.OutputStream

class TLStreamSerializer(private val stream: OutputStream) : TLSerializer {

    override fun writeByte(b: Int) {
        stream.write(b)
    }

    override fun writeByte(b: Byte) {
        stream.write(b.toInt())
    }

    override fun writeByteArray(byteArray: ByteArray, offset: Int, length: Int) {
        if (offset == 0 && length == byteArray.size) {
            // Avoid creating copy if we send whole array
            stream.write(byteArray)
        } else {
            stream.write(byteArray.copyOfRange(offset, offset + length))
        }
    }

    override fun writeInt(v: Int) {
        writeByte(v and 0xFF)
        writeByte(v shr 8 and 0xFF)
        writeByte(v shr 16 and 0xFF)
        writeByte(v shr 24 and 0xFF)
    }

    override fun writeLong(v: Long) {
        writeInt((v and 0xFFFFFFFF).toInt())
        writeInt((v shr 32 and 0xFFFFFFFF).toInt())
    }

    override fun writeDouble(v: Double) {
        writeLong(java.lang.Double.doubleToRawLongBits(v))
    }

    override fun writeBoolean(v: Boolean) {
        TLBool.serialize(v, this)
    }

    override fun writeString(v: String) {
        writeTLBytes(v.toByteArray(Charsets.UTF_8))
    }

    override fun writeTLBytes(b: TLBytes) {
        // Write length
        val startOffset =
                if (b.length >= 254) {
                    writeByte(254)
                    writeByte(b.length and 0xFF)
                    writeByte(b.length shr 8 and 0xFF)
                    writeByte(b.length shr 16 and 0xFF)
                    4
                } else {
                    writeByte(b.length)
                    1
                }

        writeByteArray(b.data, b.offset, b.length)

        val offset = (b.length + startOffset) % 4
        if (offset != 0) {
            writeByteArray(ByteArray(4 - offset))
        }
    }
}