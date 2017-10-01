package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputMediaGeoPoint#f9c44144
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaGeoPoint() : TLAbsInputMedia() {
    var geoPoint: TLAbsInputGeoPoint = TLInputGeoPointEmpty()

    private val _constructor: String = "inputMediaGeoPoint#f9c44144"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(geoPoint: TLAbsInputGeoPoint) : this() {
        this.geoPoint = geoPoint
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(geoPoint)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        geoPoint = readTLObject<TLAbsInputGeoPoint>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += geoPoint.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaGeoPoint) return false
        if (other === this) return true

        return geoPoint == other.geoPoint
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf9c44144.toInt()
    }
}
