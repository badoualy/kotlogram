package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * document#87232bc7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLDocument() : TLAbsDocument() {
    override var id: Long = 0L

    var accessHash: Long = 0L

    var date: Int = 0

    var mimeType: String = ""

    var size: Int = 0

    var thumb: TLAbsPhotoSize = TLPhotoSizeEmpty()

    var dcId: Int = 0

    var version: Int = 0

    var attributes: TLObjectVector<TLAbsDocumentAttribute> = TLObjectVector()

    private val _constructor: String = "document#87232bc7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            id: Long,
            accessHash: Long,
            date: Int,
            mimeType: String,
            size: Int,
            thumb: TLAbsPhotoSize,
            dcId: Int,
            version: Int,
            attributes: TLObjectVector<TLAbsDocumentAttribute>
    ) : this() {
        this.id = id
        this.accessHash = accessHash
        this.date = date
        this.mimeType = mimeType
        this.size = size
        this.thumb = thumb
        this.dcId = dcId
        this.version = version
        this.attributes = attributes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeLong(id)
        writeLong(accessHash)
        writeInt(date)
        writeString(mimeType)
        writeInt(size)
        writeTLObject(thumb)
        writeInt(dcId)
        writeInt(version)
        writeTLVector(attributes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        id = readLong()
        accessHash = readLong()
        date = readInt()
        mimeType = readString()
        size = readInt()
        thumb = readTLObject<TLAbsPhotoSize>()
        dcId = readInt()
        version = readInt()
        attributes = readTLVector<TLAbsDocumentAttribute>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT64
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(mimeType)
        size += SIZE_INT32
        size += thumb.computeSerializedSize()
        size += SIZE_INT32
        size += SIZE_INT32
        size += attributes.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLDocument) return false
        if (other === this) return true

        return id == other.id
                && accessHash == other.accessHash
                && date == other.date
                && mimeType == other.mimeType
                && size == other.size
                && thumb == other.thumb
                && dcId == other.dcId
                && version == other.version
                && attributes == other.attributes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x87232bc7.toInt()
    }
}
