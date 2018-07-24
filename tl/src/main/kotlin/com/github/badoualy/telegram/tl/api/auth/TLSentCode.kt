package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.help.TLTermsOfService
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
 * auth.sentCode#38faab5f
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSentCode() : TLObject() {
    @Transient
    var phoneRegistered: Boolean = false

    var type: TLAbsSentCodeType = TLSentCodeTypeFlashCall()

    var phoneCodeHash: String = ""

    var nextType: TLAbsCodeType? = null

    var timeout: Int? = null

    var termsOfService: TLTermsOfService? = null

    private val _constructor: String = "auth.sentCode#38faab5f"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            phoneRegistered: Boolean,
            type: TLAbsSentCodeType,
            phoneCodeHash: String,
            nextType: TLAbsCodeType?,
            timeout: Int?,
            termsOfService: TLTermsOfService?
    ) : this() {
        this.phoneRegistered = phoneRegistered
        this.type = type
        this.phoneCodeHash = phoneCodeHash
        this.nextType = nextType
        this.timeout = timeout
        this.termsOfService = termsOfService
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(phoneRegistered, 1)
        updateFlags(nextType, 2)
        updateFlags(timeout, 4)
        updateFlags(termsOfService, 8)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(type)
        writeString(phoneCodeHash)
        doIfMask(nextType, 2) { writeTLObject(it) }
        doIfMask(timeout, 4) { writeInt(it) }
        doIfMask(termsOfService, 8) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        phoneRegistered = isMask(1)
        type = readTLObject<TLAbsSentCodeType>()
        phoneCodeHash = readString()
        nextType = readIfMask(2) { readTLObject<TLAbsCodeType>() }
        timeout = readIfMask(4) { readInt() }
        termsOfService = readIfMask(8) { readTLObject<TLTermsOfService>(TLTermsOfService::class, TLTermsOfService.CONSTRUCTOR_ID) }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += type.computeSerializedSize()
        size += computeTLStringSerializedSize(phoneCodeHash)
        size += getIntIfMask(nextType, 2) { it.computeSerializedSize() }
        size += getIntIfMask(timeout, 4) { SIZE_INT32 }
        size += getIntIfMask(termsOfService, 8) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSentCode) return false
        if (other === this) return true

        return _flags == other._flags
                && phoneRegistered == other.phoneRegistered
                && type == other.type
                && phoneCodeHash == other.phoneCodeHash
                && nextType == other.nextType
                && timeout == other.timeout
                && termsOfService == other.termsOfService
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x38faab5f.toInt()
    }
}
