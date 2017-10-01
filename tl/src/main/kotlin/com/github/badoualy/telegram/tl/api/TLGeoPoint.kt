package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * geoPoint#2049d70c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLGeoPoint() : TLAbsGeoPoint() {
    var _long: Double = 0.0

    var lat: Double = 0.0

    private val _constructor: String = "geoPoint#2049d70c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(_long: Double, lat: Double) : this() {
        this._long = _long
        this.lat = lat
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeDouble(_long)
        writeDouble(lat)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _long = readDouble()
        lat = readDouble()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_DOUBLE
        size += SIZE_DOUBLE
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLGeoPoint) return false
        if (other === this) return true

        return _long == other._long
                && lat == other.lat
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2049d70c.toInt()
    }
}
