package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * webDocument#c61acbd8
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWebDocument() : TLObject() {
    var url: String = ""

    var accessHash: Long = 0L

    var size: Int = 0

    var mimeType: String = ""

    var attributes: TLObjectVector<TLAbsDocumentAttribute> = TLObjectVector()

    var dcId: Int = 0

    private val _constructor: String = "webDocument#c61acbd8"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            url: String,
            accessHash: Long,
            size: Int,
            mimeType: String,
            attributes: TLObjectVector<TLAbsDocumentAttribute>,
            dcId: Int
    ) : this() {
        this.url = url
        this.accessHash = accessHash
        this.size = size
        this.mimeType = mimeType
        this.attributes = attributes
        this.dcId = dcId
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(url)
        writeLong(accessHash)
        writeInt(size)
        writeString(mimeType)
        writeTLVector(attributes)
        writeInt(dcId)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        url = readString()
        accessHash = readLong()
        size = readInt()
        mimeType = readString()
        attributes = readTLVector<TLAbsDocumentAttribute>()
        dcId = readInt()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(url)
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(mimeType)
        size += attributes.computeSerializedSize()
        size += SIZE_INT32
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLWebDocument) return false
        if (other === this) return true

        return url == other.url
                && accessHash == other.accessHash
                && size == other.size
                && mimeType == other.mimeType
                && attributes == other.attributes
                && dcId == other.dcId
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xc61acbd8.toInt()
    }
}
