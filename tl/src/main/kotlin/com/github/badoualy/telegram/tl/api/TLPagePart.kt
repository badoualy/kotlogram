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
import kotlin.String
import kotlin.jvm.Throws

/**
 * pagePart#8e3f9ebe
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPagePart() : TLAbsPage() {
    override var blocks: TLObjectVector<TLAbsPageBlock> = TLObjectVector()

    override var photos: TLObjectVector<TLAbsPhoto> = TLObjectVector()

    override var documents: TLObjectVector<TLAbsDocument> = TLObjectVector()

    private val _constructor: String = "pagePart#8e3f9ebe"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            blocks: TLObjectVector<TLAbsPageBlock>,
            photos: TLObjectVector<TLAbsPhoto>,
            documents: TLObjectVector<TLAbsDocument>
    ) : this() {
        this.blocks = blocks
        this.photos = photos
        this.documents = documents
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(blocks)
        writeTLVector(photos)
        writeTLVector(documents)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        blocks = readTLVector<TLAbsPageBlock>()
        photos = readTLVector<TLAbsPhoto>()
        documents = readTLVector<TLAbsDocument>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += blocks.computeSerializedSize()
        size += photos.computeSerializedSize()
        size += documents.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPagePart) return false
        if (other === this) return true

        return blocks == other.blocks
                && photos == other.photos
                && documents == other.documents
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8e3f9ebe.toInt()
    }
}
