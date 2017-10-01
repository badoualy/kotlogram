package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetDialogs() : TLMethod<TLAbsDialogs>() {
    @Transient
    var excludePinned: Boolean = false

    var offsetDate: Int = 0

    var offsetId: Int = 0

    var offsetPeer: TLAbsInputPeer = TLInputPeerEmpty()

    var limit: Int = 0

    private val _constructor: String = "messages.getDialogs#191ba9c5"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            excludePinned: Boolean,
            offsetDate: Int,
            offsetId: Int,
            offsetPeer: TLAbsInputPeer,
            limit: Int
    ) : this() {
        this.excludePinned = excludePinned
        this.offsetDate = offsetDate
        this.offsetId = offsetId
        this.offsetPeer = offsetPeer
        this.limit = limit
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLAbsDialogs = tlDeserializer.readTLObject()

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(excludePinned, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(offsetDate)
        writeInt(offsetId)
        writeTLObject(offsetPeer)
        writeInt(limit)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        excludePinned = isMask(1)
        offsetDate = readInt()
        offsetId = readInt()
        offsetPeer = readTLObject<TLAbsInputPeer>()
        limit = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += offsetPeer.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetDialogs) return false
        if (other === this) return true

        return _flags == other._flags
                && excludePinned == other.excludePinned
                && offsetDate == other.offsetDate
                && offsetId == other.offsetId
                && offsetPeer == other.offsetPeer
                && limit == other.limit
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x191ba9c5.toInt()
    }
}
