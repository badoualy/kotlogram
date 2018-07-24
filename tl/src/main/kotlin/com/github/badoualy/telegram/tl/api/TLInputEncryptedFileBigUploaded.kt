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
 * inputEncryptedFileBigUploaded#2dc173c8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputEncryptedFileBigUploaded() : TLAbsInputEncryptedFile() {
    var id: Long = 0L

    var parts: Int = 0

    var keyFingerprint: Int = 0

    private val _constructor: String = "inputEncryptedFileBigUploaded#2dc173c8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            parts: Int,
            keyFingerprint: Int
    ) : this() {
        this.id = id
        this.parts = parts
        this.keyFingerprint = keyFingerprint
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeInt(parts)
        writeInt(keyFingerprint)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        parts = readInt()
        keyFingerprint = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputEncryptedFileBigUploaded) return false
        if (other === this) return true

        return id == other.id
                && parts == other.parts
                && keyFingerprint == other.keyFingerprint
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2dc173c8.toInt()
    }
}
