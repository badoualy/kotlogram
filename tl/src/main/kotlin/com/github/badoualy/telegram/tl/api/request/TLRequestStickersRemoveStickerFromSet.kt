package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputDocument
import com.github.badoualy.telegram.tl.api.TLInputDocumentEmpty
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestStickersRemoveStickerFromSet() : TLMethod<TLStickerSet>() {
    var sticker: TLAbsInputDocument = TLInputDocumentEmpty()

    private val _constructor: String = "stickers.removeStickerFromSet#f7760f51"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(sticker: TLAbsInputDocument) : this() {
        this.sticker = sticker
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLStickerSet = tlDeserializer.readTLObject(TLStickerSet::class, TLStickerSet.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(sticker)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        sticker = readTLObject<TLAbsInputDocument>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += sticker.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestStickersRemoveStickerFromSet) return false
        if (other === this) return true

        return sticker == other.sticker
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf7760f51.toInt()
    }
}
