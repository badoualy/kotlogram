package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLGzipObject
import com.github.badoualy.telegram.tl.stream.readByte
import com.github.badoualy.telegram.tl.stream.readBytes
import com.github.badoualy.telegram.tl.stream.readTLBytes
import com.github.badoualy.telegram.tl.stream.skipBytes
import java.io.BufferedInputStream
import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream
import java.util.zip.GZIPInputStream

internal class TLStreamDeserializer(var stream: InputStream,
                                    override val context: TLContext) : TLDeserializer {

    constructor(byteArray: ByteArray, context: TLContext) :
            this(ByteArrayInputStream(byteArray), context)

    override fun available(): Int = stream.available()

    override fun readByte() = stream.readByte()

    override fun readBytes(buffer: ByteArray, offset: Int, len: Int): ByteArray =
            stream.readBytes(buffer, offset, len)

    override fun readTLBytes() = stream.readTLBytes()

    private fun skipBytes(count: Int) = stream.skipBytes(count)

    override fun unzip() = TLGzipObject().let {
        it.deserializeBody(this)
        stream = BufferedInputStream(GZIPInputStream(ByteArrayInputStream(it.packedData)))
    }
}