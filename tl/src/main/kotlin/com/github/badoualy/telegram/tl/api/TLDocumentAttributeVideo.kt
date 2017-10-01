package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * documentAttributeVideo#ef02ce6
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDocumentAttributeVideo() : TLAbsDocumentAttribute() {
    @Transient
    var roundMessage: Boolean = false

    var duration: Int = 0

    var w: Int = 0

    var h: Int = 0

    private val _constructor: String = "documentAttributeVideo#ef02ce6"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            roundMessage: Boolean,
            duration: Int,
            w: Int,
            h: Int
    ) : this() {
        this.roundMessage = roundMessage
        this.duration = duration
        this.w = w
        this.h = h
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(roundMessage, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeInt(duration)
        writeInt(w)
        writeInt(h)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        roundMessage = isMask(1)
        duration = readInt()
        w = readInt()
        h = readInt()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDocumentAttributeVideo) return false
        if (other === this) return true

        return _flags == other._flags
                && roundMessage == other.roundMessage
                && duration == other.duration
                && w == other.w
                && h == other.h
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xef02ce6.toInt()
    }
}
