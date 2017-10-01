package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputMediaPhoto#81fa373a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaPhoto() : TLAbsInputMedia() {
    var id: TLAbsInputPhoto = TLInputPhotoEmpty()

    var caption: String = ""

    var ttlSeconds: Int? = null

    private val _constructor: String = "inputMediaPhoto#81fa373a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: TLAbsInputPhoto,
            caption: String,
            ttlSeconds: Int?
    ) : this() {
        this.id = id
        this.caption = caption
        this.ttlSeconds = ttlSeconds
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(ttlSeconds, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(id)
        writeString(caption)
        doIfMask(ttlSeconds, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readTLObject<TLAbsInputPhoto>()
        caption = readString()
        ttlSeconds = readIfMask(1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += id.computeSerializedSize()
        size += computeTLStringSerializedSize(caption)
        size += getIntIfMask(ttlSeconds, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaPhoto) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && caption == other.caption
                && ttlSeconds == other.ttlSeconds
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x81fa373a.toInt()
    }
}
