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
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * postAddress#1e8caaeb
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPostAddress() : TLObject() {
    var streetLine1: String = ""

    var streetLine2: String = ""

    var city: String = ""

    var state: String = ""

    var countryIso2: String = ""

    var postCode: String = ""

    private val _constructor: String = "postAddress#1e8caaeb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            streetLine1: String,
            streetLine2: String,
            city: String,
            state: String,
            countryIso2: String,
            postCode: String
    ) : this() {
        this.streetLine1 = streetLine1
        this.streetLine2 = streetLine2
        this.city = city
        this.state = state
        this.countryIso2 = countryIso2
        this.postCode = postCode
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(streetLine1)
        writeString(streetLine2)
        writeString(city)
        writeString(state)
        writeString(countryIso2)
        writeString(postCode)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        streetLine1 = readString()
        streetLine2 = readString()
        city = readString()
        state = readString()
        countryIso2 = readString()
        postCode = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(streetLine1)
        size += computeTLStringSerializedSize(streetLine2)
        size += computeTLStringSerializedSize(city)
        size += computeTLStringSerializedSize(state)
        size += computeTLStringSerializedSize(countryIso2)
        size += computeTLStringSerializedSize(postCode)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPostAddress) return false
        if (other === this) return true

        return streetLine1 == other.streetLine1
                && streetLine2 == other.streetLine2
                && city == other.city
                && state == other.state
                && countryIso2 == other.countryIso2
                && postCode == other.postCode
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1e8caaeb.toInt()
    }
}
