package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateShortChatMessage#16812688
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateShortChatMessage() : TLAbsUpdates() {
    @Transient
    var out: Boolean = false

    @Transient
    var mentioned: Boolean = false

    @Transient
    var mediaUnread: Boolean = false

    @Transient
    var silent: Boolean = false

    var id: Int = 0

    var fromId: Int = 0

    var chatId: Int = 0

    var message: String = ""

    var pts: Int = 0

    var ptsCount: Int = 0

    var date: Int = 0

    var fwdFrom: TLMessageFwdHeader? = null

    var viaBotId: Int? = null

    var replyToMsgId: Int? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    private val _constructor: String = "updateShortChatMessage#16812688"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            out: Boolean,
            mentioned: Boolean,
            mediaUnread: Boolean,
            silent: Boolean,
            id: Int,
            fromId: Int,
            chatId: Int,
            message: String,
            pts: Int,
            ptsCount: Int,
            date: Int,
            fwdFrom: TLMessageFwdHeader?,
            viaBotId: Int?,
            replyToMsgId: Int?,
            entities: TLObjectVector<TLAbsMessageEntity>?
    ) : this() {
        this.out = out
        this.mentioned = mentioned
        this.mediaUnread = mediaUnread
        this.silent = silent
        this.id = id
        this.fromId = fromId
        this.chatId = chatId
        this.message = message
        this.pts = pts
        this.ptsCount = ptsCount
        this.date = date
        this.fwdFrom = fwdFrom
        this.viaBotId = viaBotId
        this.replyToMsgId = replyToMsgId
        this.entities = entities
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(out, 2)
        updateFlags(mentioned, 16)
        updateFlags(mediaUnread, 32)
        updateFlags(silent, 8192)
        updateFlags(fwdFrom, 4)
        updateFlags(viaBotId, 2048)
        updateFlags(replyToMsgId, 8)
        updateFlags(entities, 128)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeInt(fromId)
        writeInt(chatId)
        writeString(message)
        writeInt(pts)
        writeInt(ptsCount)
        writeInt(date)
        doIfMask(fwdFrom, 4) { writeTLObject(it) }
        doIfMask(viaBotId, 2048) { writeInt(it) }
        doIfMask(replyToMsgId, 8) { writeInt(it) }
        doIfMask(entities, 128) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        out = isMask(2)
        mentioned = isMask(16)
        mediaUnread = isMask(32)
        silent = isMask(8192)
        id = readInt()
        fromId = readInt()
        chatId = readInt()
        message = readString()
        pts = readInt()
        ptsCount = readInt()
        date = readInt()
        fwdFrom = readIfMask(4) { readTLObject<TLMessageFwdHeader>(TLMessageFwdHeader::class, TLMessageFwdHeader.CONSTRUCTOR_ID) }
        viaBotId = readIfMask(2048) { readInt() }
        replyToMsgId = readIfMask(8) { readInt() }
        entities = readIfMask(128) { readTLVector<TLAbsMessageEntity>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(message)
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(fwdFrom, 4) { it.computeSerializedSize() }
        size += getIntIfMask(viaBotId, 2048) { SIZE_INT32 }
        size += getIntIfMask(replyToMsgId, 8) { SIZE_INT32 }
        size += getIntIfMask(entities, 128) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateShortChatMessage) return false
        if (other === this) return true

        return _flags == other._flags
                && out == other.out
                && mentioned == other.mentioned
                && mediaUnread == other.mediaUnread
                && silent == other.silent
                && id == other.id
                && fromId == other.fromId
                && chatId == other.chatId
                && message == other.message
                && pts == other.pts
                && ptsCount == other.ptsCount
                && date == other.date
                && fwdFrom == other.fwdFrom
                && viaBotId == other.viaBotId
                && replyToMsgId == other.replyToMsgId
                && entities == other.entities
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x16812688.toInt()
    }
}
