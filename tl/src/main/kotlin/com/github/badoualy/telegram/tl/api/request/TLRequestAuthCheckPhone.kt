package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.auth.TLCheckedPhone
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAuthCheckPhone() : TLMethod<TLCheckedPhone>() {
    var phoneNumber: String = ""

    private val _constructor: String = "auth.checkPhone#6fe51dfb"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(phoneNumber: String) : this() {
        this.phoneNumber = phoneNumber
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): TLCheckedPhone = tlDeserializer.readTLObject(TLCheckedPhone::class, TLCheckedPhone.CONSTRUCTOR_ID)

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(phoneNumber)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneNumber = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(phoneNumber)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthCheckPhone) return false
        if (other === this) return true

        return phoneNumber == other.phoneNumber
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x6fe51dfb.toInt()
    }
}
