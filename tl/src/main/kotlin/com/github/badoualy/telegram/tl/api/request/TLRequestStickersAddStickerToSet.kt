package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet
import com.github.badoualy.telegram.tl.api.TLInputStickerSetEmpty
import com.github.badoualy.telegram.tl.api.TLInputStickerSetItem
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStickersAddStickerToSet() : TLMethod<TLStickerSet>() {
    var stickerset: TLAbsInputStickerSet = TLInputStickerSetEmpty()

    var sticker: TLInputStickerSetItem = TLInputStickerSetItem()

    private val _constructor: String = "stickers.addStickerToSet#8653febe"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(stickerset: TLAbsInputStickerSet, sticker: TLInputStickerSetItem) : this() {
        this.stickerset = stickerset
        this.sticker = sticker
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLStickerSet = tlDeserializer.readTLObject(TLStickerSet::class, TLStickerSet.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(stickerset)
        writeTLObject(sticker)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        stickerset = readTLObject<TLAbsInputStickerSet>()
        sticker = readTLObject<TLInputStickerSetItem>(TLInputStickerSetItem::class, TLInputStickerSetItem.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += stickerset.computeSerializedSize()
        size += sticker.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStickersAddStickerToSet) return false
        if (other === this) return true

        return stickerset == other.stickerset
                && sticker == other.sticker
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8653febe.toInt()
    }
}
