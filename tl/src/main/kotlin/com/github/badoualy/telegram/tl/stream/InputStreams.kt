package com.github.badoualy.telegram.tl.stream

import java.io.IOException
import java.io.InputStream

fun InputStream.readByte(): Int = read().also { if (it < 0) throw IOException() }

fun InputStream.readBytes(length: Int) = readBytes(ByteArray(length), 0, length)
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

fun InputStream.skip(count: Int) {
    // Skipping with skip() on a gzip stream is buggy when reached end of stream
    // stream.skip(count);
    readBytes(count)
}