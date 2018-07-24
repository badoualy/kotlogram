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
 * botInlineMediaResult#17db940b
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotInlineMediaResult() : TLAbsBotInlineResult() {
    override var id: String = ""

    override var type: String = ""

    var photo: TLAbsPhoto? = null

    var document: TLAbsDocument? = null

    var title: String? = null

    var description: String? = null

    override var sendMessage: TLAbsBotInlineMessage = TLBotInlineMessageMediaAuto()

    private val _constructor: String = "botInlineMediaResult#17db940b"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: String,
            type: String,
            photo: TLAbsPhoto?,
            document: TLAbsDocument?,
            title: String?,
            description: String?,
            sendMessage: TLAbsBotInlineMessage
    ) : this() {
        this.id = id
        this.type = type
        this.photo = photo
        this.document = document
        this.title = title
        this.description = description
        this.sendMessage = sendMessage
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(photo, 1)
        updateFlags(document, 2)
        updateFlags(title, 4)
        updateFlags(description, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(id)
        writeString(type)
        doIfMask(photo, 1) { writeTLObject(it) }
        doIfMask(document, 2) { writeTLObject(it) }
        doIfMask(title, 4) { writeString(it) }
        doIfMask(description, 8) { writeString(it) }
        writeTLObject(sendMessage)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readString()
        type = readString()
        photo = readIfMask(1) { readTLObject<TLAbsPhoto>() }
        document = readIfMask(2) { readTLObject<TLAbsDocument>() }
        title = readIfMask(4) { readString() }
        description = readIfMask(8) { readString() }
        sendMessage = readTLObject<TLAbsBotInlineMessage>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(id)
        size += computeTLStringSerializedSize(type)
        size += getIntIfMask(photo, 1) { it.computeSerializedSize() }
        size += getIntIfMask(document, 2) { it.computeSerializedSize() }
        size += getIntIfMask(title, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(description, 8) { computeTLStringSerializedSize(it) }
        size += sendMessage.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotInlineMediaResult) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && type == other.type
                && photo == other.photo
                && document == other.document
                && title == other.title
                && description == other.description
                && sendMessage == other.sendMessage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x17db940b.toInt()
    }
}
