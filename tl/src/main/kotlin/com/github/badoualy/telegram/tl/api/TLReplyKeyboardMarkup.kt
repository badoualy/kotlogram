package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * replyKeyboardMarkup#3502758c
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLReplyKeyboardMarkup() : TLAbsReplyMarkup() {
    @Transient
    var resize: Boolean = false

    @Transient
    var singleUse: Boolean = false

    @Transient
    var selective: Boolean = false

    var rows: TLObjectVector<TLKeyboardButtonRow> = TLObjectVector()

    private val _constructor: String = "replyKeyboardMarkup#3502758c"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            resize: Boolean,
            singleUse: Boolean,
            selective: Boolean,
            rows: TLObjectVector<TLKeyboardButtonRow>
    ) : this() {
        this.resize = resize
        this.singleUse = singleUse
        this.selective = selective
        this.rows = rows
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(resize, 1)
        updateFlags(singleUse, 2)
        updateFlags(selective, 4)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLVector(rows)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        resize = isMask(1)
        singleUse = isMask(2)
        selective = isMask(4)
        rows = readTLVector<TLKeyboardButtonRow>()
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += rows.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLReplyKeyboardMarkup) return false
        if (other === this) return true

        return _flags == other._flags
                && resize == other.resize
                && singleUse == other.singleUse
                && selective == other.selective
                && rows == other.rows
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x3502758c.toInt()
    }
}
