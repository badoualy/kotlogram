package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBool
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
import kotlin.jvm.Transient

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesSetBotCallbackAnswer() : TLMethod<TLBool>() {
    @Transient
    var alert: Boolean = false

    var queryId: Long = 0L

    var message: String? = null

    var url: String? = null

    var cacheTime: Int = 0

    private val _constructor: String = "messages.setBotCallbackAnswer#d58f130a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            alert: Boolean,
            queryId: Long,
            message: String?,
            url: String?,
            cacheTime: Int
    ) : this() {
        this.alert = alert
        this.queryId = queryId
        this.message = message
        this.url = url
        this.cacheTime = cacheTime
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(alert, 2)
        updateFlags(message, 1)
        updateFlags(url, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeLong(queryId)
        doIfMask(message, 1) { writeString(it) }
        doIfMask(url, 4) { writeString(it) }
        writeInt(cacheTime)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        alert = isMask(2)
        queryId = readLong()
        message = readIfMask(1) { readString() }
        url = readIfMask(4) { readString() }
        cacheTime = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT64
        size += getIntIfMask(message, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(url, 4) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesSetBotCallbackAnswer) return false
        if (other === this) return true

        return _flags == other._flags
                && alert == other.alert
                && queryId == other.queryId
                && message == other.message
                && url == other.url
                && cacheTime == other.cacheTime
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xd58f130a.toInt()
    }
}
