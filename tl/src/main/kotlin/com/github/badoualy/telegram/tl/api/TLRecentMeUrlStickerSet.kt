package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * recentMeUrlStickerSet#bc0a57dc
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRecentMeUrlStickerSet() : TLAbsRecentMeUrl() {
    override var url: String = ""

    var set: TLAbsStickerSetCovered = TLStickerSetMultiCovered()

    private val _constructor: String = "recentMeUrlStickerSet#bc0a57dc"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(url: String, set: TLAbsStickerSetCovered) : this() {
        this.url = url
        this.set = set
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(url)
        writeTLObject(set)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        url = readString()
        set = readTLObject<TLAbsStickerSetCovered>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(url)
        size += set.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRecentMeUrlStickerSet) return false
        if (other === this) return true

        return url == other.url
                && set == other.set
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xbc0a57dc.toInt()
    }
}
