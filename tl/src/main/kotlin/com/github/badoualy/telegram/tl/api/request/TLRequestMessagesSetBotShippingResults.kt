package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLShippingOption
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSetBotShippingResults() : TLMethod<TLBool>() {
    var queryId: Long = 0L

    var error: String? = null

    var shippingOptions: TLObjectVector<TLShippingOption>? = TLObjectVector()

    private val _constructor: String = "messages.setBotShippingResults#e5f672fa"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            queryId: Long,
            error: String?,
            shippingOptions: TLObjectVector<TLShippingOption>?
    ) : this() {
        this.queryId = queryId
        this.error = error
        this.shippingOptions = shippingOptions
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(error, 1)
        updateFlags(shippingOptions, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(queryId)
        doIfMask(error, 1) { writeString(it) }
        doIfMask(shippingOptions, 2) { writeTLVector(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        queryId = readLong()
        error = readIfMask(1) { readString() }
        shippingOptions = readIfMask(2) { readTLVector<TLShippingOption>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(error, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(shippingOptions, 2) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSetBotShippingResults) return false
        if (other === this) return true

        return _flags == other._flags
                && queryId == other.queryId
                && error == other.error
                && shippingOptions == other.shippingOptions
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe5f672fa.toInt()
    }
}
