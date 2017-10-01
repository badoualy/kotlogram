package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.TLContext
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.math.BigInteger

class BindAuthKeyInner @JvmOverloads constructor(var nonce: Long = 0,
                                                 var tempAuthKeyId: Long = 0,
                                                 var permAuthKeyId: Long = 0,
                                                 var tempSessionId: Long = 0,
                                                 var expiresAt: Int = 0) : TLObject() {

    constructor(nonce: Long, tempAuthKeyId: Long, permAuthKeyId: Long,
                tempSessionId: ByteArray, expiresAt: Int) : this(nonce,
                                                                 tempAuthKeyId, permAuthKeyId,
                                                                 BigInteger(tempSessionId).toLong(),
                                                                 expiresAt)

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        // see https://core.telegram.org/method/auth.bindTempAuthKey#encrypting-the-binding-message
        writeLong(nonce)
        writeLong(tempAuthKeyId)
        writeLong(permAuthKeyId)
        writeLong(tempSessionId)
        writeInt(expiresAt)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        nonce = readLong()
        tempAuthKeyId = readLong()
        permAuthKeyId = readLong()
        tempSessionId = readLong()
        expiresAt = readInt()
    }

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1973679973
    }
}
