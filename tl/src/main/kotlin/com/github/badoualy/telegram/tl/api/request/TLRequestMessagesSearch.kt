package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSearch() : TLMethod<TLAbsMessages>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var q: String = ""

    var fromId: TLAbsInputUser? = null

    var filter: TLAbsMessagesFilter = TLInputMessagesFilterEmpty()

    var minDate: Int = 0

    var maxDate: Int = 0

    var offsetId: Int = 0

    var addOffset: Int = 0

    var limit: Int = 0

    var maxId: Int = 0

    var minId: Int = 0

    private val _constructor: String = "messages.search#39e9ea0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            q: String,
            fromId: TLAbsInputUser?,
            filter: TLAbsMessagesFilter,
            minDate: Int,
            maxDate: Int,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ) : this() {
        this.peer = peer
        this.q = q
        this.fromId = fromId
        this.filter = filter
        this.minDate = minDate
        this.maxDate = maxDate
        this.offsetId = offsetId
        this.addOffset = addOffset
        this.limit = limit
        this.maxId = maxId
        this.minId = minId
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLAbsMessages = tlDeserializer.readTLObject()

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(fromId, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        writeString(q)
        doIfMask(fromId, 1) { writeTLObject(it) }
        writeTLObject(filter)
        writeInt(minDate)
        writeInt(maxDate)
        writeInt(offsetId)
        writeInt(addOffset)
        writeInt(limit)
        writeInt(maxId)
        writeInt(minId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        peer = readTLObject<TLAbsInputPeer>()
        q = readString()
        fromId = readIfMask(1) { readTLObject<TLAbsInputUser>() }
        filter = readTLObject<TLAbsMessagesFilter>()
        minDate = readInt()
        maxDate = readInt()
        offsetId = readInt()
        addOffset = readInt()
        limit = readInt()
        maxId = readInt()
        minId = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += computeTLStringSerializedSize(q)
        size += getIntIfMask(fromId, 1) { it.computeSerializedSize() }
        size += filter.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSearch) return false
        if (other === this) return true

        return _flags == other._flags
                && peer == other.peer
                && q == other.q
                && fromId == other.fromId
                && filter == other.filter
                && minDate == other.minDate
                && maxDate == other.maxDate
                && offsetId == other.offsetId
                && addOffset == other.addOffset
                && limit == other.limit
                && maxId == other.maxId
                && minId == other.minId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x39e9ea0.toInt()
    }
}
