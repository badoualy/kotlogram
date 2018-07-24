package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLInputSecureValue
import com.github.badoualy.telegram.tl.api.TLSecureValue
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountSaveSecureValue() : TLMethod<TLSecureValue>() {
    var value: TLInputSecureValue = TLInputSecureValue()

    var secureSecretId: Long = 0L

    private val _constructor: String = "account.saveSecureValue#899fe31d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(value: TLInputSecureValue, secureSecretId: Long) : this() {
        this.value = value
        this.secureSecretId = secureSecretId
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLSecureValue = tlDeserializer.readTLObject(TLSecureValue::class, TLSecureValue.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(value)
        writeLong(secureSecretId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        value = readTLObject<TLInputSecureValue>(TLInputSecureValue::class, TLInputSecureValue.CONSTRUCTOR_ID)
        secureSecretId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += value.computeSerializedSize()
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountSaveSecureValue) return false
        if (other === this) return true

        return value == other.value
                && secureSecretId == other.secureSecretId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x899fe31d.toInt()
    }
}
