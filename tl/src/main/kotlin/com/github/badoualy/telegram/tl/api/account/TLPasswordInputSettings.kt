package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
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
 * account.passwordInputSettings#21ffa60d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPasswordInputSettings() : TLObject() {
    var newSalt: TLBytes? = null

    var newPasswordHash: TLBytes? = null

    var hint: String? = null

    var email: String? = null

    var newSecureSalt: TLBytes? = null

    var newSecureSecret: TLBytes? = null

    var newSecureSecretId: Long? = null

    private val _constructor: String = "account.passwordInputSettings#21ffa60d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            newSalt: TLBytes?,
            newPasswordHash: TLBytes?,
            hint: String?,
            email: String?,
            newSecureSalt: TLBytes?,
            newSecureSecret: TLBytes?,
            newSecureSecretId: Long?
    ) : this() {
        this.newSalt = newSalt
        this.newPasswordHash = newPasswordHash
        this.hint = hint
        this.email = email
        this.newSecureSalt = newSecureSalt
        this.newSecureSecret = newSecureSecret
        this.newSecureSecretId = newSecureSecretId
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(newSalt, 1)
        updateFlags(newPasswordHash, 1)
        updateFlags(hint, 1)
        updateFlags(email, 2)
        updateFlags(newSecureSalt, 4)
        updateFlags(newSecureSecret, 4)
        updateFlags(newSecureSecretId, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        doIfMask(newSalt, 1) { writeTLBytes(it) }
        doIfMask(newPasswordHash, 1) { writeTLBytes(it) }
        doIfMask(hint, 1) { writeString(it) }
        doIfMask(email, 2) { writeString(it) }
        doIfMask(newSecureSalt, 4) { writeTLBytes(it) }
        doIfMask(newSecureSecret, 4) { writeTLBytes(it) }
        doIfMask(newSecureSecretId, 4) { writeLong(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        newSalt = readIfMask(1) { readTLBytes() }
        newPasswordHash = readIfMask(1) { readTLBytes() }
        hint = readIfMask(1) { readString() }
        email = readIfMask(2) { readString() }
        newSecureSalt = readIfMask(4) { readTLBytes() }
        newSecureSecret = readIfMask(4) { readTLBytes() }
        newSecureSecretId = readIfMask(4) { readLong() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += getIntIfMask(newSalt, 1) { computeTLBytesSerializedSize(it) }
        size += getIntIfMask(newPasswordHash, 1) { computeTLBytesSerializedSize(it) }
        size += getIntIfMask(hint, 1) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(email, 2) { computeTLStringSerializedSize(it) }
        size += getIntIfMask(newSecureSalt, 4) { computeTLBytesSerializedSize(it) }
        size += getIntIfMask(newSecureSecret, 4) { computeTLBytesSerializedSize(it) }
        size += getIntIfMask(newSecureSecretId, 4) { SIZE_INT64 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPasswordInputSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && newSalt == other.newSalt
                && newPasswordHash == other.newPasswordHash
                && hint == other.hint
                && email == other.email
                && newSecureSalt == other.newSecureSalt
                && newSecureSecret == other.newSecureSecret
                && newSecureSecretId == other.newSecureSecretId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x21ffa60d.toInt()
    }
}
