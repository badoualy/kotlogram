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

/**
 * inputBotInlineResult#88bf9319
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

    var thumb: TLInputWebDocument? = null

    var content: TLInputWebDocument? = null

    override var sendMessage: TLAbsInputBotInlineMessage = TLInputBotInlineMessageGame()

    private val _constructor: String = "inputBotInlineResult#88bf9319"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: String,
            type: String,
            title: String?,
            description: String?,
            url: String?,
            thumb: TLInputWebDocument?,
            content: TLInputWebDocument?,
            sendMessage: TLAbsInputBotInlineMessage
    ) : this() {
        this.id = id
        this.type = type
        this.title = title
        this.description = description
        this.url = url
        this.thumb = thumb
        this.content = content
        this.sendMessage = sendMessage
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(title, 2)
        updateFlags(description, 4)
        updateFlags(url, 8)
        updateFlags(thumb, 16)
        updateFlags(content, 32)
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
        doIfMask(thumb, 16) { writeTLObject(it) }
        doIfMask(content, 32) { writeTLObject(it) }
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
        thumb = readIfMask(16) { readTLObject<TLInputWebDocument>(TLInputWebDocument::class, TLInputWebDocument.CONSTRUCTOR_ID) }
        content = readIfMask(32) { readTLObject<TLInputWebDocument>(TLInputWebDocument::class, TLInputWebDocument.CONSTRUCTOR_ID) }
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
        size += getIntIfMask(thumb, 16) { it.computeSerializedSize() }
        size += getIntIfMask(content, 32) { it.computeSerializedSize() }
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
                && thumb == other.thumb
                && content == other.content
                && sendMessage == other.sendMessage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x88bf9319.toInt()
    }
}
