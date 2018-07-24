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
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * messageMediaInvoice#84551347
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaInvoice() : TLAbsMessageMedia() {
    @Transient
    var shippingAddressRequested: Boolean = false

    @Transient
    var test: Boolean = false

    var title: String = ""

    var description: String = ""

    var photo: TLAbsWebDocument? = null

    var receiptMsgId: Int? = null

    var currency: String = ""

    var totalAmount: Long = 0L

    var startParam: String = ""

    private val _constructor: String = "messageMediaInvoice#84551347"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            shippingAddressRequested: Boolean,
            test: Boolean,
            title: String,
            description: String,
            photo: TLAbsWebDocument?,
            receiptMsgId: Int?,
            currency: String,
            totalAmount: Long,
            startParam: String
    ) : this() {
        this.shippingAddressRequested = shippingAddressRequested
        this.test = test
        this.title = title
        this.description = description
        this.photo = photo
        this.receiptMsgId = receiptMsgId
        this.currency = currency
        this.totalAmount = totalAmount
        this.startParam = startParam
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(shippingAddressRequested, 2)
        updateFlags(test, 8)
        updateFlags(photo, 1)
        updateFlags(receiptMsgId, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(title)
        writeString(description)
        doIfMask(photo, 1) { writeTLObject(it) }
        doIfMask(receiptMsgId, 4) { writeInt(it) }
        writeString(currency)
        writeLong(totalAmount)
        writeString(startParam)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        shippingAddressRequested = isMask(2)
        test = isMask(8)
        title = readString()
        description = readString()
        photo = readIfMask(1) { readTLObject<TLAbsWebDocument>() }
        receiptMsgId = readIfMask(4) { readInt() }
        currency = readString()
        totalAmount = readLong()
        startParam = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += computeTLStringSerializedSize(description)
        size += getIntIfMask(photo, 1) { it.computeSerializedSize() }
        size += getIntIfMask(receiptMsgId, 4) { SIZE_INT32 }
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        size += computeTLStringSerializedSize(startParam)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaInvoice) return false
        if (other === this) return true

        return _flags == other._flags
                && shippingAddressRequested == other.shippingAddressRequested
                && test == other.test
                && title == other.title
                && description == other.description
                && photo == other.photo
                && receiptMsgId == other.receiptMsgId
                && currency == other.currency
                && totalAmount == other.totalAmount
                && startParam == other.startParam
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x84551347.toInt()
    }
}
