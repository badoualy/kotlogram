package com.github.badoualy.telegram.tl.api.messages

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
 * messages.dhConfig#2c221edd
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDhConfig() : TLAbsDhConfig() {
    var g: Int = 0

    var p: TLBytes = TLBytes.EMPTY

    var version: Int = 0

    override var random: TLBytes = TLBytes.EMPTY

    private val _constructor: String = "messages.dhConfig#2c221edd"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            g: Int,
            p: TLBytes,
            version: Int,
            random: TLBytes
    ) : this() {
        this.g = g
        this.p = p
        this.version = version
        this.random = random
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(g)
        writeTLBytes(p)
        writeInt(version)
        writeTLBytes(random)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        g = readInt()
        p = readTLBytes()
        version = readInt()
        random = readTLBytes()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(p)
        size += SIZE_INT32
        size += computeTLBytesSerializedSize(random)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDhConfig) return false
        if (other === this) return true

        return g == other.g
                && p == other.p
                && version == other.version
                && random == other.random
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x2c221edd.toInt()
    }
}
