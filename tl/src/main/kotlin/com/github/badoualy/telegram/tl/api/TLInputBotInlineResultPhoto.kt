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
 * inputBotInlineResultPhoto#a8d864a7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBotInlineResultPhoto() : TLAbsInputBotInlineResult() {
    override var id: String = ""

    var type: String = ""

    var photo: TLAbsInputPhoto = TLInputPhotoEmpty()

    override var sendMessage: TLAbsInputBotInlineMessage = TLInputBotInlineMessageGame()

    private val _constructor: String = "inputBotInlineResultPhoto#a8d864a7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: String,
            type: String,
            photo: TLAbsInputPhoto,
            sendMessage: TLAbsInputBotInlineMessage
    ) : this() {
        this.id = id
        this.type = type
        this.photo = photo
        this.sendMessage = sendMessage
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(id)
        writeString(type)
        writeTLObject(photo)
        writeTLObject(sendMessage)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readString()
        type = readString()
        photo = readTLObject<TLAbsInputPhoto>()
        sendMessage = readTLObject<TLAbsInputBotInlineMessage>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(id)
        size += computeTLStringSerializedSize(type)
        size += photo.computeSerializedSize()
        size += sendMessage.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBotInlineResultPhoto) return false
        if (other === this) return true

        return id == other.id
                && type == other.type
                && photo == other.photo
                && sendMessage == other.sendMessage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa8d864a7.toInt()
    }
}
