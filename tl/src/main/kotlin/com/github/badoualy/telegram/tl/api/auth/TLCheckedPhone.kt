package com.github.badoualy.telegram.tl.api.auth

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * auth.checkedPhone#811ea28e
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLCheckedPhone() : TLObject() {
    var phoneRegistered: Boolean = false

    private val _constructor: String = "auth.checkedPhone#811ea28e"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(phoneRegistered: Boolean) : this() {
        this.phoneRegistered = phoneRegistered
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeBoolean(phoneRegistered)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        phoneRegistered = readBoolean()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_BOOLEAN
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLCheckedPhone) return false
        if (other === this) return true

        return phoneRegistered == other.phoneRegistered
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x811ea28e.toInt()
    }
}
