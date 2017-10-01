package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.core.TLLongVector
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

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
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        messages = readTLLongVector()
    }

    override fun toString(): String {
        return "msg_resend_req#7d861a08"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 2105940488
    }
}
