package com.github.badoualy.telegram.mtproto.transport

import java.io.IOException

interface MTProtoConnection {

    @Throws(IOException::class)
    fun readMessage(): ByteArray

    @Throws(IOException::class)
    fun writeMessage(request: ByteArray)

    @Throws(IOException::class)
    fun executeMethod(request: ByteArray): ByteArray

    @Throws(IOException::class)
    fun close()
    
}
