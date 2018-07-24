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
 * encryptedFile#4a70994c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLEncryptedFile() : TLAbsEncryptedFile() {
    var id: Long = 0L

    var accessHash: Long = 0L

    var size: Int = 0

    var dcId: Int = 0

    var keyFingerprint: Int = 0

    private val _constructor: String = "encryptedFile#4a70994c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            accessHash: Long,
            size: Int,
            dcId: Int,
            keyFingerprint: Int
    ) : this() {
        this.id = id
        this.accessHash = accessHash
        this.size = size
        this.dcId = dcId
        this.keyFingerprint = keyFingerprint
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeLong(accessHash)
        writeInt(size)
        writeInt(dcId)
        writeInt(keyFingerprint)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        accessHash = readLong()
        size = readInt()
        dcId = readInt()
        keyFingerprint = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLEncryptedFile) return false
        if (other === this) return true

        return id == other.id
                && accessHash == other.accessHash
                && size == other.size
                && dcId == other.dcId
                && keyFingerprint == other.keyFingerprint
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4a70994c.toInt()
    }
}
