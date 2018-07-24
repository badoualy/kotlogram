package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputPhoneContact#f392b7f4
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputPhoneContact() : TLObject() {
    var clientId: Long = 0L

    var phone: String = ""

    var firstName: String = ""

    var lastName: String = ""

    private val _constructor: String = "inputPhoneContact#f392b7f4"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            clientId: Long,
            phone: String,
            firstName: String,
            lastName: String
    ) : this() {
        this.clientId = clientId
        this.phone = phone
        this.firstName = firstName
        this.lastName = lastName
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(clientId)
        writeString(phone)
        writeString(firstName)
        writeString(lastName)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        clientId = readLong()
        phone = readString()
        firstName = readString()
        lastName = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += computeTLStringSerializedSize(phone)
        size += computeTLStringSerializedSize(firstName)
        size += computeTLStringSerializedSize(lastName)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputPhoneContact) return false
        if (other === this) return true

        return clientId == other.clientId
                && phone == other.phone
                && firstName == other.firstName
                && lastName == other.lastName
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf392b7f4.toInt()
    }
}
