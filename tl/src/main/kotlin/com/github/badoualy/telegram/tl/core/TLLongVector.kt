package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.StreamUtils.readLong
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
class TLLongVector : TLVector<Long>() {

    @Throws(IOException::class)
    override fun serializeItem(item: Long, tlSerializer: TLSerializer) {
        tlSerializer.writeLong(item)
    }

    @Throws(IOException::class)
    override fun deserializeItem(stream: InputStream, context: TLContext): Long = readLong(stream)

    override fun computeSerializedSize() = SIZE_CONSTRUCTOR_ID + SIZE_INT32 + SIZE_INT64 * size

    override fun toString() = "vector<long>#1cb5c415"
}
