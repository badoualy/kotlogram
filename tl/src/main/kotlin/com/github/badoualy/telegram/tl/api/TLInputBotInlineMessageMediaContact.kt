package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputBotInlineMessageMediaContact#2daf01a7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputBotInlineMessageMediaContact() : TLAbsInputBotInlineMessage() {
    var phoneNumber: String = ""

    var firstName: String = ""

    var lastName: String = ""

    override var replyMarkup: TLAbsReplyMarkup? = null

    private val _constructor: String = "inputBotInlineMessageMediaContact#2daf01a7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            phoneNumber: String,
            firstName: String,
            lastName: String,
            replyMarkup: TLAbsReplyMarkup?
    ) : this() {
        this.phoneNumber = phoneNumber
        this.firstName = firstName
        this.lastName = lastName
        this.replyMarkup = replyMarkup
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(replyMarkup, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(phoneNumber)
        writeString(firstName)
        writeString(lastName)
        doIfMask(replyMarkup, 4) { writeTLObject(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        phoneNumber = readString()
        firstName = readString()
        lastName = readString()
        replyMarkup = readIfMask(4) { readTLObject<TLAbsReplyMarkup>() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(phoneNumber)
        size += computeTLStringSerializedSize(firstName)
        size += computeTLStringSerializedSize(lastName)
        size += getIntIfMask(replyMarkup, 4) { it.computeSerializedSize() }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputBotInlineMessageMediaContact) return false
        if (other === this) return true

        return _flags == other._flags
                && phoneNumber == other.phoneNumber
                && firstName == other.firstName
                && lastName == other.lastName
                && replyMarkup == other.replyMarkup
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2daf01a7.toInt()
    }
}
