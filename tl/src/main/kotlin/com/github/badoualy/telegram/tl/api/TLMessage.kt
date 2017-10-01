package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * message#90dddc11
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessage() : TLAbsMessage() {
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

    var toId: TLAbsPeer = TLPeerChannel()

    var fwdFrom: TLMessageFwdHeader? = null

    var viaBotId: Int? = null

    var replyToMsgId: Int? = null

    var date: Int = 0

    var message: String = ""

    var media: TLAbsMessageMedia? = null

    var replyMarkup: TLAbsReplyMarkup? = null

    var entities: TLObjectVector<TLAbsMessageEntity>? = TLObjectVector()

    var views: Int? = null

    var editDate: Int? = null

    var postAuthor: String? = null

    private val _constructor: String = "message#90dddc11"

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
            fwdFrom: TLMessageFwdHeader?,
            viaBotId: Int?,
            replyToMsgId: Int?,
            date: Int,
            message: String,
            media: TLAbsMessageMedia?,
            replyMarkup: TLAbsReplyMarkup?,
            entities: TLObjectVector<TLAbsMessageEntity>?,
            views: Int?,
            editDate: Int?,
            postAuthor: String?
    ) : this() {
        this.out = out
        this.mentioned = mentioned
        this.mediaUnread = mediaUnread
        this.silent = silent
        this.post = post
        this.id = id
        this.fromId = fromId
        this.toId = toId
        this.fwdFrom = fwdFrom
        this.viaBotId = viaBotId
        this.replyToMsgId = replyToMsgId
        this.date = date
        this.message = message
        this.media = media
        this.replyMarkup = replyMarkup
        this.entities = entities
        this.views = views
        this.editDate = editDate
        this.postAuthor = postAuthor
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(out, 2)
        updateFlags(mentioned, 16)
        updateFlags(mediaUnread, 32)
        updateFlags(silent, 8192)
        updateFlags(post, 16384)
        updateFlags(fromId, 256)
        updateFlags(fwdFrom, 4)
        updateFlags(viaBotId, 2048)
        updateFlags(replyToMsgId, 8)
        updateFlags(media, 512)
        updateFlags(replyMarkup, 64)
        updateFlags(entities, 128)
        updateFlags(views, 1024)
        updateFlags(editDate, 32768)
        updateFlags(postAuthor, 65536)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        doIfMask(fromId, 256) { writeInt(it) }
        writeTLObject(toId)
        doIfMask(fwdFrom, 4) { writeTLObject(it) }
        doIfMask(viaBotId, 2048) { writeInt(it) }
        doIfMask(replyToMsgId, 8) { writeInt(it) }
        writeInt(date)
        writeString(message)
        doIfMask(media, 512) { writeTLObject(it) }
        doIfMask(replyMarkup, 64) { writeTLObject(it) }
        doIfMask(entities, 128) { writeTLVector(it) }
        doIfMask(views, 1024) { writeInt(it) }
        doIfMask(editDate, 32768) { writeInt(it) }
        doIfMask(postAuthor, 65536) { writeString(it) }
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
        fwdFrom = readIfMask(4) { readTLObject<TLMessageFwdHeader>(TLMessageFwdHeader::class, TLMessageFwdHeader.CONSTRUCTOR_ID) }
        viaBotId = readIfMask(2048) { readInt() }
        replyToMsgId = readIfMask(8) { readInt() }
        date = readInt()
        message = readString()
        media = readIfMask(512) { readTLObject<TLAbsMessageMedia>() }
        replyMarkup = readIfMask(64) { readTLObject<TLAbsReplyMarkup>() }
        entities = readIfMask(128) { readTLVector<TLAbsMessageEntity>() }
        views = readIfMask(1024) { readInt() }
        editDate = readIfMask(32768) { readInt() }
        postAuthor = readIfMask(65536) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(fromId, 256) { SIZE_INT32 }
        size += toId.computeSerializedSize()
        size += getIntIfMask(fwdFrom, 4) { it.computeSerializedSize() }
        size += getIntIfMask(viaBotId, 2048) { SIZE_INT32 }
        size += getIntIfMask(replyToMsgId, 8) { SIZE_INT32 }
        size += SIZE_INT32
        size += computeTLStringSerializedSize(message)
        size += getIntIfMask(media, 512) { it.computeSerializedSize() }
        size += getIntIfMask(replyMarkup, 64) { it.computeSerializedSize() }
        size += getIntIfMask(entities, 128) { it.computeSerializedSize() }
        size += getIntIfMask(views, 1024) { SIZE_INT32 }
        size += getIntIfMask(editDate, 32768) { SIZE_INT32 }
        size += getIntIfMask(postAuthor, 65536) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessage) return false
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
                && fwdFrom == other.fwdFrom
                && viaBotId == other.viaBotId
                && replyToMsgId == other.replyToMsgId
                && date == other.date
                && message == other.message
                && media == other.media
                && replyMarkup == other.replyMarkup
                && entities == other.entities
                && views == other.views
                && editDate == other.editDate
                && postAuthor == other.postAuthor
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x90dddc11.toInt()
    }
}
