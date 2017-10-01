package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID
import com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer

class TLObjectVector<T : TLObject> : TLVector<T>() {

    override fun serializeItem(item: T, tlSerializer: TLSerializer) {
        tlSerializer.writeTLObject(item)
    }

    override fun deserializeItem(tlDeserializer: TLDeserializer): T = tlDeserializer.readTLObject()

    override fun computeSerializedSize() = SIZE_CONSTRUCTOR_ID + SIZE_INT32 +
            sumBy { it.computeSerializedSize() }
}