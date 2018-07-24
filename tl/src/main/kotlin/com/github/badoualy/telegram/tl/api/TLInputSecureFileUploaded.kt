package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
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
 * inputSecureFileUploaded#3334b0f0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputSecureFileUploaded() : TLAbsInputSecureFile() {
    override var id: Long = 0L

    var parts: Int = 0

    var md5Checksum: String = ""

    var fileHash: TLBytes = TLBytes.EMPTY

    var secret: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "inputSecureFileUploaded#3334b0f0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            parts: Int,
            md5Checksum: String,
            fileHash: TLBytes,
            secret: TLBytes
    ) : this() {
        this.id = id
        this.parts = parts
        this.md5Checksum = md5Checksum
        this.fileHash = fileHash
        this.secret = secret
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeInt(parts)
        writeString(md5Checksum)
        writeTLBytes(fileHash)
        writeTLBytes(secret)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        parts = readInt()
        md5Checksum = readString()
        fileHash = readTLBytes()
        secret = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(md5Checksum)
        size += computeTLBytesSerializedSize(fileHash)
        size += computeTLBytesSerializedSize(secret)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputSecureFileUploaded) return false
        if (other === this) return true

        return id == other.id
                && parts == other.parts
                && md5Checksum == other.md5Checksum
                && fileHash == other.fileHash
                && secret == other.secret
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3334b0f0.toInt()
    }
}
