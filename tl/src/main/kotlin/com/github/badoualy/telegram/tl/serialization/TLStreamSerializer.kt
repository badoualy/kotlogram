package com.github.badoualy.telegram.tl.serialization

import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.stream.writeByte
import com.github.badoualy.telegram.tl.stream.writeByteArray
import com.github.badoualy.telegram.tl.stream.writeTLBytes
import java.io.OutputStream

internal class TLStreamSerializer(private val stream: OutputStream) : TLSerializer {

    override fun writeByte(b: Int) {
        stream.writeByte(b)
    }

    override fun writeByte(b: Byte) {
        stream.writeByte(b)
    }

    override fun writeByteArray(byteArray: ByteArray, offset: Int, length: Int) {
        stream.writeByteArray(byteArray, offset, length)
    }

    override fun writeTLBytes(b: TLBytes) {
        stream.writeTLBytes(b)
    }
}