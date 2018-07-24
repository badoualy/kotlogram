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
 * inputEncryptedFileUploaded#64bd0306
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputEncryptedFileUploaded() : TLAbsInputEncryptedFile() {
    var id: Long = 0L

    var parts: Int = 0

    var md5Checksum: String = ""

    var keyFingerprint: Int = 0

    private val _constructor: String = "inputEncryptedFileUploaded#64bd0306"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            parts: Int,
            md5Checksum: String,
            keyFingerprint: Int
    ) : this() {
        this.id = id
        this.parts = parts
        this.md5Checksum = md5Checksum
        this.keyFingerprint = keyFingerprint
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeInt(parts)
        writeString(md5Checksum)
        writeInt(keyFingerprint)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        parts = readInt()
        md5Checksum = readString()
        keyFingerprint = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(md5Checksum)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputEncryptedFileUploaded) return false
        if (other === this) return true

        return id == other.id
                && parts == other.parts
                && md5Checksum == other.md5Checksum
                && keyFingerprint == other.keyFingerprint
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x64bd0306.toInt()
    }
}
