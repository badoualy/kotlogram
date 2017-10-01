package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageFwdHeader#fadff4ac
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

    private val _constructor: String = "messageFwdHeader#fadff4ac"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            fromId: Int?,
            date: Int,
            channelId: Int?,
            channelPost: Int?,
            postAuthor: String?
    ) : this() {
        this.fromId = fromId
        this.date = date
        this.channelId = channelId
        this.channelPost = channelPost
        this.postAuthor = postAuthor
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(fromId, 1)
        updateFlags(channelId, 2)
        updateFlags(channelPost, 4)
        updateFlags(postAuthor, 8)
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
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        fromId = readIfMask(1) { readInt() }
        date = readInt()
        channelId = readIfMask(2) { readInt() }
        channelPost = readIfMask(4) { readInt() }
        postAuthor = readIfMask(8) { readString() }
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
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfadff4ac.toInt()
    }
}
