package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLStickerSet
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.allStickers#edfd405f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAllStickers() : TLAbsAllStickers() {
    var hash: Int = 0

    var sets: TLObjectVector<TLStickerSet> = TLObjectVector()

    private val _constructor: String = "messages.allStickers#edfd405f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(hash: Int, sets: TLObjectVector<TLStickerSet>) : this() {
        this.hash = hash
        this.sets = sets
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(hash)
        writeTLVector(sets)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readInt()
        sets = readTLVector<TLStickerSet>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += sets.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAllStickers) return false
        if (other === this) return true

        return hash == other.hash
                && sets == other.sets
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xedfd405f.toInt()
    }
}
