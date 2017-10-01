package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * replyKeyboardForceReply#f4108aa0
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLReplyKeyboardForceReply() : TLAbsReplyMarkup() {
    @Transient
    var singleUse: Boolean = false

    @Transient
    var selective: Boolean = false

    private val _constructor: String = "replyKeyboardForceReply#f4108aa0"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(singleUse: Boolean, selective: Boolean) : this() {
        this.singleUse = singleUse
        this.selective = selective
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(singleUse, 2)
        updateFlags(selective, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        singleUse = isMask(2)
        selective = isMask(4)
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLReplyKeyboardForceReply) return false
        if (other === this) return true

        return _flags == other._flags
                && singleUse == other.singleUse
                && selective == other.selective
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xf4108aa0.toInt()
    }
}
