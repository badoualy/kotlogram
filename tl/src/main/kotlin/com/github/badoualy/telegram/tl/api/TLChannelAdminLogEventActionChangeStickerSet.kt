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

/**
 * channelAdminLogEventActionChangeStickerSet#b1c3caa7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionChangeStickerSet() : TLAbsChannelAdminLogEventAction() {
    var prevStickerset: TLAbsInputStickerSet = TLInputStickerSetEmpty()

    var newStickerset: TLAbsInputStickerSet = TLInputStickerSetEmpty()

    private val _constructor: String = "channelAdminLogEventActionChangeStickerSet#b1c3caa7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(prevStickerset: TLAbsInputStickerSet, newStickerset: TLAbsInputStickerSet) : this() {
        this.prevStickerset = prevStickerset
        this.newStickerset = newStickerset
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(prevStickerset)
        writeTLObject(newStickerset)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        prevStickerset = readTLObject<TLAbsInputStickerSet>()
        newStickerset = readTLObject<TLAbsInputStickerSet>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += prevStickerset.computeSerializedSize()
        size += newStickerset.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionChangeStickerSet) return false
        if (other === this) return true

        return prevStickerset == other.prevStickerset
                && newStickerset == other.newStickerset
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb1c3caa7.toInt()
    }
}
