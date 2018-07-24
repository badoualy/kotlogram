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

/**
 * account.noPassword#5ea182f6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLNoPassword() : TLAbsPassword() {
    override var newSalt: TLBytes = TLBytes.EMPTY

    override var newSecureSalt: TLBytes = TLBytes.EMPTY

    override var secureRandom: TLBytes = TLBytes.EMPTY

    override var emailUnconfirmedPattern: String = ""

    private val _constructor: String = "account.noPassword#5ea182f6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            newSalt: TLBytes,
            newSecureSalt: TLBytes,
            secureRandom: TLBytes,
            emailUnconfirmedPattern: String
    ) : this() {
        this.newSalt = newSalt
        this.newSecureSalt = newSecureSalt
        this.secureRandom = secureRandom
        this.emailUnconfirmedPattern = emailUnconfirmedPattern
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLBytes(newSalt)
        writeTLBytes(newSecureSalt)
        writeTLBytes(secureRandom)
        writeString(emailUnconfirmedPattern)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        newSalt = readTLBytes()
        newSecureSalt = readTLBytes()
        secureRandom = readTLBytes()
        emailUnconfirmedPattern = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLBytesSerializedSize(newSalt)
        size += computeTLBytesSerializedSize(newSecureSalt)
        size += computeTLBytesSerializedSize(secureRandom)
        size += computeTLStringSerializedSize(emailUnconfirmedPattern)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLNoPassword) return false
        if (other === this) return true

        return newSalt == other.newSalt
                && newSecureSalt == other.newSecureSalt
                && secureRandom == other.secureRandom
                && emailUnconfirmedPattern == other.emailUnconfirmedPattern
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5ea182f6.toInt()
    }
}
