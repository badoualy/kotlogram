package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * peerSettings#818426cd
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPeerSettings() : TLObject() {
    @Transient
    var reportSpam: Boolean = false

    private val _constructor: String = "peerSettings#818426cd"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(reportSpam: Boolean) : this() {
        this.reportSpam = reportSpam
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(reportSpam, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        reportSpam = isMask(1)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPeerSettings) return false
        if (other === this) return true

        return _flags == other._flags
                && reportSpam == other.reportSpam
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x818426cd.toInt()
    }
}
