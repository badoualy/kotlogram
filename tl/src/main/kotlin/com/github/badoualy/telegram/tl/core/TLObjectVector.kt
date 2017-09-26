package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.StreamUtils
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import java.io.InputStream
import java.io.OutputStream

class TLObjectVector<T : TLObject>() : TLVector<T>() {

    override fun serializeItem(item: T, stream: OutputStream) {
        StreamUtils.writeTLObject(item as TLObject, stream)
    }

    override fun deserializeItem(stream: InputStream, context: TLContext): T =
            context.deserializeMessage(stream)

    override fun computeSerializedSize() = SIZE_CONSTRUCTOR_ID + SIZE_INT32 +
            sumBy { it.computeSerializedSize() }
}