package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.auth.TLSentCode
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAuthSendCode() : TLMethod<TLSentCode>() {
    @Transient
    var allowFlashcall: Boolean = false

    var phoneNumber: String = ""

    var currentNumber: Boolean? = null

    var apiId: Int = 0

    var apiHash: String = ""

    private val _constructor: String = "auth.sendCode#86aef0ec"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?,
            apiId: Int,
            apiHash: String
    ) : this() {
        this.allowFlashcall = allowFlashcall
        this.phoneNumber = phoneNumber
        this.currentNumber = currentNumber
        this.apiId = apiId
        this.apiHash = apiHash
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLSentCode = tlDeserializer.readTLObject(TLSentCode::class, TLSentCode.CONSTRUCTOR_ID)

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(allowFlashcall, 1)
        // If field is not serialized force it to false
        if (currentNumber != null && !isMask(1)) currentNumber = null
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(phoneNumber)
        doIfMask(currentNumber, 1) { writeBoolean(it) }
        writeInt(apiId)
        writeString(apiHash)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        allowFlashcall = isMask(1)
        phoneNumber = readString()
        currentNumber = readIfMask(1) { readBoolean() }
        apiId = readInt()
        apiHash = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(phoneNumber)
        size += getIntIfMask(currentNumber, 1) { SIZE_BOOLEAN }
        size += SIZE_INT32
        size += computeTLStringSerializedSize(apiHash)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthSendCode) return false
        if (other === this) return true

        return _flags == other._flags
                && allowFlashcall == other.allowFlashcall
                && phoneNumber == other.phoneNumber
                && currentNumber == other.currentNumber
                && apiId == other.apiId
                && apiHash == other.apiHash
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x86aef0ec.toInt()
    }
}
