package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
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
 * keyboardButtonSwitchInline#568a748
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLKeyboardButtonSwitchInline() : TLAbsKeyboardButton() {
    @Transient
    var samePeer: Boolean = false

    override var text: String = ""

    var query: String = ""

    private val _constructor: String = "keyboardButtonSwitchInline#568a748"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            samePeer: Boolean,
            text: String,
            query: String
    ) : this() {
        this.samePeer = samePeer
        this.text = text
        this.query = query
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(samePeer, 1)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeString(text)
        writeString(query)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        samePeer = isMask(1)
        text = readString()
        query = readString()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(text)
        size += computeTLStringSerializedSize(query)
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLKeyboardButtonSwitchInline) return false
        if (other === this) return true

        return _flags == other._flags
                && samePeer == other.samePeer
                && text == other.text
                && query == other.query
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x568a748.toInt()
    }
}
