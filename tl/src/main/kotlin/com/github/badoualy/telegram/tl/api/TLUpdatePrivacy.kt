package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * updatePrivacy#ee3b272a
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLUpdatePrivacy() : TLAbsUpdate() {
    var key: TLAbsPrivacyKey = TLPrivacyKeyStatusTimestamp()

    var rules: TLObjectVector<TLAbsPrivacyRule> = TLObjectVector()

    private val _constructor: String = "updatePrivacy#ee3b272a"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(key: TLAbsPrivacyKey, rules: TLObjectVector<TLAbsPrivacyRule>) : this() {
        this.key = key
        this.rules = rules
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(key)
        writeTLVector(rules)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        key = readTLObject<TLAbsPrivacyKey>()
        rules = readTLVector<TLAbsPrivacyRule>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += key.computeSerializedSize()
        size += rules.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLUpdatePrivacy) return false
        if (other === this) return true

        return key == other.key
                && rules == other.rules
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xee3b272a.toInt()
    }
}
