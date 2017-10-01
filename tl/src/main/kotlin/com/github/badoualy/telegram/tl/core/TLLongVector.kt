package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
class TLLongVector : TLVector<Long>() {

    @Throws(IOException::class)
    override fun serializeItem(item: Long, tlSerializer: TLSerializer) {
        tlSerializer.writeLong(item)
    }

    @Throws(IOException::class)
    override fun deserializeItem(tlDeserializer: TLDeserializer): Long = tlDeserializer.readLong()

    override fun computeSerializedSize() = SIZE_CONSTRUCTOR_ID + SIZE_INT32 + SIZE_INT64 * size

    override fun toString() = "vector<long>#1cb5c415"
}
