package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * foundGif#162ecc1f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFoundGif() : TLAbsFoundGif() {
    override var url: String = ""

    var thumbUrl: String = ""

    var contentUrl: String = ""

    var contentType: String = ""

    var w: Int = 0

    var h: Int = 0

    private val _constructor: String = "foundGif#162ecc1f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            url: String,
            thumbUrl: String,
            contentUrl: String,
            contentType: String,
            w: Int,
            h: Int
    ) : this() {
        this.url = url
        this.thumbUrl = thumbUrl
        this.contentUrl = contentUrl
        this.contentType = contentType
        this.w = w
        this.h = h
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(url)
        writeString(thumbUrl)
        writeString(contentUrl)
        writeString(contentType)
        writeInt(w)
        writeInt(h)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        url = readString()
        thumbUrl = readString()
        contentUrl = readString()
        contentType = readString()
        w = readInt()
        h = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(url)
        size += computeTLStringSerializedSize(thumbUrl)
        size += computeTLStringSerializedSize(contentUrl)
        size += computeTLStringSerializedSize(contentType)
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFoundGif) return false
        if (other === this) return true

        return url == other.url
                && thumbUrl == other.thumbUrl
                && contentUrl == other.contentUrl
                && contentType == other.contentType
                && w == other.w
                && h == other.h
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x162ecc1f.toInt()
    }
}
