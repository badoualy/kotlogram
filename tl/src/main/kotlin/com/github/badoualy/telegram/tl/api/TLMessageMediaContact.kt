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
 * messageMediaContact#cbf24940
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaContact() : TLAbsMessageMedia() {
    var phoneNumber: String = ""

    var firstName: String = ""

    var lastName: String = ""

    var vcard: String = ""

    var userId: Int = 0

    private val _constructor: String = "messageMediaContact#cbf24940"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            phoneNumber: String,
            firstName: String,
            lastName: String,
            vcard: String,
            userId: Int
    ) : this() {
        this.phoneNumber = phoneNumber
        this.firstName = firstName
        this.lastName = lastName
        this.vcard = vcard
        this.userId = userId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(phoneNumber)
        writeString(firstName)
        writeString(lastName)
        writeString(vcard)
        writeInt(userId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneNumber = readString()
        firstName = readString()
        lastName = readString()
        vcard = readString()
        userId = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(phoneNumber)
        size += computeTLStringSerializedSize(firstName)
        size += computeTLStringSerializedSize(lastName)
        size += computeTLStringSerializedSize(vcard)
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaContact) return false
        if (other === this) return true

        return phoneNumber == other.phoneNumber
                && firstName == other.firstName
                && lastName == other.lastName
                && vcard == other.vcard
                && userId == other.userId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcbf24940.toInt()
    }
}
