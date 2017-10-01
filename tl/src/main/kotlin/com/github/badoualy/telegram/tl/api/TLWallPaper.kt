package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * wallPaper#ccb03657
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWallPaper() : TLAbsWallPaper() {
    override var id: Int = 0

    override var title: String = ""

    var sizes: TLObjectVector<TLAbsPhotoSize> = TLObjectVector()

    override var color: Int = 0

    private val _constructor: String = "wallPaper#ccb03657"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Int,
            title: String,
            sizes: TLObjectVector<TLAbsPhotoSize>,
            color: Int
    ) : this() {
        this.id = id
        this.title = title
        this.sizes = sizes
        this.color = color
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeInt(id)
        writeString(title)
        writeTLVector(sizes)
        writeInt(color)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readInt()
        title = readString()
        sizes = readTLVector<TLAbsPhotoSize>()
        color = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += computeTLStringSerializedSize(title)
        size += sizes.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWallPaper) return false
        if (other === this) return true

        return id == other.id
                && title == other.title
                && sizes == other.sizes
                && color == other.color
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xccb03657.toInt()
    }
}
