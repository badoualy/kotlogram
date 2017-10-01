package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateChannelReadMessagesContents#89893b45
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChannelReadMessagesContents() : TLAbsUpdate() {
    var channelId: Int = 0

    var messages: TLIntVector = TLIntVector()

    private val _constructor: String = "updateChannelReadMessagesContents#89893b45"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(channelId: Int, messages: TLIntVector) : this() {
        this.channelId = channelId
        this.messages = messages
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(channelId)
        writeTLVector(messages)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readInt()
        messages = readTLIntVector()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += messages.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChannelReadMessagesContents) return false
        if (other === this) return true

        return channelId == other.channelId
                && messages == other.messages
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x89893b45.toInt()
    }
}
