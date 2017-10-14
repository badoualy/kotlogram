package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * auth.sentCode#5e002502
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

    private val _constructor: String = "auth.sentCode#5e002502"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            phoneRegistered: Boolean,
            type: TLAbsSentCodeType,
            phoneCodeHash: String,
            nextType: TLAbsCodeType?,
            timeout: Int?
    ) : this() {
        this.phoneRegistered = phoneRegistered
        this.type = type
        this.phoneCodeHash = phoneCodeHash
        this.nextType = nextType
        this.timeout = timeout
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(phoneRegistered, 1)
        updateFlags(nextType, 2)
        updateFlags(timeout, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(type)
        writeString(phoneCodeHash)
        doIfMask(nextType, 2) { writeTLObject(it) }
        doIfMask(timeout, 4) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        phoneRegistered = isMask(1)
        type = readTLObject<TLAbsSentCodeType>()
        phoneCodeHash = readString()
        nextType = readIfMask(2) { readTLObject<TLAbsCodeType>() }
        timeout = readIfMask(4) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += type.computeSerializedSize()
        size += computeTLStringSerializedSize(phoneCodeHash)
        size += getIntIfMask(nextType, 2) { it.computeSerializedSize() }
        size += getIntIfMask(timeout, 4) { SIZE_INT32 }
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
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5e002502.toInt()
    }
}
