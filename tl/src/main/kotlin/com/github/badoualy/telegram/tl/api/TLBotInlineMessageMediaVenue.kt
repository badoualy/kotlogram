package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * botInlineMessageMediaVenue#4366232e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotInlineMessageMediaVenue() : TLAbsBotInlineMessage() {
    var geo: TLAbsGeoPoint = TLGeoPointEmpty()

    var title: String = ""

    var address: String = ""

    var provider: String = ""

    var venueId: String = ""

    override var replyMarkup: TLAbsReplyMarkup? = null

    private val _constructor: String = "botInlineMessageMediaVenue#4366232e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            geo: TLAbsGeoPoint,
            title: String,
            address: String,
            provider: String,
            venueId: String,
            replyMarkup: TLAbsReplyMarkup?
    ) : this() {
        this.geo = geo
        this.title = title
        this.address = address
        this.provider = provider
        this.venueId = venueId
        this.replyMarkup = replyMarkup
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(replyMarkup, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(geo)
        writeString(title)
        writeString(address)
        writeString(provider)
        writeString(venueId)
        doIfMask(replyMarkup, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        geo = readTLObject<TLAbsGeoPoint>()
        title = readString()
        address = readString()
        provider = readString()
        venueId = readString()
        replyMarkup = readIfMask(4) { readTLObject<TLAbsReplyMarkup>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += geo.computeSerializedSize()
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(address)
        size += computeTLStringSerializedSize(provider)
        size += computeTLStringSerializedSize(venueId)
        size += getIntIfMask(replyMarkup, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotInlineMessageMediaVenue) return false
        if (other === this) return true

        return _flags == other._flags
                && geo == other.geo
                && title == other.title
                && address == other.address
                && provider == other.provider
                && venueId == other.venueId
                && replyMarkup == other.replyMarkup
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x4366232e.toInt()
    }
}
