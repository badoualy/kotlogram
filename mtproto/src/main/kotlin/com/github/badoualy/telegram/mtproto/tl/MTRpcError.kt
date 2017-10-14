package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.mtproto.exception.RpcError
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

class MTRpcError @JvmOverloads constructor(var code: Int = 0,
                                           var message: String = "") : TLObject() {

    val error: RpcError by lazy {
        RpcError(code, message.replace(NUMBER_REGEX, "X"), "")
    }

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeInt(code)
        writeString(message)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with(tlDeserializer) {
        code = readInt()
        message = readString()
    }

    override fun toString() = "rpc_error#2144ca19"

    companion object {

        val TYPE_REGEX = "[A-Z_0-9]+".toRegex()
        val NUMBER_REGEX = "[0-9]+".toRegex()

        @JvmField
        val CONSTRUCTOR_ID = 558156313
    }
}
