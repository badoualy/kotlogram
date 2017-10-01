package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputStickerSetItem#ffa0a496
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputStickerSetItem() : TLObject() {
    var document: TLAbsInputDocument = TLInputDocumentEmpty()

    var emoji: String = ""

    var maskCoords: TLMaskCoords? = null

    private val _constructor: String = "inputStickerSetItem#ffa0a496"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            document: TLAbsInputDocument,
            emoji: String,
            maskCoords: TLMaskCoords?
    ) : this() {
        this.document = document
        this.emoji = emoji
        this.maskCoords = maskCoords
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(maskCoords, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(document)
        writeString(emoji)
        doIfMask(maskCoords, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        document = readTLObject<TLAbsInputDocument>()
        emoji = readString()
        maskCoords = readIfMask(1) { readTLObject<TLMaskCoords>(TLMaskCoords::class, TLMaskCoords.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += document.computeSerializedSize()
        size += computeTLStringSerializedSize(emoji)
        size += getIntIfMask(maskCoords, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputStickerSetItem) return false
        if (other === this) return true

        return _flags == other._flags
                && document == other.document
                && emoji == other.emoji
                && maskCoords == other.maskCoords
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xffa0a496.toInt()
    }
}
