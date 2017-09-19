package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLContext

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

import com.github.badoualy.telegram.tl.StreamUtils.readInt
import com.github.badoualy.telegram.tl.StreamUtils.writeInt
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
class TLIntVector : TLVector<Int>(Int::class.java) {

    @Throws(IOException::class)
    override fun serializeItem(item: Int, stream: OutputStream) {
        writeInt(item, stream)
    }

    @Throws(IOException::class)
    override fun deserializeItem(stream: InputStream, context: TLContext): Int = readInt(stream)

    override fun computeSerializedSize() = SIZE_CONSTRUCTOR_ID + SIZE_INT32 + SIZE_INT32 * size

    override fun toString() = "vector<int>#1cb5c415"

}
