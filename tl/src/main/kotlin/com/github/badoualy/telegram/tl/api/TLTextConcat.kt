package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.core.TLObjectVector
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * textConcat#7e6260d7
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLTextConcat() : TLAbsRichText() {
    var texts: TLObjectVector<TLAbsRichText> = TLObjectVector()

    private val _constructor: String = "textConcat#7e6260d7"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(texts: TLObjectVector<TLAbsRichText>) : this() {
        this.texts = texts
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLVector(texts)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        texts = readTLVector<TLAbsRichText>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += texts.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLTextConcat) return false
        if (other === this) return true

        return texts == other.texts
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0x7e6260d7.toInt()
    }
}
