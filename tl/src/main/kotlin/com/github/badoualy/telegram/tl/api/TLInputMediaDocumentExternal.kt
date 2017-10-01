package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputMediaDocumentExternal#b6f74335
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaDocumentExternal() : TLAbsInputMedia() {
    var url: String = ""

    var caption: String = ""

    var ttlSeconds: Int? = null

    private val _constructor: String = "inputMediaDocumentExternal#b6f74335"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            url: String,
            caption: String,
            ttlSeconds: Int?
    ) : this() {
        this.url = url
        this.caption = caption
        this.ttlSeconds = ttlSeconds
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(ttlSeconds, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(url)
        writeString(caption)
        doIfMask(ttlSeconds, 1) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        url = readString()
        caption = readString()
        ttlSeconds = readIfMask(1) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(url)
        size += computeTLStringSerializedSize(caption)
        size += getIntIfMask(ttlSeconds, 1) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaDocumentExternal) return false
        if (other === this) return true

        return _flags == other._flags
                && url == other.url
                && caption == other.caption
                && ttlSeconds == other.ttlSeconds
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xb6f74335.toInt()
    }
}
