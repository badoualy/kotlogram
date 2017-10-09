package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputStickerSet
import com.github.badoualy.telegram.tl.api.TLInputStickerSetEmpty
import com.github.badoualy.telegram.tl.api.messages.TLStickerSet
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetStickerSet() : TLMethod<TLStickerSet>() {
    var stickerset: TLAbsInputStickerSet = TLInputStickerSetEmpty()

    private val _constructor: String = "messages.getStickerSet#2619a90e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(stickerset: TLAbsInputStickerSet) : this() {
        this.stickerset = stickerset
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLStickerSet = tlDeserializer.readTLObject(TLStickerSet::class, TLStickerSet.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(stickerset)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        stickerset = readTLObject<TLAbsInputStickerSet>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += stickerset.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetStickerSet) return false
        if (other === this) return true

        return stickerset == other.stickerset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2619a90e.toInt()
    }
}
