package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * photoCachedSize#e9a734fa
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhotoCachedSize() : TLAbsPhotoSize() {
    override var type: String = ""

    var location: TLAbsFileLocation = TLFileLocationUnavailable()

    var w: Int = 0

    var h: Int = 0

    var bytes: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "photoCachedSize#e9a734fa"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            type: String,
            location: TLAbsFileLocation,
            w: Int,
            h: Int,
            bytes: TLBytes
    ) : this() {
        this.type = type
        this.location = location
        this.w = w
        this.h = h
        this.bytes = bytes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(type)
        writeTLObject(location)
        writeInt(w)
        writeInt(h)
        writeTLBytes(bytes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        type = readString()
        location = readTLObject<TLAbsFileLocation>()
        w = readInt()
        h = readInt()
        bytes = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(type)
        size += location.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(bytes)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhotoCachedSize) return false
        if (other === this) return true

        return type == other.type
                && location == other.location
                && w == other.w
                && h == other.h
                && bytes == other.bytes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe9a734fa.toInt()
    }
}
