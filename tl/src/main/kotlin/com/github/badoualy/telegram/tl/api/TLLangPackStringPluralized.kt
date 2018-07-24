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
import kotlin.String
import kotlin.jvm.Throws

/**
 * langPackStringPluralized#6c47ac9f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLLangPackStringPluralized() : TLAbsLangPackString() {
    override var key: String = ""

    var zeroValue: String? = null

    var oneValue: String? = null

    var twoValue: String? = null

    var fewValue: String? = null

    var manyValue: String? = null

    var otherValue: String = ""

    private val _constructor: String = "langPackStringPluralized#6c47ac9f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            key: String,
            zeroValue: String?,
            oneValue: String?,
            twoValue: String?,
            fewValue: String?,
            manyValue: String?,
            otherValue: String
    ) : this() {
        this.key = key
        this.zeroValue = zeroValue
        this.oneValue = oneValue
        this.twoValue = twoValue
        this.fewValue = fewValue
        this.manyValue = manyValue
        this.otherValue = otherValue
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(zeroValue, 1)
        updateFlags(oneValue, 2)
        updateFlags(twoValue, 4)
        updateFlags(fewValue, 8)
        updateFlags(manyValue, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(key)
        doIfMask(zeroValue, 1) { writeString(it) }
        doIfMask(oneValue, 2) { writeString(it) }
        doIfMask(twoValue, 4) { writeString(it) }
        doIfMask(fewValue, 8) { writeString(it) }
        doIfMask(manyValue, 16) { writeString(it) }
        writeString(otherValue)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        key = readString()
        zeroValue = readIfMask(1) { readString() }
        oneValue = readIfMask(2) { readString() }
        twoValue = readIfMask(4) { readString() }
        fewValue = readIfMask(8) { readString() }
        manyValue = readIfMask(16) { readString() }
        otherValue = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(key)
        size += getIntIfMask(zeroValue, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(oneValue, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(twoValue, 4) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(fewValue, 8) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(manyValue, 16) { computeTLStringSerializedSize(it) }
        size += computeTLStringSerializedSize(otherValue)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLLangPackStringPluralized) return false
        if (other === this) return true

        return _flags == other._flags
                && key == other.key
                && zeroValue == other.zeroValue
                && oneValue == other.oneValue
                && twoValue == other.twoValue
                && fewValue == other.fewValue
                && manyValue == other.manyValue
                && otherValue == other.otherValue
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6c47ac9f.toInt()
    }
}
