package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsSecureValueError
import com.github.badoualy.telegram.tl.api.TLAbsSecureValueType
import com.github.badoualy.telegram.tl.api.TLAbsUser
import com.github.badoualy.telegram.tl.api.TLSecureValue
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws
import kotlin.jvm.Transient

/**
 * account.authorizationForm#cb976d53
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLAuthorizationForm() : TLObject() {
    @Transient
    var selfieRequired: Boolean = false

    var requiredTypes: TLObjectVector<TLAbsSecureValueType> = TLObjectVector()

    var values: TLObjectVector<TLSecureValue> = TLObjectVector()

    var errors: TLObjectVector<TLAbsSecureValueError> = TLObjectVector()

    var users: TLObjectVector<TLAbsUser> = TLObjectVector()

    var privacyPolicyUrl: String? = null

    private val _constructor: String = "account.authorizationForm#cb976d53"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            selfieRequired: Boolean,
            requiredTypes: TLObjectVector<TLAbsSecureValueType>,
            values: TLObjectVector<TLSecureValue>,
            errors: TLObjectVector<TLAbsSecureValueError>,
            users: TLObjectVector<TLAbsUser>,
            privacyPolicyUrl: String?
    ) : this() {
        this.selfieRequired = selfieRequired
        this.requiredTypes = requiredTypes
        this.values = values
        this.errors = errors
        this.users = users
        this.privacyPolicyUrl = privacyPolicyUrl
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(selfieRequired, 2)
        updateFlags(privacyPolicyUrl, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(requiredTypes)
        writeTLVector(values)
        writeTLVector(errors)
        writeTLVector(users)
        doIfMask(privacyPolicyUrl, 1) { writeString(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        selfieRequired = isMask(2)
        requiredTypes = readTLVector<TLAbsSecureValueType>()
        values = readTLVector<TLSecureValue>()
        errors = readTLVector<TLAbsSecureValueError>()
        users = readTLVector<TLAbsUser>()
        privacyPolicyUrl = readIfMask(1) { readString() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += requiredTypes.computeSerializedSize()
        size += values.computeSerializedSize()
        size += errors.computeSerializedSize()
        size += users.computeSerializedSize()
        size += getIntIfMask(privacyPolicyUrl, 1) { computeTLStringSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLAuthorizationForm) return false
        if (other === this) return true

        return _flags == other._flags
                && selfieRequired == other.selfieRequired
                && requiredTypes == other.requiredTypes
                && values == other.values
                && errors == other.errors
                && users == other.users
                && privacyPolicyUrl == other.privacyPolicyUrl
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcb976d53.toInt()
    }
}
