package com.github.badoualy.telegram.tl.stream

import com.github.badoualy.telegram.tl.core.TLBytes
import java.io.IOException
import java.io.InputStream

fun InputStream.readByte(): Int = read().also { if (it < 0) throw IOException() }

fun InputStream.readBytes(length: Int) = readBytes(ByteArray(length), 0, length)

fun InputStream.readInt(): Int {
    val a = readByte()
    val b = readByte()
    val c = readByte()
    val d = readByte()

    return a + (b shl 8) + (c shl 16) + (d shl 24)
}

fun InputStream.readUInt(): Long {
    val a = readByte().toLong()
    val b = readByte().toLong()
    val c = readByte().toLong()
    val d = readByte().toLong()

    return a + (b shl 8) + (c shl 16) + (d shl 24)
}

fun InputStream.readLong(): Long {
    val a = readUInt()
    val b = readUInt()

    return a + (b shl 32)
}

fun InputStream.readDouble() = java.lang.Double.longBitsToDouble(readLong())

fun InputStream.skipBytes(count: Int) {
    if (count > 0) {
        // Skipping with skipBytes() on a gzip stream is buggy when reached end of stream
        // stream.skipBytes(count);
        readBytes(count)
    }
}

fun InputStream.readBytes(buffer: ByteArray, offset: Int, length: Int): ByteArray {
    var readTotal = 0
    while (readTotal < length) {
        val read = read(buffer, readTotal + offset, length - readTotal)
        when {
            read > 0 -> readTotal += read
            read < 0 -> throw IOException()
            else -> Thread.yield()
        }
    }

    return buffer
}

fun InputStream.readTLBytes(): TLBytes {
    var len = read()
    val startOffset =
            if (len >= 254) {
                len = read() + (read() shl 8) + (read() shl 16)
                4
            } else {
                1
            }

    val data = readBytes(len)

    val offset = (len + startOffset) % 4
    if (offset != 0) {
        skipBytes(4 - offset)
    }

    return TLBytes(data)
}