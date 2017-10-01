package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.api.TLAbsPhoneCallDiscardReason
import com.github.badoualy.telegram.tl.api.TLAbsUpdates
import com.github.badoualy.telegram.tl.api.TLInputPhoneCall
import com.github.badoualy.telegram.tl.api.TLPhoneCallDiscardReasonHangup
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPhoneDiscardCall() : TLMethod<TLAbsUpdates>() {
    var peer: TLInputPhoneCall = TLInputPhoneCall()

    var duration: Int = 0

    var reason: TLAbsPhoneCallDiscardReason = TLPhoneCallDiscardReasonHangup()

    var connectionId: Long = 0L

    private val _constructor: String = "phone.discardCall#78d413a6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLInputPhoneCall,
            duration: Int,
            reason: TLAbsPhoneCallDiscardReason,
            connectionId: Long
    ) : this() {
        this.peer = peer
        this.duration = duration
        this.reason = reason
        this.connectionId = connectionId
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLAbsUpdates = tlDeserializer.readTLObject()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(duration)
        writeTLObject(reason)
        writeLong(connectionId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLInputPhoneCall>(TLInputPhoneCall::class, TLInputPhoneCall.CONSTRUCTOR_ID)
        duration = readInt()
        reason = readTLObject<TLAbsPhoneCallDiscardReason>()
        connectionId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += reason.computeSerializedSize()
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPhoneDiscardCall) return false
        if (other === this) return true

        return peer == other.peer
                && duration == other.duration
                && reason == other.reason
                && connectionId == other.connectionId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x78d413a6.toInt()
    }
}
