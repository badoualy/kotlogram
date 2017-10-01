package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageMediaVenue#7912b71f
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

    private val _constructor: String = "messageMediaVenue#7912b71f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            geo: TLAbsGeoPoint,
            title: String,
            address: String,
            provider: String,
            venueId: String
    ) : this() {
        this.geo = geo
        this.title = title
        this.address = address
        this.provider = provider
        this.venueId = venueId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(geo)
        writeString(title)
        writeString(address)
        writeString(provider)
        writeString(venueId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        geo = readTLObject<TLAbsGeoPoint>()
        title = readString()
        address = readString()
        provider = readString()
        venueId = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += geo.computeSerializedSize()
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(address)
        size += computeTLStringSerializedSize(provider)
        size += computeTLStringSerializedSize(venueId)
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
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7912b71f.toInt()
    }
}
