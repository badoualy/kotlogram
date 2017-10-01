package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

class MTInvokeAfter(var dependMsgId: Long = 0,
                    var request: ByteArray = ByteArray(0)) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeLong(dependMsgId)
        writeByteArray(request)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        throw UnsupportedOperationException("Unable to deserialize invokeAfterMsg#cb9f372d")
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -878758099
    }
}
