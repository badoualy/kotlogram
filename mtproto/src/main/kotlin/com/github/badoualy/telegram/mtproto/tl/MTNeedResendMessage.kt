package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector
import com.github.badoualy.telegram.tl.StreamUtils.writeTLVector
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTNeedResendMessage @JvmOverloads constructor(var messages: TLLongVector = TLLongVector()) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    constructor(msgIds: LongArray) : this() {
        messages.addAll(msgIds.toList())
    }

    constructor(msgIds: Array<Long>) : this() {
        messages.addAll(msgIds)
    }

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeTLVector(messages)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        messages = readTLLongVector(stream, context)
    }

    override fun toString(): String {
        return "msg_resend_req#7d861a08"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 2105940488
    }
}
