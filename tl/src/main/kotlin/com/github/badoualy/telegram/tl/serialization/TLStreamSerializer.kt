package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.core.TLBytes
import java.io.OutputStream

internal class TLStreamSerializer(private val stream: OutputStream) : TLSerializer {

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

        // Write array content
        writeByteArray(b.data, b.offset, b.length)

        // Add padding (1..3 bytes)
        val offset = (b.length + startOffset) % 4
        if (offset != 0) {
            writeByteArray(ByteArray(4 - offset))
        }
    }
}