package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputMediaContact#a6e45987
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaContact() : TLAbsInputMedia() {
    var phoneNumber: String = ""

    var firstName: String = ""

    var lastName: String = ""

    private val _constructor: String = "inputMediaContact#a6e45987"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            phoneNumber: String,
            firstName: String,
            lastName: String
    ) : this() {
        this.phoneNumber = phoneNumber
        this.firstName = firstName
        this.lastName = lastName
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(phoneNumber)
        writeString(firstName)
        writeString(lastName)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneNumber = readString()
        firstName = readString()
        lastName = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(phoneNumber)
        size += computeTLStringSerializedSize(firstName)
        size += computeTLStringSerializedSize(lastName)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaContact) return false
        if (other === this) return true

        return phoneNumber == other.phoneNumber
                && firstName == other.firstName
                && lastName == other.lastName
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa6e45987.toInt()
    }
}
