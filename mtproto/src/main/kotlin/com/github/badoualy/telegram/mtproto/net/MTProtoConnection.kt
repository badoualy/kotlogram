package com.github.badoualy.telegram.mtproto.net

import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.model.DataCenter
import java.io.IOException
import java.nio.channels.SelectableChannel
import java.nio.channels.SelectionKey
import java.nio.channels.Selector

/**
 * A generic connection to Telegram.
 * Implement this interface to develop your own transport layer (tcp, udp, http, tcp-obfuscated, ...)
 */
interface MTProtoConnection : SelectableConnection {

    var tag: LogTag

    val ip: String
    val port: Int
    val dataCenter: DataCenter
        get() = DataCenter(ip, port)

    @Throws(IOException::class)
    fun readMessage(): ByteArray

    @Throws(IOException::class)
    fun sendMessage(request: ByteArray)

    @Throws(IOException::class)
    fun executeMethodSync(request: ByteArray): ByteArray

    @Throws(IOException::class)
    fun close()

    fun isAlive(): Boolean

    /** New SelectionKey registered on Selector */
    fun register(selector: Selector): SelectionKey

    /** Previously registered SelectionKey */
    fun unregister(): SelectionKey?

    fun setBlocking(blocking: Boolean): SelectableChannel?
}
