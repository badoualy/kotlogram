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

/**
 * messageActionPhoneCall#80e11a7f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionPhoneCall() : TLAbsMessageAction() {
    var callId: Long = 0L

    var reason: TLAbsPhoneCallDiscardReason? = null

    var duration: Int? = null

    private val _constructor: String = "messageActionPhoneCall#80e11a7f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            callId: Long,
            reason: TLAbsPhoneCallDiscardReason?,
            duration: Int?
    ) : this() {
        this.callId = callId
        this.reason = reason
        this.duration = duration
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(reason, 1)
        updateFlags(duration, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(callId)
        doIfMask(reason, 1) { writeTLObject(it) }
        doIfMask(duration, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        callId = readLong()
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
        if (other !is TLMessageActionPhoneCall) return false
        if (other === this) return true

        return _flags == other._flags
                && callId == other.callId
                && reason == other.reason
                && duration == other.duration
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x80e11a7f.toInt()
    }
}
