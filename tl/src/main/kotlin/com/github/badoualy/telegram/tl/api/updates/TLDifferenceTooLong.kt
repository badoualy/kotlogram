package com.github.badoualy.telegram.tl.api.updates

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updates.differenceTooLong#4afe8f6d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDifferenceTooLong() : TLAbsDifference() {
    var pts: Int = 0

    private val _constructor: String = "updates.differenceTooLong#4afe8f6d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(pts: Int) : this() {
        this.pts = pts
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(pts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        pts = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDifferenceTooLong) return false
        if (other === this) return true

        return pts == other.pts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4afe8f6d.toInt()
    }
}
