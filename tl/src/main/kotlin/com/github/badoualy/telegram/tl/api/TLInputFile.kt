package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputFile#f52ff27f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputFile() : TLAbsInputFile() {
    override var id: Long = 0L

    override var parts: Int = 0

    override var name: String = ""

    var md5Checksum: String = ""

    private val _constructor: String = "inputFile#f52ff27f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            parts: Int,
            name: String,
            md5Checksum: String
    ) : this() {
        this.id = id
        this.parts = parts
        this.name = name
        this.md5Checksum = md5Checksum
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeInt(parts)
        writeString(name)
        writeString(md5Checksum)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        parts = readInt()
        name = readString()
        md5Checksum = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(name)
        size += computeTLStringSerializedSize(md5Checksum)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputFile) return false
        if (other === this) return true

        return id == other.id
                && parts == other.parts
                && name == other.name
                && md5Checksum == other.md5Checksum
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf52ff27f.toInt()
    }
}
