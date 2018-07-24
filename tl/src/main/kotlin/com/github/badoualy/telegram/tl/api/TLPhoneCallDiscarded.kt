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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * phoneCallDiscarded#50ca4de1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneCallDiscarded() : TLAbsPhoneCall() {
    @Transient
    var needRating: Boolean = false

    @Transient
    var needDebug: Boolean = false

    override var id: Long = 0L

    var reason: TLAbsPhoneCallDiscardReason? = null

    var duration: Int? = null

    private val _constructor: String = "phoneCallDiscarded#50ca4de1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            needRating: Boolean,
            needDebug: Boolean,
            id: Long,
            reason: TLAbsPhoneCallDiscardReason?,
            duration: Int?
    ) : this() {
        this.needRating = needRating
        this.needDebug = needDebug
        this.id = id
        this.reason = reason
        this.duration = duration
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(needRating, 4)
        updateFlags(needDebug, 8)
        updateFlags(reason, 1)
        updateFlags(duration, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(id)
        doIfMask(reason, 1) { writeTLObject(it) }
        doIfMask(duration, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        needRating = isMask(4)
        needDebug = isMask(8)
        id = readLong()
        reason = readIfMask(1) { readTLObject<TLAbsPhoneCallDiscardReason>() }
        duration = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(reason, 1) { it.computeSerializedSize() }
        size += getIntIfMask(duration, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneCallDiscarded) return false
        if (other === this) return true

        return _flags == other._flags
                && needRating == other.needRating
                && needDebug == other.needDebug
                && id == other.id
                && reason == other.reason
                && duration == other.duration
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x50ca4de1.toInt()
    }
}
