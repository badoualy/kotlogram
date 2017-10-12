package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.core.TLStringVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAuthSendInvites() : TLMethod<TLBool>() {
    var phoneNumbers: TLStringVector = TLStringVector()

    var message: String = ""

    private val _constructor: String = "auth.sendInvites#771c1d97"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(phoneNumbers: TLStringVector, message: String) : this() {
        this.phoneNumbers = phoneNumbers
        this.message = message
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(phoneNumbers)
        writeString(message)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneNumbers = readTLStringVector()
        message = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += phoneNumbers.computeSerializedSize()
        size += computeTLStringSerializedSize(message)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthSendInvites) return false
        if (other === this) return true

        return phoneNumbers == other.phoneNumbers
                && message == other.message
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x771c1d97.toInt()
    }
}
