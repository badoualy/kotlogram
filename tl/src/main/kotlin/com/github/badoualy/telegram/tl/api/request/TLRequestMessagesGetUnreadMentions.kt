package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetUnreadMentions() : TLMethod<TLAbsMessages>() {
    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var offsetId: Int = 0

    var addOffset: Int = 0

    var limit: Int = 0

    var maxId: Int = 0

    var minId: Int = 0

    private val _constructor: String = "messages.getUnreadMentions#46578472"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            peer: TLAbsInputPeer,
            offsetId: Int,
            addOffset: Int,
            limit: Int,
            maxId: Int,
            minId: Int
    ) : this() {
        this.peer = peer
        this.offsetId = offsetId
        this.addOffset = addOffset
        this.limit = limit
        this.maxId = maxId
        this.minId = minId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(peer)
        writeInt(offsetId)
        writeInt(addOffset)
        writeInt(limit)
        writeInt(maxId)
        writeInt(minId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        peer = readTLObject<TLAbsInputPeer>()
        offsetId = readInt()
        addOffset = readInt()
        limit = readInt()
        maxId = readInt()
        minId = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += peer.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetUnreadMentions) return false
        if (other === this) return true

        return peer == other.peer
                && offsetId == other.offsetId
                && addOffset == other.addOffset
                && limit == other.limit
                && maxId == other.maxId
                && minId == other.minId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x46578472.toInt()
    }
}
