package com.github.badoualy.telegram.tl.api

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
 * messageFwdHeader#559ebe6d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageFwdHeader() : TLObject() {
    var fromId: Int? = null

    var date: Int = 0

    var channelId: Int? = null

    var channelPost: Int? = null

    var postAuthor: String? = null

    var savedFromPeer: TLAbsPeer? = null

    var savedFromMsgId: Int? = null

    private val _constructor: String = "messageFwdHeader#559ebe6d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            fromId: Int?,
            date: Int,
            channelId: Int?,
            channelPost: Int?,
            postAuthor: String?,
            savedFromPeer: TLAbsPeer?,
            savedFromMsgId: Int?
    ) : this() {
        this.fromId = fromId
        this.date = date
        this.channelId = channelId
        this.channelPost = channelPost
        this.postAuthor = postAuthor
        this.savedFromPeer = savedFromPeer
        this.savedFromMsgId = savedFromMsgId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(fromId, 1)
        updateFlags(channelId, 2)
        updateFlags(channelPost, 4)
        updateFlags(postAuthor, 8)
        updateFlags(savedFromPeer, 16)
        updateFlags(savedFromMsgId, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(fromId, 1) { writeInt(it) }
        writeInt(date)
        doIfMask(channelId, 2) { writeInt(it) }
        doIfMask(channelPost, 4) { writeInt(it) }
        doIfMask(postAuthor, 8) { writeString(it) }
        doIfMask(savedFromPeer, 16) { writeTLObject(it) }
        doIfMask(savedFromMsgId, 16) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        fromId = readIfMask(1) { readInt() }
        date = readInt()
        channelId = readIfMask(2) { readInt() }
        channelPost = readIfMask(4) { readInt() }
        postAuthor = readIfMask(8) { readString() }
        savedFromPeer = readIfMask(16) { readTLObject<TLAbsPeer>() }
        savedFromMsgId = readIfMask(16) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(fromId, 1) { SIZE_INT32 }
        size += SIZE_INT32
        size += getIntIfMask(channelId, 2) { SIZE_INT32 }
        size += getIntIfMask(channelPost, 4) { SIZE_INT32 }
        size += getIntIfMask(postAuthor, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(savedFromPeer, 16) { it.computeSerializedSize() }
        size += getIntIfMask(savedFromMsgId, 16) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageFwdHeader) return false
        if (other === this) return true

        return _flags == other._flags
                && fromId == other.fromId
                && date == other.date
                && channelId == other.channelId
                && channelPost == other.channelPost
                && postAuthor == other.postAuthor
                && savedFromPeer == other.savedFromPeer
                && savedFromMsgId == other.savedFromMsgId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x559ebe6d.toInt()
    }
}
