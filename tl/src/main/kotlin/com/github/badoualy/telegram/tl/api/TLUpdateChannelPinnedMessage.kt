package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateChannelPinnedMessage#98592475
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChannelPinnedMessage() : TLAbsUpdate() {
    var channelId: Int = 0

    var id: Int = 0

    private val _constructor: String = "updateChannelPinnedMessage#98592475"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(channelId: Int, id: Int) : this() {
        this.channelId = channelId
        this.id = id
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(channelId)
        writeInt(id)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readInt()
        id = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChannelPinnedMessage) return false
        if (other === this) return true

        return channelId == other.channelId
                && id == other.id
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x98592475.toInt()
    }
}
