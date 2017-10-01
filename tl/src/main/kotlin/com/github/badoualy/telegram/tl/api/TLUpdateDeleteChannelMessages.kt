package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLIntVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateDeleteChannelMessages#c37521c9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateDeleteChannelMessages() : TLAbsUpdate() {
    var channelId: Int = 0

    var messages: TLIntVector = TLIntVector()

    var pts: Int = 0

    var ptsCount: Int = 0

    private val _constructor: String = "updateDeleteChannelMessages#c37521c9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channelId: Int,
            messages: TLIntVector,
            pts: Int,
            ptsCount: Int
    ) : this() {
        this.channelId = channelId
        this.messages = messages
        this.pts = pts
        this.ptsCount = ptsCount
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(channelId)
        writeTLVector(messages)
        writeInt(pts)
        writeInt(ptsCount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readInt()
        messages = readTLIntVector()
        pts = readInt()
        ptsCount = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += messages.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateDeleteChannelMessages) return false
        if (other === this) return true

        return channelId == other.channelId
                && messages == other.messages
                && pts == other.pts
                && ptsCount == other.ptsCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc37521c9.toInt()
    }
}
