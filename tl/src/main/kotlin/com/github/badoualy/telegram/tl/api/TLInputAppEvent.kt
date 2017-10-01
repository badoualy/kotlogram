package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputAppEvent#770656a8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputAppEvent() : TLObject() {
    var time: Double = 0.0

    var type: String = ""

    var peer: Long = 0L

    var data: String = ""

    private val _constructor: String = "inputAppEvent#770656a8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            time: Double,
            type: String,
            peer: Long,
            data: String
    ) : this() {
        this.time = time
        this.type = type
        this.peer = peer
        this.data = data
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeDouble(time)
        writeString(type)
        writeLong(peer)
        writeString(data)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        time = readDouble()
        type = readString()
        peer = readLong()
        data = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_DOUBLE
        size += computeTLStringSerializedSize(type)
        size += SIZE_INT64
        size += computeTLStringSerializedSize(data)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputAppEvent) return false
        if (other === this) return true

        return time == other.time
                && type == other.type
                && peer == other.peer
                && data == other.data
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x770656a8.toInt()
    }
}
