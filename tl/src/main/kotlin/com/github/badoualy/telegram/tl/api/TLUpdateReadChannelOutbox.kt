package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateReadChannelOutbox#25d6c9c7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateReadChannelOutbox() : TLAbsUpdate() {
    var channelId: Int = 0

    var maxId: Int = 0

    private val _constructor: String = "updateReadChannelOutbox#25d6c9c7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(channelId: Int, maxId: Int) : this() {
        this.channelId = channelId
        this.maxId = maxId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(channelId)
        writeInt(maxId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readInt()
        maxId = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateReadChannelOutbox) return false
        if (other === this) return true

        return channelId == other.channelId
                && maxId == other.maxId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x25d6c9c7.toInt()
    }
}
