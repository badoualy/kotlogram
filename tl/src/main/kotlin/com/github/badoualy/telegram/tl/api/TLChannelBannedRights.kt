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
import kotlin.jvm.Transient

/**
 * channelBannedRights#58cf4249
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelBannedRights() : TLObject() {
    @Transient
    var viewMessages: Boolean = false

    @Transient
    var sendMessages: Boolean = false

    @Transient
    var sendMedia: Boolean = false

    @Transient
    var sendStickers: Boolean = false

    @Transient
    var sendGifs: Boolean = false

    @Transient
    var sendGames: Boolean = false

    @Transient
    var sendInline: Boolean = false

    @Transient
    var embedLinks: Boolean = false

    var untilDate: Int = 0

    private val _constructor: String = "channelBannedRights#58cf4249"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            viewMessages: Boolean,
            sendMessages: Boolean,
            sendMedia: Boolean,
            sendStickers: Boolean,
            sendGifs: Boolean,
            sendGames: Boolean,
            sendInline: Boolean,
            embedLinks: Boolean,
            untilDate: Int
    ) : this() {
        this.viewMessages = viewMessages
        this.sendMessages = sendMessages
        this.sendMedia = sendMedia
        this.sendStickers = sendStickers
        this.sendGifs = sendGifs
        this.sendGames = sendGames
        this.sendInline = sendInline
        this.embedLinks = embedLinks
        this.untilDate = untilDate
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(viewMessages, 1)
        updateFlags(sendMessages, 2)
        updateFlags(sendMedia, 4)
        updateFlags(sendStickers, 8)
        updateFlags(sendGifs, 16)
        updateFlags(sendGames, 32)
        updateFlags(sendInline, 64)
        updateFlags(embedLinks, 128)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(untilDate)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        viewMessages = isMask(1)
        sendMessages = isMask(2)
        sendMedia = isMask(4)
        sendStickers = isMask(8)
        sendGifs = isMask(16)
        sendGames = isMask(32)
        sendInline = isMask(64)
        embedLinks = isMask(128)
        untilDate = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelBannedRights) return false
        if (other === this) return true

        return _flags == other._flags
                && viewMessages == other.viewMessages
                && sendMessages == other.sendMessages
                && sendMedia == other.sendMedia
                && sendStickers == other.sendStickers
                && sendGifs == other.sendGifs
                && sendGames == other.sendGames
                && sendInline == other.sendInline
                && embedLinks == other.embedLinks
                && untilDate == other.untilDate
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x58cf4249.toInt()
    }
}
