package com.github.badoualy.telegram.tl.stream

import java.io.IOException
import java.io.OutputStream
import java.nio.ByteBuffer

class ByteBufferBackedOutputStream(val buffer: ByteBuffer) : OutputStream() {

    @Throws(IOException::class)
    override fun write(b: Int) {
        buffer.put(b.toByte())
    }

    @Throws(IOException::class)
    override fun write(bytes: ByteArray, off: Int, len: Int) {
        buffer.put(bytes, off, len)
    }
}