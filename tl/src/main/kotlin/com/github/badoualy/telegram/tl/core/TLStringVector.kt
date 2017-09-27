package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.TLObjectUtils

import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

import com.github.badoualy.telegram.tl.StreamUtils.readTLString
import com.github.badoualy.telegram.tl.StreamUtils.writeString
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLSerializer

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
class TLStringVector : TLVector<String>() {

    @Throws(IOException::class)
    override fun serializeItem(item: String, tlSerializer: TLSerializer) {
        tlSerializer.writeString(item)
    }

    @Throws(IOException::class)
    override fun deserializeItem(stream: InputStream, context: TLContext): String =
            readTLString(stream)

    override fun computeSerializedSize() = SIZE_CONSTRUCTOR_ID + SIZE_INT32 + sumBy {
        TLObjectUtils.computeTLStringSerializedSize(it)
    }

    override fun toString(): String {
        return "vector<string>#1cb5c415"
    }
}
