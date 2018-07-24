package com.github.badoualy.telegram.tl.api.request

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsInputStickeredMedia
import com.github.badoualy.telegram.tl.api.TLAbsStickerSetCovered
import com.github.badoualy.telegram.tl.api.TLInputStickeredMediaDocument
import com.github.badoualy.telegram.tl.core.TLMethod
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
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLRequestMessagesGetAttachedStickers() : TLMethod<TLObjectVector<TLAbsStickerSetCovered>>() {
    var media: TLAbsInputStickeredMedia = TLInputStickeredMediaDocument()

    private val _constructor: String = "messages.getAttachedStickers#cc5b67cc"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(media: TLAbsInputStickeredMedia) : this() {
        this.media = media
    }

    @Throws(IOException::class)
    override fun deserializeResponse_(tlDeserializer: TLDeserializer): TLObjectVector<TLAbsStickerSetCovered> = tlDeserializer.readTLVector<TLAbsStickerSetCovered>()

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(media)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        media = readTLObject<TLAbsInputStickeredMedia>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += media.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLRequestMessagesGetAttachedStickers) return false
        if (other === this) return true

        return media == other.media
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xcc5b67cc.toInt()
    }
}
