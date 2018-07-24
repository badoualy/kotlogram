package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.jvm.Throws

/**
 * webDocument#1c570ed1
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLWebDocument() : TLAbsWebDocument() {
    override var url: String = ""

    var accessHash: Long = 0L

    override var size: Int = 0

    override var mimeType: String = ""

    override var attributes: TLObjectVector<TLAbsDocumentAttribute> = TLObjectVector()

    private val _constructor: String = "webDocument#1c570ed1"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            url: String,
            accessHash: Long,
            size: Int,
            mimeType: String,
            attributes: TLObjectVector<TLAbsDocumentAttribute>
    ) : this() {
        this.url = url
        this.accessHash = accessHash
        this.size = size
        this.mimeType = mimeType
        this.attributes = attributes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(url)
        writeLong(accessHash)
        writeInt(size)
        writeString(mimeType)
        writeTLVector(attributes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        url = readString()
        accessHash = readLong()
        size = readInt()
        mimeType = readString()
        attributes = readTLVector<TLAbsDocumentAttribute>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(url)
        size += SIZE_INT64
        size += SIZE_INT32
        size += computeTLStringSerializedSize(mimeType)
        size += attributes.computeSerializedSize()
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
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x1c570ed1.toInt()
    }
}
