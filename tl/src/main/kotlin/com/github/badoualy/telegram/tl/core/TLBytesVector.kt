package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer

class TLBytesVector : TLVector<TLBytes>() {
    override fun serializeItem(item: TLBytes, tlSerializer: TLSerializer) {
        tlSerializer.writeTLBytes(item)
    }

    override fun deserializeItem(tlDeserializer: TLDeserializer): TLBytes {
        return tlDeserializer.readTLBytes()
    }

}