package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * stickerSetCovered#6410a5d2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStickerSetCovered() : TLAbsStickerSetCovered() {
    override var set: TLStickerSet = TLStickerSet()

    var cover: TLAbsDocument = TLDocumentEmpty()

    private val _constructor: String = "stickerSetCovered#6410a5d2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(set: TLStickerSet, cover: TLAbsDocument) : this() {
        this.set = set
        this.cover = cover
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(set)
        writeTLObject(cover)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        set = readTLObject<TLStickerSet>(TLStickerSet::class, TLStickerSet.CONSTRUCTOR_ID)
        cover = readTLObject<TLAbsDocument>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += set.computeSerializedSize()
        size += cover.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStickerSetCovered) return false
        if (other === this) return true

        return set == other.set
                && cover == other.cover
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6410a5d2.toInt()
    }
}
