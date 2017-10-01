package com.github.badoualy.telegram.tl

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLStreamDeserializer

fun TLContext.deserializeMessage(byteArray: ByteArray) =
        TLStreamDeserializer(byteArray, this).readTLObject<TLObject>()