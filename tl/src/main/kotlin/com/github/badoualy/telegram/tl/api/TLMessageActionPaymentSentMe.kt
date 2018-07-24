package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * messageActionPaymentSentMe#8f31b327
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionPaymentSentMe() : TLAbsMessageAction() {
    var currency: String = ""

    var totalAmount: Long = 0L

    var payload: TLBytes = TLBytes.EMPTY

    var info: TLPaymentRequestedInfo? = null

    var shippingOptionId: String? = null

    var charge: TLPaymentCharge = TLPaymentCharge()

    private val _constructor: String = "messageActionPaymentSentMe#8f31b327"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            currency: String,
            totalAmount: Long,
            payload: TLBytes,
            info: TLPaymentRequestedInfo?,
            shippingOptionId: String?,
            charge: TLPaymentCharge
    ) : this() {
        this.currency = currency
        this.totalAmount = totalAmount
        this.payload = payload
        this.info = info
        this.shippingOptionId = shippingOptionId
        this.charge = charge
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(info, 1)
        updateFlags(shippingOptionId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(currency)
        writeLong(totalAmount)
        writeTLBytes(payload)
        doIfMask(info, 1) { writeTLObject(it) }
        doIfMask(shippingOptionId, 2) { writeString(it) }
        writeTLObject(charge)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        currency = readString()
        totalAmount = readLong()
        payload = readTLBytes()
        info = readIfMask(1) { readTLObject<TLPaymentRequestedInfo>(TLPaymentRequestedInfo::class, TLPaymentRequestedInfo.CONSTRUCTOR_ID) }
        shippingOptionId = readIfMask(2) { readString() }
        charge = readTLObject<TLPaymentCharge>(TLPaymentCharge::class, TLPaymentCharge.CONSTRUCTOR_ID)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += computeTLBytesSerializedSize(payload)
        size += getIntIfMask(info, 1) { it.computeSerializedSize() }
        size += getIntIfMask(shippingOptionId, 2) { computeTLStringSerializedSize(it) }
        size += charge.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionPaymentSentMe) return false
        if (other === this) return true

        return _flags == other._flags
                && currency == other.currency
                && totalAmount == other.totalAmount
                && payload == other.payload
                && info == other.info
                && shippingOptionId == other.shippingOptionId
                && charge == other.charge
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8f31b327.toInt()
    }
}
