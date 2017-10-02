package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyKey
import com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyRule
import com.github.badoualy.telegram.tl.api.TLInputPrivacyKeyStatusTimestamp
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountSetPrivacy() : TLMethod<TLPrivacyRules>() {
    var key: TLAbsInputPrivacyKey = TLInputPrivacyKeyStatusTimestamp()

    var rules: TLObjectVector<TLAbsInputPrivacyRule> = TLObjectVector()

    private val _constructor: String = "account.setPrivacy#c9f81ce8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(key: TLAbsInputPrivacyKey, rules: TLObjectVector<TLAbsInputPrivacyRule>) : this() {
        this.key = key
        this.rules = rules
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLPrivacyRules = tlDeserializer.readTLObject(TLPrivacyRules::class, TLPrivacyRules.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(key)
        writeTLVector(rules)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        key = readTLObject<TLAbsInputPrivacyKey>()
        rules = readTLVector<TLAbsInputPrivacyRule>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += key.computeSerializedSize()
        size += rules.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountSetPrivacy) return false
        if (other === this) return true

        return key == other.key
                && rules == other.rules
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc9f81ce8.toInt()
    }
}
