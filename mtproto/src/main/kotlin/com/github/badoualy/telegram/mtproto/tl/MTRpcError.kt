package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.util.regex.Pattern

class MTRpcError @JvmOverloads constructor(var errorCode: Int = 0, var message: String = "") : TLObject() {

    val errorTag: String
        get() {
            if (message.isEmpty())
                return "DEFAULT"

            val matcher = REGEXP_PATTERN.matcher(message)
            if (matcher.find())
                return matcher.group()

            return "DEFAULT"
        }

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeInt(errorCode, stream)
        writeString(message, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        errorCode = readInt(stream)
        message = readTLString(stream)
    }

    override fun toString(): String {
        return "rpc_error#2144ca19"
    }

    companion object {
        private val REGEXP_PATTERN = Pattern.compile("[A-Z_0-9]+")

        @JvmField
        val CONSTRUCTOR_ID = 558156313
    }
}
