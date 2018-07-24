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
import kotlin.jvm.Transient

/**
 * dcOption#18b7a10d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDcOption() : TLObject() {
    @Transient
    var ipv6: Boolean = false

    @Transient
    var mediaOnly: Boolean = false

    @Transient
    var tcpoOnly: Boolean = false

    @Transient
    var cdn: Boolean = false

    @Transient
    var static: Boolean = false

    var id: Int = 0

    var ipAddress: String = ""

    var port: Int = 0

    var secret: TLBytes? = null

    private val _constructor: String = "dcOption#18b7a10d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            ipv6: Boolean,
            mediaOnly: Boolean,
            tcpoOnly: Boolean,
            cdn: Boolean,
            static: Boolean,
            id: Int,
            ipAddress: String,
            port: Int,
            secret: TLBytes?
    ) : this() {
        this.ipv6 = ipv6
        this.mediaOnly = mediaOnly
        this.tcpoOnly = tcpoOnly
        this.cdn = cdn
        this.static = static
        this.id = id
        this.ipAddress = ipAddress
        this.port = port
        this.secret = secret
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(ipv6, 1)
        updateFlags(mediaOnly, 2)
        updateFlags(tcpoOnly, 4)
        updateFlags(cdn, 8)
        updateFlags(static, 16)
        updateFlags(secret, 1024)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeString(ipAddress)
        writeInt(port)
        doIfMask(secret, 1024) { writeTLBytes(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        ipv6 = isMask(1)
        mediaOnly = isMask(2)
        tcpoOnly = isMask(4)
        cdn = isMask(8)
        static = isMask(16)
        id = readInt()
        ipAddress = readString()
        port = readInt()
        secret = readIfMask(1024) { readTLBytes() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(ipAddress)
        size += SIZE_INT32
        size += getIntIfMask(secret, 1024) { computeTLBytesSerializedSize(it) }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDcOption) return false
        if (other === this) return true

        return _flags == other._flags
                && ipv6 == other.ipv6
                && mediaOnly == other.mediaOnly
                && tcpoOnly == other.tcpoOnly
                && cdn == other.cdn
                && static == other.static
                && id == other.id
                && ipAddress == other.ipAddress
                && port == other.port
                && secret == other.secret
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x18b7a10d.toInt()
    }
}
