package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.readInt
import com.github.badoualy.telegram.tl.StreamUtils.writeInt
import com.github.badoualy.telegram.tl.TLContext
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream

class PQInnerTemp @JvmOverloads constructor(pq: ByteArray = ByteArray(0),
                                            p: ByteArray = ByteArray(0), q: ByteArray = ByteArray(0),
                                            nonce: ByteArray = ByteArray(0), serverNonce: ByteArray = ByteArray(0),
                                            newNonce: ByteArray = ByteArray(0), var expiresIn: Int = 0) : PQInner(pq, p, q, nonce, serverNonce, newNonce) {

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        super.serializeBody(stream)
        writeInt(expiresIn, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        super.deserializeBody(stream, context)
        expiresIn = readInt(stream)
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1013613780
    }
}
