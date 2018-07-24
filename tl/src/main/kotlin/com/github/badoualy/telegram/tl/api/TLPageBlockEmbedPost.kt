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
 * pageBlockEmbedPost#292c7be9
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLPageBlockEmbedPost() : TLAbsPageBlock() {
    var url: String = ""

    var webpageId: Long = 0L

    var authorPhotoId: Long = 0L

    var author: String = ""

    var date: Int = 0

    var blocks: TLObjectVector<TLAbsPageBlock> = TLObjectVector()

    var caption: TLAbsRichText = TLTextEmpty()

    private val _constructor: String = "pageBlockEmbedPost#292c7be9"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(
            url: String,
            webpageId: Long,
            authorPhotoId: Long,
            author: String,
            date: Int,
            blocks: TLObjectVector<TLAbsPageBlock>,
            caption: TLAbsRichText
    ) : this() {
        this.url = url
        this.webpageId = webpageId
        this.authorPhotoId = authorPhotoId
        this.author = author
        this.date = date
        this.blocks = blocks
        this.caption = caption
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(url)
        writeLong(webpageId)
        writeLong(authorPhotoId)
        writeString(author)
        writeInt(date)
        writeTLVector(blocks)
        writeTLObject(caption)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        url = readString()
        webpageId = readLong()
        authorPhotoId = readLong()
        author = readString()
        date = readInt()
        blocks = readTLVector<TLAbsPageBlock>()
        caption = readTLObject<TLAbsRichText>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(url)
        size += SIZE_INT64
        size += SIZE_INT64
        size += computeTLStringSerializedSize(author)
        size += SIZE_INT32
        size += blocks.computeSerializedSize()
        size += caption.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLPageBlockEmbedPost) return false
        if (other === this) return true

        return url == other.url
                && webpageId == other.webpageId
                && authorPhotoId == other.authorPhotoId
                && author == other.author
                && date == other.date
                && blocks == other.blocks
                && caption == other.caption
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x292c7be9.toInt()
    }
}
