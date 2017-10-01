package com.github.badoualy.telegram.tl.api.messages

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize
import com.github.badoualy.telegram.tl.api.TLAbsDocument
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messages.stickers#8a8ecd32
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStickers() : TLAbsStickers() {
    var hash: String = ""

    var stickers: TLObjectVector<TLAbsDocument> = TLObjectVector()

    private val _constructor: String = "messages.stickers#8a8ecd32"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(hash: String, stickers: TLObjectVector<TLAbsDocument>) : this() {
        this.hash = hash
        this.stickers = stickers
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeString(hash)
        writeTLVector(stickers)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        hash = readString()
        stickers = readTLVector<TLAbsDocument>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += computeTLStringSerializedSize(hash)
        size += stickers.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLStickers) return false
        if (other === this) return true

        return hash == other.hash
                && stickers == other.stickers
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x8a8ecd32.toInt()
    }
}
