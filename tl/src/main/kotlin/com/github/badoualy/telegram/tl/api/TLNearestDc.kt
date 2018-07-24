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
 * nearestDc#8e1a1775
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLNearestDc() : TLObject() {
    var country: String = ""

    var thisDc: Int = 0

    var nearestDc: Int = 0

    private val _constructor: String = "nearestDc#8e1a1775"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            country: String,
            thisDc: Int,
            nearestDc: Int
    ) : this() {
        this.country = country
        this.thisDc = thisDc
        this.nearestDc = nearestDc
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(country)
        writeInt(thisDc)
        writeInt(nearestDc)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        country = readString()
        thisDc = readInt()
        nearestDc = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(country)
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLNearestDc) return false
        if (other === this) return true

        return country == other.country
                && thisDc == other.thisDc
                && nearestDc == other.nearestDc
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8e1a1775.toInt()
    }
}
