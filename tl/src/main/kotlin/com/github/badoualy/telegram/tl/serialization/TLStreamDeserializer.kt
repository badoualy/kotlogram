package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLGzipObject
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.util.zip.GZIPInputStream

class TLStreamDeserializer(var stream: InputStream,
                           override val context: TLContext) : TLDeserializer {

    override fun available(): Int = stream.available()

    override fun readByte() = stream.read().also { if (it < 0) throw IOException() }

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

    private fun skipBytes(count: Int) {
        if (count > 0) {
            // Skipping with skip() on a gzip stream is buggy when reached end of stream
            // stream.skip(count);
            readBytes(count)
        }
    }

    override fun unzip() = TLGzipObject().let {
        it.deserializeBody(this)
        stream = BufferedInputStream(GZIPInputStream(ByteArrayInputStream(it.packedData)))
    }
}