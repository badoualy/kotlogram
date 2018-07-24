package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
import kotlin.jvm.Transient

/**
 * invoice#c30aa358
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInvoice() : TLObject() {
    @Transient
    var test: Boolean = false

    @Transient
    var nameRequested: Boolean = false

    @Transient
    var phoneRequested: Boolean = false

    @Transient
    var emailRequested: Boolean = false

    @Transient
    var shippingAddressRequested: Boolean = false

    @Transient
    var flexible: Boolean = false

    @Transient
    var phoneToProvider: Boolean = false

    @Transient
    var emailToProvider: Boolean = false

    var currency: String = ""

    var prices: TLObjectVector<TLLabeledPrice> = TLObjectVector()

    private val _constructor: String = "invoice#c30aa358"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            test: Boolean,
            nameRequested: Boolean,
            phoneRequested: Boolean,
            emailRequested: Boolean,
            shippingAddressRequested: Boolean,
            flexible: Boolean,
            phoneToProvider: Boolean,
            emailToProvider: Boolean,
            currency: String,
            prices: TLObjectVector<TLLabeledPrice>
    ) : this() {
        this.test = test
        this.nameRequested = nameRequested
        this.phoneRequested = phoneRequested
        this.emailRequested = emailRequested
        this.shippingAddressRequested = shippingAddressRequested
        this.flexible = flexible
        this.phoneToProvider = phoneToProvider
        this.emailToProvider = emailToProvider
        this.currency = currency
        this.prices = prices
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(test, 1)
        updateFlags(nameRequested, 2)
        updateFlags(phoneRequested, 4)
        updateFlags(emailRequested, 8)
        updateFlags(shippingAddressRequested, 16)
        updateFlags(flexible, 32)
        updateFlags(phoneToProvider, 64)
        updateFlags(emailToProvider, 128)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(currency)
        writeTLVector(prices)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        test = isMask(1)
        nameRequested = isMask(2)
        phoneRequested = isMask(4)
        emailRequested = isMask(8)
        shippingAddressRequested = isMask(16)
        flexible = isMask(32)
        phoneToProvider = isMask(64)
        emailToProvider = isMask(128)
        currency = readString()
        prices = readTLVector<TLLabeledPrice>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(currency)
        size += prices.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInvoice) return false
        if (other === this) return true

        return _flags == other._flags
                && test == other.test
                && nameRequested == other.nameRequested
                && phoneRequested == other.phoneRequested
                && emailRequested == other.emailRequested
                && shippingAddressRequested == other.shippingAddressRequested
                && flexible == other.flexible
                && phoneToProvider == other.phoneToProvider
                && emailToProvider == other.emailToProvider
                && currency == other.currency
                && prices == other.prices
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc30aa358.toInt()
    }
}
