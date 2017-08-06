package com.github.badoualy.telegram.mtproto.transport

import com.github.badoualy.telegram.mtproto.model.DataCenter
import org.slf4j.Marker
import java.io.IOException
import java.nio.channels.SelectableChannel
import java.nio.channels.SelectionKey
import java.nio.channels.Selector

interface MTProtoConnection {

    var tag: String
    val marker: Marker

    val ip: String
    val port: Int
    val dataCenter: DataCenter
        get() = DataCenter(ip, port)

    @Throws(IOException::class)
    fun readMessage(): ByteArray

    @Throws(IOException::class)
    fun writeMessage(request: ByteArray)

    @Throws(IOException::class)
    fun executeMethod(request: ByteArray): ByteArray

    @Throws(IOException::class)
    fun close()

    fun isOpen(): Boolean

    /** New SelectionKey registered on Selector */
    fun register(selector: Selector): SelectionKey

    /** Previously registered SelectionKey */
    fun unregister(): SelectionKey?

    fun setBlocking(blocking: Boolean): SelectableChannel?
}
