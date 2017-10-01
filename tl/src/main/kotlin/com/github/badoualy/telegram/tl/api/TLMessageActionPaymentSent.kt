package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageActionPaymentSent#40699cd0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageActionPaymentSent() : TLAbsMessageAction() {
    var currency: String = ""

    var totalAmount: Long = 0L

    private val _constructor: String = "messageActionPaymentSent#40699cd0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(currency: String, totalAmount: Long) : this() {
        this.currency = currency
        this.totalAmount = totalAmount
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(currency)
        writeLong(totalAmount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        currency = readString()
        totalAmount = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageActionPaymentSent) return false
        if (other === this) return true

        return currency == other.currency
                && totalAmount == other.totalAmount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x40699cd0.toInt()
    }
}
