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
 * channelAdminLogEventActionEditMessage#709b2405
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLChannelAdminLogEventActionEditMessage() : TLAbsChannelAdminLogEventAction() {
    var prevMessage: TLAbsMessage = TLMessageEmpty()

    var newMessage: TLAbsMessage = TLMessageEmpty()

    private val _constructor: String = "channelAdminLogEventActionEditMessage#709b2405"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(prevMessage: TLAbsMessage, newMessage: TLAbsMessage) : this() {
        this.prevMessage = prevMessage
        this.newMessage = newMessage
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(prevMessage)
        writeTLObject(newMessage)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        prevMessage = readTLObject<TLAbsMessage>()
        newMessage = readTLObject<TLAbsMessage>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += prevMessage.computeSerializedSize()
        size += newMessage.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLChannelAdminLogEventActionEditMessage) return false
        if (other === this) return true

        return prevMessage == other.prevMessage
                && newMessage == other.newMessage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x709b2405.toInt()
    }
}
