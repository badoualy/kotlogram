package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * photo#9288dd29
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoto() : TLAbsPhoto() {
    @Transient
    var hasStickers: Boolean = false

    override var id: Long = 0L

    var accessHash: Long = 0L

    var date: Int = 0

    var sizes: TLObjectVector<TLAbsPhotoSize> = TLObjectVector()

    private val _constructor: String = "photo#9288dd29"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hasStickers: Boolean,
            id: Long,
            accessHash: Long,
            date: Int,
            sizes: TLObjectVector<TLAbsPhotoSize>
    ) : this() {
        this.hasStickers = hasStickers
        this.id = id
        this.accessHash = accessHash
        this.date = date
        this.sizes = sizes
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(hasStickers, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        writeLong(accessHash)
        writeInt(date)
        writeTLVector(sizes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hasStickers = isMask(1)
        id = readLong()
        accessHash = readLong()
        date = readInt()
        sizes = readTLVector<TLAbsPhotoSize>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        size += sizes.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoto) return false
        if (other === this) return true

        return _flags == other._flags
                && hasStickers == other.hasStickers
                && id == other.id
                && accessHash == other.accessHash
                && date == other.date
                && sizes == other.sizes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9288dd29.toInt()
    }
}
