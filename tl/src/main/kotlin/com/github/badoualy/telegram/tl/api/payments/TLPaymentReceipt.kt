package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLInvoice
import com.github.badoualy.telegram.tl.api.TLPaymentRequestedInfo
import com.github.badoualy.telegram.tl.api.TLShippingOption
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
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
 * payments.paymentReceipt#500911e1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPaymentReceipt() : TLObject() {
    var date: Int = 0

    var botId: Int = 0

    var invoice: TLInvoice = TLInvoice()

    var providerId: Int = 0

    var info: TLPaymentRequestedInfo? = null

    var shipping: TLShippingOption? = null

    var currency: String = ""

    var totalAmount: Long = 0L

    var credentialsTitle: String = ""

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    private val _constructor: String = "payments.paymentReceipt#500911e1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            date: Int,
            botId: Int,
            invoice: TLInvoice,
            providerId: Int,
            info: TLPaymentRequestedInfo?,
            shipping: TLShippingOption?,
            currency: String,
            totalAmount: Long,
            credentialsTitle: String,
            users: TLObjectVector<TLAbsUser>
    ) : this() {
        this.date = date
        this.botId = botId
        this.invoice = invoice
        this.providerId = providerId
        this.info = info
        this.shipping = shipping
        this.currency = currency
        this.totalAmount = totalAmount
        this.credentialsTitle = credentialsTitle
        this.users = users
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(info, 1)
        updateFlags(shipping, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(date)
        writeInt(botId)
        writeTLObject(invoice)
        writeInt(providerId)
        doIfMask(info, 1) { writeTLObject(it) }
        doIfMask(shipping, 2) { writeTLObject(it) }
        writeString(currency)
        writeLong(totalAmount)
        writeString(credentialsTitle)
        writeTLVector(users)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        date = readInt()
        botId = readInt()
        invoice = readTLObject<TLInvoice>(TLInvoice::class, TLInvoice.CONSTRUCTOR_ID)
        providerId = readInt()
        info = readIfMask(1) { readTLObject<TLPaymentRequestedInfo>(TLPaymentRequestedInfo::class, TLPaymentRequestedInfo.CONSTRUCTOR_ID) }
        shipping = readIfMask(2) { readTLObject<TLShippingOption>(TLShippingOption::class, TLShippingOption.CONSTRUCTOR_ID) }
        currency = readString()
        totalAmount = readLong()
        credentialsTitle = readString()
        users = readTLVector<TLAbsUser>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += invoice.computeSerializedSize()
        size += SIZE_INT32
        size += getIntIfMask(info, 1) { it.computeSerializedSize() }
        size += getIntIfMask(shipping, 2) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += computeTLStringSerializedSize(credentialsTitle)
        size += users.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPaymentReceipt) return false
        if (other === this) return true

        return _flags == other._flags
                && date == other.date
                && botId == other.botId
                && invoice == other.invoice
                && providerId == other.providerId
                && info == other.info
                && shipping == other.shipping
                && currency == other.currency
                && totalAmount == other.totalAmount
                && credentialsTitle == other.credentialsTitle
                && users == other.users
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x500911e1.toInt()
    }
}
