package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * inputMediaUploadedDocument#e39621fd
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLInputMediaUploadedDocument() : TLAbsInputMedia() {
    var file: TLAbsInputFile = TLInputFileBig()

    var thumb: TLAbsInputFile? = null

    var mimeType: String = ""

    var attributes: TLObjectVector<TLAbsDocumentAttribute> = TLObjectVector()

    var caption: String = ""

    var stickers: TLObjectVector<TLAbsInputDocument>? = TLObjectVector()

    var ttlSeconds: Int? = null

    private val _constructor: String = "inputMediaUploadedDocument#e39621fd"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            file: TLAbsInputFile,
            thumb: TLAbsInputFile?,
            mimeType: String,
            attributes: TLObjectVector<TLAbsDocumentAttribute>,
            caption: String,
            stickers: TLObjectVector<TLAbsInputDocument>?,
            ttlSeconds: Int?
    ) : this() {
        this.file = file
        this.thumb = thumb
        this.mimeType = mimeType
        this.attributes = attributes
        this.caption = caption
        this.stickers = stickers
        this.ttlSeconds = ttlSeconds
    }

    protected override fun computeFlags() {
        _flags = 0
        updateFlags(thumb, 4)
        updateFlags(stickers, 1)
        updateFlags(ttlSeconds, 2)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        computeFlags()

        writeInt(_flags)
        writeTLObject(file)
        doIfMask(thumb, 4) { writeTLObject(it) }
        writeString(mimeType)
        writeTLVector(attributes)
        writeString(caption)
        doIfMask(stickers, 1) { writeTLVector(it) }
        doIfMask(ttlSeconds, 2) { writeInt(it) }
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        _flags = readInt()
        file = readTLObject<TLAbsInputFile>()
        thumb = readIfMask(4) { readTLObject<TLAbsInputFile>() }
        mimeType = readString()
        attributes = readTLVector<TLAbsDocumentAttribute>()
        caption = readString()
        stickers = readIfMask(1) { readTLVector<TLAbsInputDocument>() }
        ttlSeconds = readIfMask(2) { readInt() }
    }

    override fun computeSerializedSize(): Int {
        computeFlags()

        var size = SIZE_CONSTRUCTOR_ID
        size += SIZE_INT32
        size += file.computeSerializedSize()
        size += getIntIfMask(thumb, 4) { it.computeSerializedSize() }
        size += computeTLStringSerializedSize(mimeType)
        size += attributes.computeSerializedSize()
        size += computeTLStringSerializedSize(caption)
        size += getIntIfMask(stickers, 1) { it.computeSerializedSize() }
        size += getIntIfMask(ttlSeconds, 2) { SIZE_INT32 }
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLInputMediaUploadedDocument) return false
        if (other === this) return true

        return _flags == other._flags
                && file == other.file
                && thumb == other.thumb
                && mimeType == other.mimeType
                && attributes == other.attributes
                && caption == other.caption
                && stickers == other.stickers
                && ttlSeconds == other.ttlSeconds
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xe39621fd.toInt()
    }
}
