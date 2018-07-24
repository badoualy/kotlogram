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
 * account.passwordSettings#7bd9c3f1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPasswordSettings() : TLObject() {
    var email: String = ""

    var secureSalt: TLBytes = TLBytes.EMPTY

    var secureSecret: TLBytes = TLBytes.EMPTY

    var secureSecretId: Long = 0L

    private val _constructor: String = "account.passwordSettings#7bd9c3f1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            email: String,
            secureSalt: TLBytes,
            secureSecret: TLBytes,
            secureSecretId: Long
    ) : this() {
        this.email = email
        this.secureSalt = secureSalt
        this.secureSecret = secureSecret
        this.secureSecretId = secureSecretId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(email)
        writeTLBytes(secureSalt)
        writeTLBytes(secureSecret)
        writeLong(secureSecretId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        email = readString()
        secureSalt = readTLBytes()
        secureSecret = readTLBytes()
        secureSecretId = readLong()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(email)
        size += computeTLBytesSerializedSize(secureSalt)
        size += computeTLBytesSerializedSize(secureSecret)
        size += SIZE_INT64
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPasswordSettings) return false
        if (other === this) return true

        return email == other.email
                && secureSalt == other.secureSalt
                && secureSecret == other.secureSecret
                && secureSecretId == other.secureSecretId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7bd9c3f1.toInt()
    }
}
