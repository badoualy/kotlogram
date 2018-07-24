package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputPaymentCredentials
import com.github.badoualy.telegram.tl.api.TLInputPaymentCredentialsApplePay
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestPaymentsSendPaymentForm() : TLMethod<TLAbsPaymentResult>() {
    var msgId: Int = 0

    var requestedInfoId: String? = null

    var shippingOptionId: String? = null

    var credentials: TLAbsInputPaymentCredentials = TLInputPaymentCredentialsApplePay()

    private val _constructor: String = "payments.sendPaymentForm#2b8879b3"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            msgId: Int,
            requestedInfoId: String?,
            shippingOptionId: String?,
            credentials: TLAbsInputPaymentCredentials
    ) : this() {
        this.msgId = msgId
        this.requestedInfoId = requestedInfoId
        this.shippingOptionId = shippingOptionId
        this.credentials = credentials
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(requestedInfoId, 1)
        updateFlags(shippingOptionId, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(msgId)
        doIfMask(requestedInfoId, 1) { writeString(it) }
        doIfMask(shippingOptionId, 2) { writeString(it) }
        writeTLObject(credentials)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        msgId = readInt()
        requestedInfoId = readIfMask(1) { readString() }
        shippingOptionId = readIfMask(2) { readString() }
        credentials = readTLObject<TLAbsInputPaymentCredentials>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += getIntIfMask(requestedInfoId, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(shippingOptionId, 2) { computeTLStringSerializedSize(it) }
        size += credentials.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestPaymentsSendPaymentForm) return false
        if (other === this) return true

        return _flags == other._flags
                && msgId == other.msgId
                && requestedInfoId == other.requestedInfoId
                && shippingOptionId == other.shippingOptionId
                && credentials == other.credentials
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2b8879b3.toInt()
    }
}
