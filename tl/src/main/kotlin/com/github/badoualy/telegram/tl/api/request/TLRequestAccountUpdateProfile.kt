package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAccountUpdateProfile() : TLMethod<TLAbsUser>() {
    var firstName: String? = null

    var lastName: String? = null

    var about: String? = null

    private val _constructor: String = "account.updateProfile#78515775"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            firstName: String?,
            lastName: String?,
            about: String?
    ) : this() {
        this.firstName = firstName
        this.lastName = lastName
        this.about = about
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(firstName, 1)
        updateFlags(lastName, 2)
        updateFlags(about, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(firstName, 1) { writeString(it) }
        doIfMask(lastName, 2) { writeString(it) }
        doIfMask(about, 4) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        firstName = readIfMask(1) { readString() }
        lastName = readIfMask(2) { readString() }
        about = readIfMask(4) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(firstName, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(lastName, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(about, 4) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAccountUpdateProfile) return false
        if (other === this) return true

        return _flags == other._flags
                && firstName == other.firstName
                && lastName == other.lastName
                && about == other.about
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x78515775.toInt()
    }
}
