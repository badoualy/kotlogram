package com.github.badoualy.telegram.tl.api

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * messageMediaWebPage#a32dd600
 *
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLMessageMediaWebPage() : TLAbsMessageMedia() {
    var webpage: TLAbsWebPage = TLWebPageEmpty()

    private val _constructor: String = "messageMediaWebPage#a32dd600"

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(webpage: TLAbsWebPage) : this() {
        this.webpage = webpage
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with (tlSerializer)  {
        writeTLObject(webpage)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer)  {
        webpage = readTLObject<TLAbsWebPage>()
    }

    override fun computeSerializedSize(): Int {
        var size = SIZE_CONSTRUCTOR_ID
        size += webpage.computeSerializedSize()
        return size
    }

    override fun toString() = _constructor

    override fun equals(other: Any?): Boolean {
        if (other !is TLMessageMediaWebPage) return false
        if (other === this) return true

        return webpage == other.webpage
    }
    companion object  {
        const val CONSTRUCTOR_ID: Int = 0xa32dd600.toInt()
    }
}
