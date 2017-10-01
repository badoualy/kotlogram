package com.github.badoualy.telegram.mtproto.tl.auth

import com.github.badoualy.telegram.tl.core.TLMethod
import com.github.badoualy.telegram.tl.serialization.TLDeserializer
import com.github.badoualy.telegram.tl.serialization.TLSerializer
import java.io.IOException

class ReqDhParams @JvmOverloads constructor(var nonce: ByteArray = ByteArray(0),
                                            var serverNonce: ByteArray = ByteArray(0),
                                            var p: ByteArray = ByteArray(0),
                                            var q: ByteArray = ByteArray(0),
                                            var fingerPrint: Long = 0,
                                            var encryptedData: ByteArray = ByteArray(0))
    : TLMethod<ServerDhParams>() {

    override val constructorId: Int = CONSTRUCTOR_ID

    @Throws(IOException::class)
    override fun serializeBody(tlSerializer: TLSerializer) = with(tlSerializer) {
        writeByteArray(nonce)
        writeByteArray(serverNonce)
        writeTLBytes(p)
        writeTLBytes(q)
        writeLong(fingerPrint)
        writeTLBytes(encryptedData)
    }

    @Throws(IOException::class)
    override fun deserializeBody(tlDeserializer: TLDeserializer) = with (tlDeserializer) {
        nonce = readBytes(16)
        serverNonce = readBytes(16)
        p = readTLBytesAsBytes()
        q = readTLBytesAsBytes()
        fingerPrint = readLong()
        encryptedData = readTLBytesAsBytes()
    }

    @Throws(IOException::class)
    override fun deserializeResponse(tlDeserializer: TLDeserializer): ServerDhParams = tlDeserializer.readTLObject()

    override fun toString() = "req_DH_params#d712e4be"

    companion object {
        @JvmField
        val CONSTRUCTOR_ID = -686627650
    }
}
