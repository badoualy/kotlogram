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
 * paymentRequestedInfo#909c3f94
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPaymentRequestedInfo() : TLObject() {
    var name: String? = null

    var phone: String? = null

    var email: String? = null

    var shippingAddress: TLPostAddress? = null

    private val _constructor: String = "paymentRequestedInfo#909c3f94"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            name: String?,
            phone: String?,
            email: String?,
            shippingAddress: TLPostAddress?
    ) : this() {
        this.name = name
        this.phone = phone
        this.email = email
        this.shippingAddress = shippingAddress
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(name, 1)
        updateFlags(phone, 2)
        updateFlags(email, 4)
        updateFlags(shippingAddress, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(name, 1) { writeString(it) }
        doIfMask(phone, 2) { writeString(it) }
        doIfMask(email, 4) { writeString(it) }
        doIfMask(shippingAddress, 8) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        name = readIfMask(1) { readString() }
        phone = readIfMask(2) { readString() }
        email = readIfMask(4) { readString() }
        shippingAddress = readIfMask(8) { readTLObject<TLPostAddress>(TLPostAddress::class, TLPostAddress.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(name, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(phone, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(email, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(shippingAddress, 8) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPaymentRequestedInfo) return false
        if (other === this) return true

        return _flags == other._flags
                && name == other.name
                && phone == other.phone
                && email == other.email
                && shippingAddress == other.shippingAddress
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x909c3f94.toInt()
    }
}
