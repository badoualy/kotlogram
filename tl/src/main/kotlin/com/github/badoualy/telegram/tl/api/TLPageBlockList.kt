package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * pageBlockList#3a58c7f4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockList() : TLAbsPageBlock() {
    var ordered: Boolean = false

    var items: TLObjectVector<TLAbsRichText> = TLObjectVector()

    private val _constructor: String = "pageBlockList#3a58c7f4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(ordered: Boolean, items: TLObjectVector<TLAbsRichText>) : this() {
        this.ordered = ordered
        this.items = items
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeBoolean(ordered)
        writeTLVector(items)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        ordered = readBoolean()
        items = readTLVector<TLAbsRichText>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_BOOLEAN
        size += items.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockList) return false
        if (other === this) return true

        return ordered == other.ordered
                && items == other.items
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3a58c7f4.toInt()
    }
}
