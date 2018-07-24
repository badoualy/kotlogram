package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsStickerSetCovered
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * messages.featuredStickers#f89d88e5
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFeaturedStickers() : TLAbsFeaturedStickers() {
    var hash: Int = 0

    var sets: TLObjectVector<TLAbsStickerSetCovered> = TLObjectVector()

    var unread: TLLongVector = TLLongVector()

    private val _constructor: String = "messages.featuredStickers#f89d88e5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hash: Int,
            sets: TLObjectVector<TLAbsStickerSetCovered>,
            unread: TLLongVector
    ) : this() {
        this.hash = hash
        this.sets = sets
        this.unread = unread
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(hash)
        writeTLVector(sets)
        writeTLVector(unread)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readInt()
        sets = readTLVector<TLAbsStickerSetCovered>()
        unread = readTLLongVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += sets.computeSerializedSize()
        size += unread.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFeaturedStickers) return false
        if (other === this) return true

        return hash == other.hash
                && sets == other.sets
                && unread == other.unread
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf89d88e5.toInt()
    }
}
