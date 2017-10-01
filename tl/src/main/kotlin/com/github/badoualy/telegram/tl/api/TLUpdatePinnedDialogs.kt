package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updatePinnedDialogs#d8caf68d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatePinnedDialogs() : TLAbsUpdate() {
    var order: TLObjectVector<TLAbsPeer>? = TLObjectVector()

    private val _constructor: String = "updatePinnedDialogs#d8caf68d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(order: TLObjectVector<TLAbsPeer>?) : this() {
        this.order = order
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(order, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(order, 1) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        order = readIfMask(1) { readTLVector<TLAbsPeer>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(order, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatePinnedDialogs) return false
        if (other === this) return true

        return _flags == other._flags
                && order == other.order
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd8caf68d.toInt()
    }
}
