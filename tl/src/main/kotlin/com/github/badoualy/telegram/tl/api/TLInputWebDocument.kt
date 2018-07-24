package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import kotlin.Any
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.jvm.Throws

/**
 * inputWebDocument#9bed434d
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputWebDocument() : TLObject() {
    var url: String = ""

    var size: Int = 0

    var mimeType: String = ""

    var attributes: TLObjectVector<TLAbsDocumentAttribute> = TLObjectVector()

    private val _constructor: String = "inputWebDocument#9bed434d"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            url: String,
            size: Int,
            mimeType: String,
            attributes: TLObjectVector<TLAbsDocumentAttribute>
    ) : this() {
        this.url = url
        this.size = size
        this.mimeType = mimeType
        this.attributes = attributes
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(url)
        writeInt(size)
        writeString(mimeType)
        writeTLVector(attributes)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        url = readString()
        size = readInt()
        mimeType = readString()
        attributes = readTLVector<TLAbsDocumentAttribute>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(url)
        size += SIZE_INT32
        size += computeTLStringSerializedSize(mimeType)
        size += attributes.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputWebDocument) return false
        if (other === this) return true

        return url == other.url
                && size == other.size
                && mimeType == other.mimeType
                && attributes == other.attributes
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9bed434d.toInt()
    }
}
