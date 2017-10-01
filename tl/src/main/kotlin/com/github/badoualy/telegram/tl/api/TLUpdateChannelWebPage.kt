package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateChannelWebPage#40771900
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateChannelWebPage() : TLAbsUpdate() {
    var channelId: Int = 0

    var webpage: TLAbsWebPage = TLWebPageEmpty()

    var pts: Int = 0

    var ptsCount: Int = 0

    private val _constructor: String = "updateChannelWebPage#40771900"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            channelId: Int,
            webpage: TLAbsWebPage,
            pts: Int,
            ptsCount: Int
    ) : this() {
        this.channelId = channelId
        this.webpage = webpage
        this.pts = pts
        this.ptsCount = ptsCount
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(channelId)
        writeTLObject(webpage)
        writeInt(pts)
        writeInt(ptsCount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        channelId = readInt()
        webpage = readTLObject<TLAbsWebPage>()
        pts = readInt()
        ptsCount = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += webpage.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateChannelWebPage) return false
        if (other === this) return true

        return channelId == other.channelId
                && webpage == other.webpage
                && pts == other.pts
                && ptsCount == other.ptsCount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x40771900.toInt()
    }
}
