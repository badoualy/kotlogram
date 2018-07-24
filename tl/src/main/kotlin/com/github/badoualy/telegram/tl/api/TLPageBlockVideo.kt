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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * pageBlockVideo#d9d71866
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockVideo() : TLAbsPageBlock() {
    @Transient
    var autoplay: Boolean = false

    @Transient
    var loop: Boolean = false

    var videoId: Long = 0L

    var caption: TLAbsRichText = TLTextEmpty()

    private val _constructor: String = "pageBlockVideo#d9d71866"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            autoplay: Boolean,
            loop: Boolean,
            videoId: Long,
            caption: TLAbsRichText
    ) : this() {
        this.autoplay = autoplay
        this.loop = loop
        this.videoId = videoId
        this.caption = caption
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(autoplay, 1)
        updateFlags(loop, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(videoId)
        writeTLObject(caption)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        autoplay = isMask(1)
        loop = isMask(2)
        videoId = readLong()
        caption = readTLObject<TLAbsRichText>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += caption.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockVideo) return false
        if (other === this) return true

        return _flags == other._flags
                && autoplay == other.autoplay
                && loop == other.loop
                && videoId == other.videoId
                && caption == other.caption
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd9d71866.toInt()
    }
}
