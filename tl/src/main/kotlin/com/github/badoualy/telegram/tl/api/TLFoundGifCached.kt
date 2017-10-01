package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * foundGifCached#9c750409
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLFoundGifCached() : TLAbsFoundGif() {
    override var url: String = ""

    var photo: TLAbsPhoto = TLPhotoEmpty()

    var document: TLAbsDocument = TLDocumentEmpty()

    private val _constructor: String = "foundGifCached#9c750409"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            url: String,
            photo: TLAbsPhoto,
            document: TLAbsDocument
    ) : this() {
        this.url = url
        this.photo = photo
        this.document = document
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(url)
        writeTLObject(photo)
        writeTLObject(document)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        url = readString()
        photo = readTLObject<TLAbsPhoto>()
        document = readTLObject<TLAbsDocument>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(url)
        size += photo.computeSerializedSize()
        size += document.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLFoundGifCached) return false
        if (other === this) return true

        return url == other.url
                && photo == other.photo
                && document == other.document
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x9c750409.toInt()
    }
}
