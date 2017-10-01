package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * updateBotPrecheckoutQuery#5d2f3aa9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdateBotPrecheckoutQuery() : TLAbsUpdate() {
    var queryId: Long = 0L

    var userId: Int = 0

    var payload: TLBytes = TLBytes.EMPTY

    var info: TLPaymentRequestedInfo? = null

    var shippingOptionId: String? = null

    var currency: String = ""

    var totalAmount: Long = 0L

    private val _constructor: String = "updateBotPrecheckoutQuery#5d2f3aa9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            queryId: Long,
            userId: Int,
            payload: TLBytes,
            info: TLPaymentRequestedInfo?,
            shippingOptionId: String?,
            currency: String,
            totalAmount: Long
    ) : this() {
        this.queryId = queryId
        this.userId = userId
        this.payload = payload
        this.info = info
        this.shippingOptionId = shippingOptionId
        this.currency = currency
        this.totalAmount = totalAmount
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
        writeLong(queryId)
        writeInt(userId)
        writeTLBytes(payload)
        doIfMask(info, 1) { writeTLObject(it) }
        doIfMask(shippingOptionId, 2) { writeString(it) }
        writeString(currency)
        writeLong(totalAmount)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        queryId = readLong()
        userId = readInt()
        payload = readTLBytes()
        info = readIfMask(1) { readTLObject<TLPaymentRequestedInfo>(TLPaymentRequestedInfo::class, TLPaymentRequestedInfo.CONSTRUCTOR_ID) }
        shippingOptionId = readIfMask(2) { readString() }
        currency = readString()
        totalAmount = readLong()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(payload)
        size += getIntIfMask(info, 1) { it.computeSerializedSize() }
        size += getIntIfMask(shippingOptionId, 2) { computeTLStringSerializedSize(it) }
        size += computeTLStringSerializedSize(currency)
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdateBotPrecheckoutQuery) return false
        if (other === this) return true

        return _flags == other._flags
                && queryId == other.queryId
                && userId == other.userId
                && payload == other.payload
                && info == other.info
                && shippingOptionId == other.shippingOptionId
                && currency == other.currency
                && totalAmount == other.totalAmount
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5d2f3aa9.toInt()
    }
}
