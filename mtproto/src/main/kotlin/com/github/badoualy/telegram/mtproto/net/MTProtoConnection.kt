package com.github.badoualy.telegram.mtproto.net

import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.model.DataCenter
import io.reactivex.Observable
import java.io.IOException

/**
 * A generic connection to Telegram.
 * Implement this interface to develop your own transport layer (tcp, udp, http, tcp-obfuscated, ...)
 */
interface MTProtoConnection {

    var tag: LogTag

    val dataCenter: DataCenter

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
