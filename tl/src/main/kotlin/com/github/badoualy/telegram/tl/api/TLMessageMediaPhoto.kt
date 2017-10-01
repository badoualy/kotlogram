package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageMediaPhoto#b5223b0f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaPhoto() : TLAbsMessageMedia() {
    var photo: TLAbsPhoto? = null

    var caption: String? = null

    var ttlSeconds: Int? = null

    private val _constructor: String = "messageMediaPhoto#b5223b0f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            photo: TLAbsPhoto?,
            caption: String?,
            ttlSeconds: Int?
    ) : this() {
        this.photo = photo
        this.caption = caption
        this.ttlSeconds = ttlSeconds
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(photo, 1)
        updateFlags(caption, 2)
        updateFlags(ttlSeconds, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(photo, 1) { writeTLObject(it) }
        doIfMask(caption, 2) { writeString(it) }
        doIfMask(ttlSeconds, 4) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        photo = readIfMask(1) { readTLObject<TLAbsPhoto>() }
        caption = readIfMask(2) { readString() }
        ttlSeconds = readIfMask(4) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(photo, 1) { it.computeSerializedSize() }
        size += getIntIfMask(caption, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(ttlSeconds, 4) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaPhoto) return false
        if (other === this) return true

        return _flags == other._flags
                && photo == other.photo
                && caption == other.caption
                && ttlSeconds == other.ttlSeconds
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb5223b0f.toInt()
    }
}
