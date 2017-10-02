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
class TLRequestAccountSendChangePhoneCode() : TLMethod<TLSentCode>() {
    @Transient
    var allowFlashcall: Boolean = false

    var phoneNumber: String = ""

    var currentNumber: Boolean? = null

    private val _constructor: String = "account.sendChangePhoneCode#8e57deb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            allowFlashcall: Boolean,
            phoneNumber: String,
            currentNumber: Boolean?
    ) : this() {
        this.allowFlashcall = allowFlashcall
        this.phoneNumber = phoneNumber
        this.currentNumber = currentNumber
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
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        allowFlashcall = isMask(1)
        phoneNumber = readString()
        currentNumber = readIfMask(1) { readBoolean() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(phoneNumber)
        size += getIntIfMask(currentNumber, 1) { SIZE_BOOLEAN }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountSendChangePhoneCode) return false
        if (other === this) return true

        return _flags == other._flags
                && allowFlashcall == other.allowFlashcall
                && phoneNumber == other.phoneNumber
                && currentNumber == other.currentNumber
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8e57deb.toInt()
    }
}
