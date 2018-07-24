package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBool
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestAuthBindTempAuthKey() : TLMethod<TLBool>() {
    var permAuthKeyId: Long = 0L

    var nonce: Long = 0L

    var expiresAt: Int = 0

    var encryptedMessage: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "auth.bindTempAuthKey#cdd42a05"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            permAuthKeyId: Long,
            nonce: Long,
            expiresAt: Int,
            encryptedMessage: TLBytes
    ) : this() {
        this.permAuthKeyId = permAuthKeyId
        this.nonce = nonce
        this.expiresAt = expiresAt
        this.encryptedMessage = encryptedMessage
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(permAuthKeyId)
        writeLong(nonce)
        writeInt(expiresAt)
        writeTLBytes(encryptedMessage)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        permAuthKeyId = readLong()
        nonce = readLong()
        expiresAt = readInt()
        encryptedMessage = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(encryptedMessage)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestAuthBindTempAuthKey) return false
        if (other === this) return true

        return permAuthKeyId == other.permAuthKeyId
                && nonce == other.nonce
                && expiresAt == other.expiresAt
                && encryptedMessage == other.encryptedMessage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcdd42a05.toInt()
    }
}
