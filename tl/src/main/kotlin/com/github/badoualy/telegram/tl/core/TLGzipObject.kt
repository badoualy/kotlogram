package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.util.*

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGzipObject(var packedData: ByteArray = ByteArray(0)) : TLObject() {

    override val constructorId: Int
        get() = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) {
        tlSerializer.writeTLBytes(packedData)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) {
        packedData = tlDeserializer.readTLBytesAsBytes()
    }

    override fun computeSerializedSize(): Int =
            CONSTRUCTOR_ID + computeTLBytesSerializedSize(packedData.size)

    override fun toString() = "gzip_packed#3072cfa1"

    override fun equals(other: Any?): Boolean {
        if (other !is TLGzipObject)
            return false
        if (this === other)
            return true

        return Arrays.equals(packedData, other.packedData)
    }

    override fun hashCode() = Arrays.hashCode(packedData)

    companion object {
        const val CONSTRUCTOR_ID = 0x3072cfa1
    }
}
