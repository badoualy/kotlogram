package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.api.TLAbsInputPrivacyKey
import com.github.badoualy.telegram.tl.api.TLInputPrivacyKeyStatusTimestamp
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountGetPrivacy() : TLMethod<TLPrivacyRules>() {
    var key: TLAbsInputPrivacyKey = TLInputPrivacyKeyStatusTimestamp()

    private val _constructor: String = "account.getPrivacy#dadbc950"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(key: TLAbsInputPrivacyKey) : this() {
        this.key = key
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLPrivacyRules = tlDeserializer.readTLObject(TLPrivacyRules::class, TLPrivacyRules.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(key)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        key = readTLObject<TLAbsInputPrivacyKey>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += key.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountGetPrivacy) return false
        if (other === this) return true

        return key == other.key
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xdadbc950.toInt()
    }
}
