package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * dcOption#5d8c6cc
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

    private val _constructor: String = "dcOption#5d8c6cc"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            ipv6: Boolean,
            mediaOnly: Boolean,
            tcpoOnly: Boolean,
            cdn: Boolean,
            static: Boolean,
            id: Int,
            ipAddress: String,
            port: Int
    ) : this() {
        this.ipv6 = ipv6
        this.mediaOnly = mediaOnly
        this.tcpoOnly = tcpoOnly
        this.cdn = cdn
        this.static = static
        this.id = id
        this.ipAddress = ipAddress
        this.port = port
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(ipv6, 1)
        updateFlags(mediaOnly, 2)
        updateFlags(tcpoOnly, 4)
        updateFlags(cdn, 8)
        updateFlags(static, 16)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(id)
        writeString(ipAddress)
        writeInt(port)
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
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += computeTLStringSerializedSize(ipAddress)
        size += SIZE_INT32
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
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x5d8c6cc.toInt()
    }
}
