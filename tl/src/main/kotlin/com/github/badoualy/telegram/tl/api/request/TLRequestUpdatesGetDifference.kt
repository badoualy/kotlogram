package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.updates.TLAbsDifference
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestUpdatesGetDifference() : TLMethod<TLAbsDifference>() {
    var pts: Int = 0

    var ptsTotalLimit: Int? = null

    var date: Int = 0

    var qts: Int = 0

    private val _constructor: String = "updates.getDifference#25939651"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pts: Int,
            ptsTotalLimit: Int?,
            date: Int,
            qts: Int
    ) : this() {
        this.pts = pts
        this.ptsTotalLimit = ptsTotalLimit
        this.date = date
        this.qts = qts
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(ptsTotalLimit, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(pts)
        doIfMask(ptsTotalLimit, 1) { writeInt(it) }
        writeInt(date)
        writeInt(qts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        pts = readInt()
        ptsTotalLimit = readIfMask(1) { readInt() }
        date = readInt()
        qts = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(ptsTotalLimit, 1) { SIZE_INT32 }
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestUpdatesGetDifference) return false
        if (other === this) return true

        return _flags == other._flags
                && pts == other.pts
                && ptsTotalLimit == other.ptsTotalLimit
                && date == other.date
                && qts == other.qts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x25939651.toInt()
    }
}
