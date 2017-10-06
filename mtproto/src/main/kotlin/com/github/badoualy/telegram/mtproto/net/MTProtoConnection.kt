package com.github.badoualy.telegram.mtproto.net

import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.model.DataCenter
import io.reactivex.Observable
import java.io.IOException
import java.nio.channels.SelectableChannel
import java.nio.channels.SelectionKey
import java.nio.channels.Selector

/**
 * A generic connection to Telegram.
 * Implement this interface to develop your own transport layer (tcp, udp, http, tcp-obfuscated, ...)
 */
interface MTProtoConnection {

    var tag: LogTag

    val ip: String
    val port: Int
    val dataCenter: DataCenter
        get() = DataCenter(ip, port)

    fun getMessageObservable(): Observable<ByteArray>

    @Throws(IOException::class)
    fun readMessage(): ByteArray

    @Throws(IOException::class)
    fun sendMessage(request: ByteArray)

    @Throws(IOException::class)
    fun executeMethodSync(request: ByteArray): ByteArray

    fun close()

    fun isAlive(): Boolean
}
