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

/**
 * wallPaperSolid#63117f24
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWallPaperSolid() : TLAbsWallPaper() {
    override var id: Int = 0

    override var title: String = ""

    var bgColor: Int = 0

    override var color: Int = 0

    private val _constructor: String = "wallPaperSolid#63117f24"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Int,
            title: String,
            bgColor: Int,
            color: Int
    ) : this() {
        this.id = id
        this.title = title
        this.bgColor = bgColor
        this.color = color
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(id)
        writeString(title)
        writeInt(bgColor)
        writeInt(color)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readInt()
        title = readString()
        bgColor = readInt()
        color = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += SIZE_INT32
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWallPaperSolid) return false
        if (other === this) return true

        return id == other.id
                && title == other.title
                && bgColor == other.bgColor
                && color == other.color
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x63117f24.toInt()
    }
}
