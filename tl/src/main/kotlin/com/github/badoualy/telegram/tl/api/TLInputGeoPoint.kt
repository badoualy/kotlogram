package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputGeoPoint#f3b7acc9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputGeoPoint() : TLAbsInputGeoPoint() {
    var lat: Double = 0.0

    var _long: Double = 0.0

    private val _constructor: String = "inputGeoPoint#f3b7acc9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(lat: Double, _long: Double) : this() {
        this.lat = lat
        this._long = _long
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeDouble(lat)
        writeDouble(_long)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        lat = readDouble()
        _long = readDouble()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_DOUBLE
        size += SIZE_DOUBLE
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputGeoPoint) return false
        if (other === this) return true

        return lat == other.lat
                && _long == other._long
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf3b7acc9.toInt()
    }
}
