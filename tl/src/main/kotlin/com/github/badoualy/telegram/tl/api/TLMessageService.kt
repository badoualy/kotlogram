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
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * messageService#9e19a1f6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageService() : TLAbsMessage() {
    @Transient
    var out: Boolean = false

    @Transient
    var mentioned: Boolean = false

    @Transient
    var mediaUnread: Boolean = false

    @Transient
    var silent: Boolean = false

    @Transient
    var post: Boolean = false

    override var id: Int = 0

    var fromId: Int? = null

    var toId: TLAbsPeer = TLPeerUser()

    var replyToMsgId: Int? = null

    var date: Int = 0

    var action: TLAbsMessageAction = TLMessageActionEmpty()

    private val _constructor: String = "messageService#9e19a1f6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            out: Boolean,
            mentioned: Boolean,
            mediaUnread: Boolean,
            silent: Boolean,
            post: Boolean,
            id: Int,
            fromId: Int?,
            toId: TLAbsPeer,
            replyToMsgId: Int?,
            date: Int,
            action: TLAbsMessageAction
    ) : this() {
        this.out = out
        this.mentioned = mentioned
        this.mediaUnread = mediaUnread
        this.silent = silent
        this.post = post
        this.id = id
        this.fromId = fromId
        this.toId = toId
        this.replyToMsgId = replyToMsgId
        this.date = date
        this.action = action
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(out, 2)
        updateFlags(mentioned, 16)
        updateFlags(mediaUnread, 32)
        updateFlags(silent, 8192)
        updateFlags(post, 16384)
        updateFlags(fromId, 256)
        updateFlags(replyToMsgId, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        doIfMask(fromId, 256) { writeInt(it) }
        writeTLObject(toId)
        doIfMask(replyToMsgId, 8) { writeInt(it) }
        writeInt(date)
        writeTLObject(action)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        out = isMask(2)
        mentioned = isMask(16)
        mediaUnread = isMask(32)
        silent = isMask(8192)
        post = isMask(16384)
        id = readInt()
        fromId = readIfMask(256) { readInt() }
        toId = readTLObject<TLAbsPeer>()
        replyToMsgId = readIfMask(8) { readInt() }
        date = readInt()
        action = readTLObject<TLAbsMessageAction>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(fromId, 256) { SIZE_INT32 }
        size += toId.computeSerializedSize()
        size += getIntIfMask(replyToMsgId, 8) { SIZE_INT32 }
        size += SIZE_INT32
        size += action.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageService) return false
        if (other === this) return true

        return _flags == other._flags
                && out == other.out
                && mentioned == other.mentioned
                && mediaUnread == other.mediaUnread
                && silent == other.silent
                && post == other.post
                && id == other.id
                && fromId == other.fromId
                && toId == other.toId
                && replyToMsgId == other.replyToMsgId
                && date == other.date
                && action == other.action
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9e19a1f6.toInt()
    }
}
