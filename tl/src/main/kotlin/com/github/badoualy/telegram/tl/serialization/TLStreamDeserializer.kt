package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.*
import java.io.IOException
import java.io.InputStream
import kotlin.reflect.KClass

class TLStreamDeserializer(val stream: InputStream, val context: TLContext) : TLDeserializer {

    override fun readByte() = stream.read().also {
        if (it < 0) throw IOException()
    }

    override fun readBytes(buffer: ByteArray, offset: Int, len: Int): ByteArray {
        var readTotal = 0
        while (readTotal < len) {
            val read = stream.read(buffer, readTotal + offset, len - readTotal)
            when {
                read > 0 -> readTotal += read
                read < 0 -> throw IOException()
                else -> Thread.yield()
            }
        }

        return buffer
    }

    override fun readInt(): Int {
        val a = readByte()
        val b = readByte()
        val c = readByte()
        val d = readByte()

        return a + (b shl 8) + (c shl 16) + (d shl 24)
    }

    override fun readUInt(): Long {
        val a = readByte().toLong()
        val b = readByte().toLong()
        val c = readByte().toLong()
        val d = readByte().toLong()

        return a + (b shl 8) + (c shl 16) + (d shl 24)
    }

    override fun readLong(): Long {
        val a = readUInt()
        val b = readUInt()

        return a + (b shl 32)
    }

    override fun readDouble() = java.lang.Double.longBitsToDouble(readLong())

    override fun readBoolean() = TLBool.deserialize(this)

    override fun readString() = String(readTLBytesAsBytes(), Charsets.UTF_8)

    override fun readTLBytes(): TLBytes {
        var len = stream.read()
        val startOffset =
                if (len >= 254) {
                    len = stream.read() + (stream.read() shl 8) + (stream.read() shl 16)
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

    override fun <T : TLObject> readTLObject(): T {
        return context.deserializeMessage(stream)
    }

    override fun <T : TLObject> readTLObject(clazz: KClass<T>, constructorId: Int): T {
        return context.deserializeMessage(stream, clazz.java, constructorId)
    }

    override fun <T : TLObject> readTLVector() = context.deserializeObjectVector<T>(stream)

    override fun readTLIntVector() = context.deserializeIntVector(stream)

    override fun readTLLongVector() = context.deserializeLongVector(stream)

    override fun readTLStringVector() = context.deserializeStringVector(stream)

    private fun skipBytes(count: Int) {
        if (count > 0) {
            // Skipping with skip() on a gzip stream is buggy when reached end of stream
            // stream.skip(count);
            readBytes(count)
        }
    }

}