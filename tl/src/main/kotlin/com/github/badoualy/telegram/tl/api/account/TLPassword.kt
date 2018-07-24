package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
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
 * account.password#ca39b447
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPassword() : TLAbsPassword() {
    @Transient
    var hasRecovery: Boolean = false

    @Transient
    var hasSecureValues: Boolean = false

    var currentSalt: TLBytes = TLBytes.EMPTY

    override var newSalt: TLBytes = TLBytes.EMPTY

    override var newSecureSalt: TLBytes = TLBytes.EMPTY

    override var secureRandom: TLBytes = TLBytes.EMPTY

    var hint: String = ""

    override var emailUnconfirmedPattern: String = ""

    private val _constructor: String = "account.password#ca39b447"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            hasRecovery: Boolean,
            hasSecureValues: Boolean,
            currentSalt: TLBytes,
            newSalt: TLBytes,
            newSecureSalt: TLBytes,
            secureRandom: TLBytes,
            hint: String,
            emailUnconfirmedPattern: String
    ) : this() {
        this.hasRecovery = hasRecovery
        this.hasSecureValues = hasSecureValues
        this.currentSalt = currentSalt
        this.newSalt = newSalt
        this.newSecureSalt = newSecureSalt
        this.secureRandom = secureRandom
        this.hint = hint
        this.emailUnconfirmedPattern = emailUnconfirmedPattern
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(hasRecovery, 1)
        updateFlags(hasSecureValues, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLBytes(currentSalt)
        writeTLBytes(newSalt)
        writeTLBytes(newSecureSalt)
        writeTLBytes(secureRandom)
        writeString(hint)
        writeString(emailUnconfirmedPattern)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        hasRecovery = isMask(1)
        hasSecureValues = isMask(2)
        currentSalt = readTLBytes()
        newSalt = readTLBytes()
        newSecureSalt = readTLBytes()
        secureRandom = readTLBytes()
        hint = readString()
        emailUnconfirmedPattern = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(currentSalt)
        size += computeTLBytesSerializedSize(newSalt)
        size += computeTLBytesSerializedSize(newSecureSalt)
        size += computeTLBytesSerializedSize(secureRandom)
        size += computeTLStringSerializedSize(hint)
        size += computeTLStringSerializedSize(emailUnconfirmedPattern)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPassword) return false
        if (other === this) return true

        return _flags == other._flags
                && hasRecovery == other.hasRecovery
                && hasSecureValues == other.hasSecureValues
                && currentSalt == other.currentSalt
                && newSalt == other.newSalt
                && newSecureSalt == other.newSecureSalt
                && secureRandom == other.secureRandom
                && hint == other.hint
                && emailUnconfirmedPattern == other.emailUnconfirmedPattern
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xca39b447.toInt()
    }
}
