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
import kotlin.String
import kotlin.jvm.Throws

/**
 * messageMediaVenue#2ec0533f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaVenue() : TLAbsMessageMedia() {
    var geo: TLAbsGeoPoint = TLGeoPointEmpty()

    var title: String = ""

    var address: String = ""

    var provider: String = ""

    var venueId: String = ""

    var venueType: String = ""

    private val _constructor: String = "messageMediaVenue#2ec0533f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            geo: TLAbsGeoPoint,
            title: String,
            address: String,
            provider: String,
            venueId: String,
            venueType: String
    ) : this() {
        this.geo = geo
        this.title = title
        this.address = address
        this.provider = provider
        this.venueId = venueId
        this.venueType = venueType
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(geo)
        writeString(title)
        writeString(address)
        writeString(provider)
        writeString(venueId)
        writeString(venueType)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        geo = readTLObject<TLAbsGeoPoint>()
        title = readString()
        address = readString()
        provider = readString()
        venueId = readString()
        venueType = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += geo.computeSerializedSize()
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(address)
        size += computeTLStringSerializedSize(provider)
        size += computeTLStringSerializedSize(venueId)
        size += computeTLStringSerializedSize(venueType)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaVenue) return false
        if (other === this) return true

        return geo == other.geo
                && title == other.title
                && address == other.address
                && provider == other.provider
                && venueId == other.venueId
                && venueType == other.venueType
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2ec0533f.toInt()
    }
}
