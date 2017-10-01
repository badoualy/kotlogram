package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLBytes
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * phoneConnection#9d4c17c0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPhoneConnection() : TLObject() {
    var id: Long = 0L

    var ip: String = ""

    var ipv6: String = ""

    var port: Int = 0

    var peerTag: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "phoneConnection#9d4c17c0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            ip: String,
            ipv6: String,
            port: Int,
            peerTag: TLBytes
    ) : this() {
        this.id = id
        this.ip = ip
        this.ipv6 = ipv6
        this.port = port
        this.peerTag = peerTag
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeString(ip)
        writeString(ipv6)
        writeInt(port)
        writeTLBytes(peerTag)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        ip = readString()
        ipv6 = readString()
        port = readInt()
        peerTag = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += computeTLStringSerializedSize(ip)
        size += computeTLStringSerializedSize(ipv6)
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(peerTag)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPhoneConnection) return false
        if (other === this) return true

        return id == other.id
                && ip == other.ip
                && ipv6 == other.ipv6
                && port == other.port
                && peerTag == other.peerTag
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9d4c17c0.toInt()
    }
}
