package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLShippingOption
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * payments.validatedRequestedInfo#d1451883
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLValidatedRequestedInfo() : TLObject() {
    var id: String? = null

    var shippingOptions: TLObjectVector<TLShippingOption>? = TLObjectVector()

    private val _constructor: String = "payments.validatedRequestedInfo#d1451883"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(id: String?, shippingOptions: TLObjectVector<TLShippingOption>?) : this() {
        this.id = id
        this.shippingOptions = shippingOptions
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(id, 1)
        updateFlags(shippingOptions, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(id, 1) { writeString(it) }
        doIfMask(shippingOptions, 2) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        id = readIfMask(1) { readString() }
        shippingOptions = readIfMask(2) { readTLVector<TLShippingOption>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(id, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(shippingOptions, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLValidatedRequestedInfo) return false
        if (other === this) return true

        return _flags == other._flags
                && id == other.id
                && shippingOptions == other.shippingOptions
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd1451883.toInt()
    }
}
