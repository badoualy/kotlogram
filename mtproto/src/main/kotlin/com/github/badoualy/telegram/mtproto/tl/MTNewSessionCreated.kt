package com.github.badoualy.telegram.mtproto.tl

import com.github.badoualy.telegram.tl.StreamUtils.readLong
import com.github.badoualy.telegram.tl.StreamUtils.writeLong
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class MTNewSessionCreated @JvmOverloads constructor(var firstMsgId: Long = 0, var uniqId: Long = 0, var serverSalt: Long = 0) : TLObject() {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        writeLong(firstMsgId, stream)
        writeLong(uniqId, stream)
        writeLong(serverSalt, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        firstMsgId = readLong(stream)
        uniqId = readLong(stream)
        serverSalt = readLong(stream)
    }

    override fun toString(): String {
        return "new_session_created#9ec20908"
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -1631450872
    }
}
