package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTBadServerSalt @JvmOverloads constructor(badMsgId: Long = 0,
                                                badMsqSeqno: Int = 0,
                                                errorCode: Int = 0,
                                                var newSalt: Long = 0)
    : MTBadMessage(badMsgId, badMsqSeqno, errorCode) {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeLong(badMsgId)
        writeInt(badMsqSeqno)
        writeInt(errorCode)
        writeLong(newSalt)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        badMsgId = readLong(stream)
        badMsqSeqno = readInt(stream)
        errorCode = readInt(stream)
        newSalt = readLong(stream)
    }

    override fun toString(): String {
        return "bad_server_salt#edab447b"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -307542917
    }
}
