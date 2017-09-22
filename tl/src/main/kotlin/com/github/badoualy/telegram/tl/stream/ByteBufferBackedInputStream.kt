package com.github.badoualy.telegram.tl.stream

import java.io.IOException
import java.io.InputStream
import java.nio.ByteBuffer

class ByteBufferBackedInputStream(private val buffer: ByteBuffer) : InputStream() {

    @Throws(IOException::class)
    override fun read(): Int =
            if (buffer.hasRemaining()) buffer.get().toInt() and 0xFF
            else -1


    @Throws(IOException::class)
    override fun read(bytes: ByteArray, off: Int, len: Int): Int {
        if (!buffer.hasRemaining()) return -1
        if (len == 0) return 0

        val lenToRead = Math.min(len, buffer.remaining())
        buffer.get(bytes, off, lenToRead)
        return lenToRead
    }
}