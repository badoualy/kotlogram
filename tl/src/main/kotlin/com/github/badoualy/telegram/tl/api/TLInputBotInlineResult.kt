package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputBotInlineResult#2cbbe15a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBotInlineResult() : TLAbsInputBotInlineResult() {
    override var id: String = ""

    var type: String = ""

    var title: String? = null

    var description: String? = null

    var url: String? = null

    var thumbUrl: String? = null

    var contentUrl: String? = null

    var contentType: String? = null

    var w: Int? = null

    var h: Int? = null

    var duration: Int? = null

    override var sendMessage: TLAbsInputBotInlineMessage = TLInputBotInlineMessageGame()

    private val _constructor: String = "inputBotInlineResult#2cbbe15a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: String,
            type: String,
            title: String?,
            description: String?,
            url: String?,
            thumbUrl: String?,
            contentUrl: String?,
            contentType: String?,
            w: Int?,
            h: Int?,
            duration: Int?,
            sendMessage: TLAbsInputBotInlineMessage
    ) : this() {
        this.id = id
        this.type = type
        this.title = title
        this.description = description
        this.url = url
        this.thumbUrl = thumbUrl
        this.contentUrl = contentUrl
        this.contentType = contentType
        this.w = w
        this.h = h
        this.duration = duration
        this.sendMessage = sendMessage
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(title, 2)
        updateFlags(description, 4)
        updateFlags(url, 8)
        updateFlags(thumbUrl, 16)
        updateFlags(contentUrl, 32)
        updateFlags(contentType, 32)
        updateFlags(w, 64)
        updateFlags(h, 64)
        updateFlags(duration, 128)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(id)
        writeString(type)
        doIfMask(title, 2) { writeString(it) }
        doIfMask(description, 4) { writeString(it) }
        doIfMask(url, 8) { writeString(it) }
        doIfMask(thumbUrl, 16) { writeString(it) }
        doIfMask(contentUrl, 32) { writeString(it) }
        doIfMask(contentType, 32) { writeString(it) }
        doIfMask(w, 64) { writeInt(it) }
        doIfMask(h, 64) { writeInt(it) }
        doIfMask(duration, 128) { writeInt(it) }
        writeTLObject(sendMessage)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readString()
        type = readString()
        title = readIfMask(2) { readString() }
        description = readIfMask(4) { readString() }
        url = readIfMask(8) { readString() }
        thumbUrl = readIfMask(16) { readString() }
        contentUrl = readIfMask(32) { readString() }
        contentType = readIfMask(32) { readString() }
        w = readIfMask(64) { readInt() }
        h = readIfMask(64) { readInt() }
        duration = readIfMask(128) { readInt() }
        sendMessage = readTLObject<TLAbsInputBotInlineMessage>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(id)
        size += computeTLStringSerializedSize(type)
        size += getIntIfMask(title, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(description, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(url, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(thumbUrl, 16) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(contentUrl, 32) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(contentType, 32) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(w, 64) { SIZE_INT32 }
        size += getIntIfMask(h, 64) { SIZE_INT32 }
        size += getIntIfMask(duration, 128) { SIZE_INT32 }
        size += sendMessage.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBotInlineResult) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && type == other.type
                && title == other.title
                && description == other.description
                && url == other.url
                && thumbUrl == other.thumbUrl
                && contentUrl == other.contentUrl
                && contentType == other.contentType
                && w == other.w
                && h == other.h
                && duration == other.duration
                && sendMessage == other.sendMessage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2cbbe15a.toInt()
    }
}
