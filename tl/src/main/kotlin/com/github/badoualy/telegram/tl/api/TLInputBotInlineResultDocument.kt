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
 * inputBotInlineResultDocument#fff8fdc4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBotInlineResultDocument() : TLAbsInputBotInlineResult() {
    override var id: String = ""

    var type: String = ""

    var title: String? = null

    var description: String? = null

    var document: TLAbsInputDocument = TLInputDocumentEmpty()

    override var sendMessage: TLAbsInputBotInlineMessage = TLInputBotInlineMessageGame()

    private val _constructor: String = "inputBotInlineResultDocument#fff8fdc4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: String,
            type: String,
            title: String?,
            description: String?,
            document: TLAbsInputDocument,
            sendMessage: TLAbsInputBotInlineMessage
    ) : this() {
        this.id = id
        this.type = type
        this.title = title
        this.description = description
        this.document = document
        this.sendMessage = sendMessage
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(title, 2)
        updateFlags(description, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(id)
        writeString(type)
        doIfMask(title, 2) { writeString(it) }
        doIfMask(description, 4) { writeString(it) }
        writeTLObject(document)
        writeTLObject(sendMessage)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readString()
        type = readString()
        title = readIfMask(2) { readString() }
        description = readIfMask(4) { readString() }
        document = readTLObject<TLAbsInputDocument>()
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
        size += document.computeSerializedSize()
        size += sendMessage.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBotInlineResultDocument) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && type == other.type
                && title == other.title
                && description == other.description
                && document == other.document
                && sendMessage == other.sendMessage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfff8fdc4.toInt()
    }
}
