package com.github.badoualy.telegram.mtproto.transport

import java.io.IOException
import java.net.InetAddress

interface MTProtoConnection {

    @Throws(IOException::class)
    fun readMessage(): ByteArray

    @Throws(IOException::class)
    fun writeMessage(request: ByteArray)

    @Throws(IOException::class)
    fun executeMethod(request: ByteArray): ByteArray

    @Throws(IOException::class)
    fun close()

    fun isOpened(): Boolean

    fun getPort(): Int

    fun getIp(): String?
}
