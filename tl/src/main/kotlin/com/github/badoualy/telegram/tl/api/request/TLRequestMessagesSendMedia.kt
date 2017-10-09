package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSendMedia() : TLMethod<TLAbsUpdates>() {
    @Transient
    var silent: Boolean = false

    @Transient
    var background: Boolean = false

    @Transient
    var clearDraft: Boolean = false

    var peer: TLAbsInputPeer = TLInputPeerEmpty()

    var replyToMsgId: Int? = null

    var media: TLAbsInputMedia = TLInputMediaEmpty()

    var randomId: Long = 0L

    var replyMarkup: TLAbsReplyMarkup? = null

    private val _constructor: String = "messages.sendMedia#c8f16791"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            silent: Boolean,
            background: Boolean,
            clearDraft: Boolean,
            peer: TLAbsInputPeer,
            replyToMsgId: Int?,
            media: TLAbsInputMedia,
            randomId: Long,
            replyMarkup: TLAbsReplyMarkup?
    ) : this() {
        this.silent = silent
        this.background = background
        this.clearDraft = clearDraft
        this.peer = peer
        this.replyToMsgId = replyToMsgId
        this.media = media
        this.randomId = randomId
        this.replyMarkup = replyMarkup
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(silent, 32)
        updateFlags(background, 64)
        updateFlags(clearDraft, 128)
        updateFlags(replyToMsgId, 1)
        updateFlags(replyMarkup, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(peer)
        doIfMask(replyToMsgId, 1) { writeInt(it) }
        writeTLObject(media)
        writeLong(randomId)
        doIfMask(replyMarkup, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        silent = isMask(32)
        background = isMask(64)
        clearDraft = isMask(128)
        peer = readTLObject<TLAbsInputPeer>()
        replyToMsgId = readIfMask(1) { readInt() }
        media = readTLObject<TLAbsInputMedia>()
        randomId = readLong()
        replyMarkup = readIfMask(4) { readTLObject<TLAbsReplyMarkup>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += peer.computeSerializedSize()
        size += getIntIfMask(replyToMsgId, 1) { SIZE_INT32 }
        size += media.computeSerializedSize()
        size += SIZE_INT64
        size += getIntIfMask(replyMarkup, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSendMedia) return false
        if (other === this) return true

        return _flags == other._flags
                && silent == other.silent
                && background == other.background
                && clearDraft == other.clearDraft
                && peer == other.peer
                && replyToMsgId == other.replyToMsgId
                && media == other.media
                && randomId == other.randomId
                && replyMarkup == other.replyMarkup
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc8f16791.toInt()
    }
}
