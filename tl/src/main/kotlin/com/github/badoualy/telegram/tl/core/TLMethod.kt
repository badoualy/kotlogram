package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLStreamDeserializer
import java.io.ByteArrayInputStream
import java.io.IOException

/**
 * Basic object for RPC methods. It contains special methods for deserializing result of RPC method call.
 *
 * @param <T> return type of method
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
abstract class TLMethod<T : TLObject> : TLObject() {

    @Transient
    var response: T? = null

    @Throws(IOException::class)
    fun deserializeResponse(data: ByteArray, context: TLContext): T {
        response = deserializeResponse(TLStreamDeserializer(ByteArrayInputStream(data), context))
        return response!!
    }

    // TODO: add an internal version to overload, and a public version
    // The public version should set response field
    @Throws(IOException::class)
    abstract fun deserializeResponse(tlDeserializer: TLDeserializer): T
}