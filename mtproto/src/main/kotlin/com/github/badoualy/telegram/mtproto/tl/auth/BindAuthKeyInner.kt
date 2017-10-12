package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

class BindAuthKeyInner @JvmOverloads constructor(var nonce: Long = 0,
                                                 var tempAuthKeyId: ByteArray = ByteArray(0),
                                                 var permAuthKeyId: ByteArray = ByteArray(0),
                                                 var tempSessionId: ByteArray = ByteArray(0),
                                                 var expiresAt: Int = 0) : TLObject() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        // see https://core.telegram.org/method/auth.bindTempAuthKey#encrypting-the-binding-message
        writeLong(nonce)
        writeByteArray(tempAuthKeyId)
        writeByteArray(permAuthKeyId)
        writeByteArray(tempSessionId)
        writeInt(expiresAt)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with(tlDeserializer) {
        nonce = readLong()
        tempAuthKeyId = readBytes(8)
        permAuthKeyId = readBytes(8)
        tempSessionId = readBytes(8)
        expiresAt = readInt()
    }

    override fun toString() = "bind_auth_key_inner#75a3f765"

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = 1973679973
    }
}
