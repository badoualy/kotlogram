package com.github.badoualy.telegram.tl.api.payments

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLPaymentRequestedInfo
import com.github.badoualy.telegram.tl.core.TLObject
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
 * payments.savedInfo#fb8fe43c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSavedInfo() : TLObject() {
    @Transient
    var hasSavedCredentials: Boolean = false

    var savedInfo: TLPaymentRequestedInfo? = null

    private val _constructor: String = "payments.savedInfo#fb8fe43c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(hasSavedCredentials: Boolean, savedInfo: TLPaymentRequestedInfo?) : this() {
        this.hasSavedCredentials = hasSavedCredentials
        this.savedInfo = savedInfo
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(hasSavedCredentials, 2)
        updateFlags(savedInfo, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(savedInfo, 1) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hasSavedCredentials = isMask(2)
        savedInfo = readIfMask(1) { readTLObject<TLPaymentRequestedInfo>(TLPaymentRequestedInfo::class, TLPaymentRequestedInfo.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(savedInfo, 1) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSavedInfo) return false
        if (other === this) return true

        return _flags == other._flags
                && hasSavedCredentials == other.hasSavedCredentials
                && savedInfo == other.savedInfo
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xfb8fe43c.toInt()
    }
}
