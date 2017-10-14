package com.github.badoualy.telegram.tl.stream

import com.github.badoualy.telegram.tl.core.TLBytes
import java.io.OutputStream

fun OutputStream.writeByte(byte: Byte) = write(byte.toInt())
fun OutputStream.writeByte(byte: Int) = write(byte)

fun OutputStream.writeByteArray(array: ByteArray) = write(array)
fun OutputStream.writeByteArray(array: ByteArray, offset: Int, length: Int) =
        write(array, offset, length)

fun OutputStream.writeInt(v: Int) {
    writeByte(v and 0xFF)
    writeByte(v shr 8 and 0xFF)
    writeByte(v shr 16 and 0xFF)
    writeByte(v shr 24 and 0xFF)
}

fun OutputStream.writeLong(v: Long) {
    writeInt((v and 0xFFFFFFFF).toInt())
    writeInt((v shr 32 and 0xFFFFFFFF).toInt())
}

fun OutputStream.writeDouble(v: Double) = writeLong(java.lang.Double.doubleToRawLongBits(v))

fun OutputStream.writeString(v: String) = writeTLBytes(v.toByteArray(Charsets.UTF_8))

fun OutputStream.writeTLBytes(b: ByteArray) = writeTLBytes(TLBytes(b))
fun OutputStream.writeTLBytes(b: TLBytes) {
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