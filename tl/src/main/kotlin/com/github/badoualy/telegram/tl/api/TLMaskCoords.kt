package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Double
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * maskCoords#aed6dbb2
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMaskCoords() : TLObject() {
    var n: Int = 0

    var x: Double = 0.0

    var y: Double = 0.0

    var zoom: Double = 0.0

    private val _constructor: String = "maskCoords#aed6dbb2"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            n: Int,
            x: Double,
            y: Double,
            zoom: Double
    ) : this() {
        this.n = n
        this.x = x
        this.y = y
        this.zoom = zoom
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(n)
        writeDouble(x)
        writeDouble(y)
        writeDouble(zoom)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        n = readInt()
        x = readDouble()
        y = readDouble()
        zoom = readDouble()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_DOUBLE
        size += SIZE_DOUBLE
        size += SIZE_DOUBLE
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMaskCoords) return false
        if (other === this) return true

        return n == other.n
                && x == other.x
                && y == other.y
                && zoom == other.zoom
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xaed6dbb2.toInt()
    }
}
