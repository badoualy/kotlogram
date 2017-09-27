package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.writeByteArray
import com.github.badoualy.telegram.tl.StreamUtils.writeLong
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTInvokeAfter(var dependMsgId: Long = 0,
                    var request: ByteArray = ByteArray(0)) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeLong(dependMsgId)
        writeByteArray(request)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        throw UnsupportedOperationException("Unable to deserialize invokeAfterMsg#cb9f372d")
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -878758099
    }
}
