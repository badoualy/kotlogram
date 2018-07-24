package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * messages.botCallbackAnswer#36585ea4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLBotCallbackAnswer() : TLObject() {
    @Transient
    var alert: Boolean = false

    @Transient
    var hasUrl: Boolean = false

    @Transient
    var nativeUi: Boolean = false

    var message: String? = null

    var url: String? = null

    var cacheTime: Int = 0

    private val _constructor: String = "messages.botCallbackAnswer#36585ea4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            alert: Boolean,
            hasUrl: Boolean,
            nativeUi: Boolean,
            message: String?,
            url: String?,
            cacheTime: Int
    ) : this() {
        this.alert = alert
        this.hasUrl = hasUrl
        this.nativeUi = nativeUi
        this.message = message
        this.url = url
        this.cacheTime = cacheTime
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(alert, 2)
        updateFlags(hasUrl, 8)
        updateFlags(nativeUi, 16)
        updateFlags(message, 1)
        updateFlags(url, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(message, 1) { writeString(it) }
        doIfMask(url, 4) { writeString(it) }
        writeInt(cacheTime)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        alert = isMask(2)
        hasUrl = isMask(8)
        nativeUi = isMask(16)
        message = readIfMask(1) { readString() }
        url = readIfMask(4) { readString() }
        cacheTime = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(message, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(url, 4) { computeTLStringSerializedSize(it) }
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLBotCallbackAnswer) return false
        if (other === this) return true

        return _flags == other._flags
                && alert == other.alert
                && hasUrl == other.hasUrl
                && nativeUi == other.nativeUi
                && message == other.message
                && url == other.url
                && cacheTime == other.cacheTime
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x36585ea4.toInt()
    }
}
