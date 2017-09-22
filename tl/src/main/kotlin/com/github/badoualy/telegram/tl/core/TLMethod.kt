package com.github.badoualy.telegram.tl.core

import com.github.badoualy.telegram.tl.TLContext

import java.io.ByteArrayInputStream
import java.io.IOException
import java.io.InputStream

/**
 * Basic object for RPC methods. It contains special methods for deserializing result of RPC method call.
 *
 * @param <T> return type of method
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see [http://github.com/badoualy/kotlogram](http://github.com/badoualy/kotlogram)
 */
abstract class TLMethod<T : TLObject> : TLObject() {

    @Transient
    var response: T? = null

    @Throws(IOException::class)
    fun deserializeResponse(data: ByteArray, context: TLContext): T {
        response = deserializeResponse(ByteArrayInputStream(data), context)
        return response!!
    }

    // TODO: add an internal version to overload, and a public version
    // The public version should set response field
    @Throws(IOException::class)
    abstract fun deserializeResponse(stream: InputStream, context: TLContext): T
}