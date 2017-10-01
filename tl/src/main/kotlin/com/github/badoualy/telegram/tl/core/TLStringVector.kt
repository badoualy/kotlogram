package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLObjectUtils
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLStringVector : TLVector<String>() {

    @Throws(IOException::class)
    override fun serializeItem(item: String, tlSerializer: TLSerializer) {
        tlSerializer.writeString(item)
    }

    @Throws(IOException::class)
    override fun deserializeItem(tlDeserializer: TLDeserializer): String = tlDeserializer.readString()

    override fun computeSerializedSize() = SIZE_CONSTRUCTOR_ID + SIZE_INT32 + sumBy {
        TLObjectUtils.computeTLStringSerializedSize(it)
    }

    override fun toString() = "vector<string>#1cb5c415"
}
