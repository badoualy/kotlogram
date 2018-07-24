package com.github.badoualy.telegram.tl.api

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
import kotlin.String
import kotlin.jvm.Throws

/**
 * secureCredentialsEncrypted#33f0ea47
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLSecureCredentialsEncrypted() : TLObject() {
    var data: TLBytes = TLBytes.EMPTY

    var hash: TLBytes = TLBytes.EMPTY

    var secret: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "secureCredentialsEncrypted#33f0ea47"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            data: TLBytes,
            hash: TLBytes,
            secret: TLBytes
    ) : this() {
        this.data = data
        this.hash = hash
        this.secret = secret
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLBytes(data)
        writeTLBytes(hash)
        writeTLBytes(secret)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        data = readTLBytes()
        hash = readTLBytes()
        secret = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLBytesSerializedSize(data)
        size += computeTLBytesSerializedSize(hash)
        size += computeTLBytesSerializedSize(secret)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLSecureCredentialsEncrypted) return false
        if (other === this) return true

        return data == other.data
                && hash == other.hash
                && secret == other.secret
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x33f0ea47.toInt()
    }
}
