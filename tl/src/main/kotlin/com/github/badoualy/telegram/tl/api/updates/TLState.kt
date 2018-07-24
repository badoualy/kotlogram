package com.github.badoualy.telegram.tl.api.updates

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * updates.state#a56c2a3e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLState() : TLObject() {
    var pts: Int = 0

    var qts: Int = 0

    var date: Int = 0

    var seq: Int = 0

    var unreadCount: Int = 0

    private val _constructor: String = "updates.state#a56c2a3e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            pts: Int,
            qts: Int,
            date: Int,
            seq: Int,
            unreadCount: Int
    ) : this() {
        this.pts = pts
        this.qts = qts
        this.date = date
        this.seq = seq
        this.unreadCount = unreadCount
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(pts)
        writeInt(qts)
        writeInt(date)
        writeInt(seq)
        writeInt(unreadCount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        pts = readInt()
        qts = readInt()
        date = readInt()
        seq = readInt()
        unreadCount = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLState) return false
        if (other === this) return true

        return pts == other.pts
                && qts == other.qts
                && date == other.date
                && seq == other.seq
                && unreadCount == other.unreadCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa56c2a3e.toInt()
    }
}
