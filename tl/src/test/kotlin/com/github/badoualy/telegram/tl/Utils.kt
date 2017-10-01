package com.github.badoualy.telegram.tl

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLStreamDeserializer
import java.io.ByteArrayInputStream

fun TLContext.deserializeMessage(byteArray: ByteArray) =
        TLStreamDeserializer(ByteArrayInputStream(byteArray), this).readTLObject<TLObject>()