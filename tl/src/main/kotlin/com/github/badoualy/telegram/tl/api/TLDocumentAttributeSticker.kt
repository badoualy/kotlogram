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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * documentAttributeSticker#6319d612
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDocumentAttributeSticker() : TLAbsDocumentAttribute() {
    @Transient
    var mask: Boolean = false

    var alt: String = ""

    var stickerset: TLAbsInputStickerSet = TLInputStickerSetEmpty()

    var maskCoords: TLMaskCoords? = null

    private val _constructor: String = "documentAttributeSticker#6319d612"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            mask: Boolean,
            alt: String,
            stickerset: TLAbsInputStickerSet,
            maskCoords: TLMaskCoords?
    ) : this() {
        this.mask = mask
        this.alt = alt
        this.stickerset = stickerset
        this.maskCoords = maskCoords
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(mask, 2)
        updateFlags(maskCoords, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(alt)
        writeTLObject(stickerset)
        doIfMask(maskCoords, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        mask = isMask(2)
        alt = readString()
        stickerset = readTLObject<TLAbsInputStickerSet>()
        maskCoords = readIfMask(1) { readTLObject<TLMaskCoords>(TLMaskCoords::class, TLMaskCoords.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(alt)
        size += stickerset.computeSerializedSize()
        size += getIntIfMask(maskCoords, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDocumentAttributeSticker) return false
        if (other === this) return true

        return _flags == other._flags
                && mask == other.mask
                && alt == other.alt
                && stickerset == other.stickerset
                && maskCoords == other.maskCoords
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6319d612.toInt()
    }
}
