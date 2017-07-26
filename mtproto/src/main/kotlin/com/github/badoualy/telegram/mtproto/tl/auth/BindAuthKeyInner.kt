package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.math.BigInteger

class BindAuthKeyInner @JvmOverloads constructor(var nonce: Long = 0,
                                                 var tempAuthKeyId: Long = 0, var permAuthKeyId: Long = 0,
                                                 var tempSessionId: Long = 0, var expiresAt: Int = 0) : TLObject() {

    constructor(nonce: Long, tempAuthKeyId: Long, permAuthKeyId: Long,
                tempSessionId: ByteArray, expiresAt: Int) : this(nonce,
                                                                 tempAuthKeyId, permAuthKeyId,
                                                                 BigInteger(tempSessionId).toLong(), expiresAt)

    override fun getConstructorId(): Int {
        return CONSTRUCTOR_ID
    }

    @Throws(IOException::class)
    override fun serializeBody(stream: OutputStream) {
        // see https://core.telegram.org/method/auth.bindTempAuthKey#encrypting-the-binding-message
        writeLong(nonce, stream)
        writeLong(tempAuthKeyId, stream)
        writeLong(permAuthKeyId, stream)
        writeLong(tempSessionId, stream)
        writeInt(expiresAt, stream)
    }

    @Throws(IOException::class)
    override fun deserializeBody(stream: InputStream, context: TLContext) {
        nonce = readLong(stream)
        tempAuthKeyId = readLong(stream)
        permAuthKeyId = readLong(stream)
        tempSessionId = readLong(stream)
        expiresAt = readInt(stream)
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1973679973
    }
}
