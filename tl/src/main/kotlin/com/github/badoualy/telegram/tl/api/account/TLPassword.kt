package com.github.badoualy.telegram.tl.api.account

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * account.password#7c18141c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPassword() : TLAbsPassword() {
    var currentSalt: TLBytes = TLBytes.EMPTY

    override var newSalt: TLBytes = TLBytes.EMPTY

    var hint: String = ""

    var hasRecovery: Boolean = false

    override var emailUnconfirmedPattern: String = ""

    private val _constructor: String = "account.password#7c18141c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            currentSalt: TLBytes,
            newSalt: TLBytes,
            hint: String,
            hasRecovery: Boolean,
            emailUnconfirmedPattern: String
    ) : this() {
        this.currentSalt = currentSalt
        this.newSalt = newSalt
        this.hint = hint
        this.hasRecovery = hasRecovery
        this.emailUnconfirmedPattern = emailUnconfirmedPattern
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLBytes(currentSalt)
        writeTLBytes(newSalt)
        writeString(hint)
        writeBoolean(hasRecovery)
        writeString(emailUnconfirmedPattern)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        currentSalt = readTLBytes()
        newSalt = readTLBytes()
        hint = readString()
        hasRecovery = readBoolean()
        emailUnconfirmedPattern = readString()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLBytesSerializedSize(currentSalt)
        size += computeTLBytesSerializedSize(newSalt)
        size += computeTLStringSerializedSize(hint)
        size += SIZE_BOOLEAN
        size += computeTLStringSerializedSize(emailUnconfirmedPattern)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPassword) return false
        if (other === this) return true

        return currentSalt == other.currentSalt
                && newSalt == other.newSalt
                && hint == other.hint
                && hasRecovery == other.hasRecovery
                && emailUnconfirmedPattern == other.emailUnconfirmedPattern
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7c18141c.toInt()
    }
}
