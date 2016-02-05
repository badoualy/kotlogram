package com.github.badoualy.telegram.mtproto.transport

import com.github.badoualy.telegram.mtproto.util.Log
import com.github.badoualy.telegram.tl.ByteBufferUtils.readByteAsInt
import com.github.badoualy.telegram.tl.ByteBufferUtils.readInt24
import com.github.badoualy.telegram.tl.StreamUtils.*
import com.github.badoualy.telegram.tl.stream.ByteBufferBackedInputStream
import com.github.badoualy.telegram.tl.stream.ByteBufferBackedOutputStream
import java.io.IOException
import java.net.InetSocketAddress
import java.net.StandardSocketOptions
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.SocketChannel

class MTProtoTcpConnection
@Throws(IOException::class)
@JvmOverloads constructor(override val ip: String, override val port: Int, abridgedProtocol: Boolean = true) : MTProtoConnection {

    private val TAG = "MTProtoTcpConnection"

    private val socketChannel: SocketChannel

    init {
        socketChannel = SocketChannel.open()
        socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, true)
        socketChannel.setOption(StandardSocketOptions.TCP_NODELAY, true)
        socketChannel.configureBlocking(true)
        socketChannel.connect(InetSocketAddress(ip, port))

        if (abridgedProtocol) {
            // @see https://core.telegram.org/mtproto/samples-auth_key
            socketChannel.write(ByteBuffer.wrap(byteArrayOf(0xef.toByte())))
        }

        Log.d(TAG, "Connected to $ip:$port")
    }

    @Throws(IOException::class)
    override fun readMessage(): ByteArray {
        /*
        (0x01..0x7e = data length divided by 4;
        or 0x7f followed by 3 length bytes (little endian) divided by 4)
         */

        // Prepare buffer
        var buffer = ByteBuffer.allocateDirect(1)
        socketChannel.read(buffer)
        buffer.flip()

        var length = readByteAsInt(buffer)
        if (length == 0x7f) {
            buffer = ByteBuffer.allocateDirect(3)
            buffer.order(ByteOrder.LITTLE_ENDIAN)
            socketChannel.read(buffer)
            buffer.flip()

            length = readInt24(buffer)
        }

        length *= 4
        buffer = ByteBuffer.allocateDirect(length)
        socketChannel.read(buffer)
        buffer.flip()
        return readBytes(length, ByteBufferBackedInputStream(buffer))
    }

    @Throws(IOException::class)
    override fun writeMessage(request: ByteArray) {
        val buffer = ByteBuffer.allocateDirect(request.size + 4)
        val stream = ByteBufferBackedOutputStream(buffer)

        /*
        There is an abridged version of the same protocol: if the client sends 0xef as the first byte
        (**important:** only prior to the very first data packet),
        then packet length is encoded by a single byte (0x01..0x7e = data length divided by 4;
        or 0x7f followed by 3 length bytes (little endian) divided by 4) followed by the data themselves (sequence number and CRC32 not added).
        In this case, server responses look the same (the server does not send 0xef as the first byte).
         */
        if (request.size / 4 >= 127) {
            val len = request.size / 4
            writeByte(127, stream)
            writeByte(len and 255, stream)
            writeByte((len shr 8) and 255, stream)
            writeByte((len shr 16) and 255, stream)
        } else {
            writeByte(request.size / 4, stream)
        }

        writeByteArray(request, stream)
        buffer.flip()
        socketChannel.write(buffer)
    }

    @Throws(IOException::class)
    override fun executeMethod(request: ByteArray): ByteArray {
        writeMessage(request)
        return readMessage()
    }

    @Throws(IOException::class)
    override fun close() {
        Log.d(TAG, "Closing connection")
        socketChannel.close()
    }

    override fun isOpened() = socketChannel.isOpen && socketChannel.isConnected
}
