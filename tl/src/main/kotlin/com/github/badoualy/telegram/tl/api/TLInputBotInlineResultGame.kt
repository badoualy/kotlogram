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
 * inputBotInlineResultGame#4fa417f2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBotInlineResultGame() : TLAbsInputBotInlineResult() {
    override var id: String = ""

    var shortName: String = ""

    override var sendMessage: TLAbsInputBotInlineMessage = TLInputBotInlineMessageGame()

    private val _constructor: String = "inputBotInlineResultGame#4fa417f2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: String,
            shortName: String,
            sendMessage: TLAbsInputBotInlineMessage
    ) : this() {
        this.id = id
        this.shortName = shortName
        this.sendMessage = sendMessage
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(id)
        writeString(shortName)
        writeTLObject(sendMessage)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readString()
        shortName = readString()
        sendMessage = readTLObject<TLAbsInputBotInlineMessage>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(id)
        size += computeTLStringSerializedSize(shortName)
        size += sendMessage.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBotInlineResultGame) return false
        if (other === this) return true

        return id == other.id
                && shortName == other.shortName
                && sendMessage == other.sendMessage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4fa417f2.toInt()
    }
}
