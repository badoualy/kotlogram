package com.github.badoualy.telegram.mtproto.net

import com.github.badoualy.telegram.mtproto.MTProtoWatchdog
import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.log.Logger
import com.github.badoualy.telegram.mtproto.model.DataCenter
import com.github.badoualy.telegram.tl.ByteBufferUtils.*
import java.io.EOFException
import java.io.IOException
import java.net.ConnectException
import java.net.InetSocketAddress
import java.net.StandardSocketOptions
import java.nio.ByteBuffer
import java.nio.ByteOrder
import java.nio.channels.SelectableChannel
import java.nio.channels.SocketChannel
import java.util.concurrent.TimeUnit

/**
 * An implementation of [MTProtoConnection] using TCP as transport layer.
 * The implementation is using a [SocketChannel] to be able to use [java.nio.channels.Selector] for scalability.
 * For now this class only implements the abridged protocol.
 * @see <a href="https://core.telegram.org/mtproto#tcp-transport">MTProto description - TCP Transport</a>
 */
internal class MTProtoTcpConnection
@Throws(IOException::class)
@JvmOverloads constructor(override val dataCenter: DataCenter,
                          override var tag: LogTag,
                          abridgedProtocol: Boolean = true) : MTProtoSelectableConnection {

    private var socketChannel: SocketChannel

    // Buffer
    private val msgHeaderBuffer = ByteBuffer.allocate(1)
    private val msgLengthBuffer = ByteBuffer.allocate(3)
    private val msgBuffer = ByteBuffer.allocate(BUFFER_SIZE)

    override val channel: SelectableChannel
        get() = socketChannel

    init {
        var attempt = 1
        do {
            socketChannel = SocketChannel.open()
            socketChannel.setOption(StandardSocketOptions.SO_KEEPALIVE, false)
            socketChannel.setOption(StandardSocketOptions.TCP_NODELAY, true)
            try {
                socketChannel.connect(InetSocketAddress(dataCenter.ipv4, dataCenter.port))
                if (!socketChannel.finishConnect()) {
                    logger.error(tag, "finishConnect() returned false, this should not happen!!")
                }

                if (abridgedProtocol) {
                    // @see https://core.telegram.org/mtproto/samples-auth_key
                    logger.debug(tag, "Using abridged protocol")
                    writeBytes(ByteBuffer.wrap(byteArrayOf(0xef.toByte())))
                }
                logger.info(tag, "Connected to $dataCenter")
                socketChannel.socket().sendBufferSize = BUFFER_SIZE
                socketChannel.socket().receiveBufferSize = BUFFER_SIZE
                break
            } catch (e: Exception) {
                logger.error(tag, "Failed to connect", e)
                try {
                    socketChannel.close()
                } catch (e: Exception) {
                }
            }
            Thread.sleep(TimeUnit.SECONDS.toMillis(2))

            if (attempt == ATTEMPT_COUNT)
                throw ConnectException("Failed to join Telegram server at $dataCenter")
        } while (attempt++ < ATTEMPT_COUNT)
    }

    @Throws(IOException::class)
    override fun readMessage(): ByteArray {
        /*
        (0x01..0x7e = data length divided by 4;
        or 0x7f followed by 3 length bytes (little endian) divided by 4)
         */

        // Read message length
        var length = readByteAsInt(readBytes(1, msgHeaderBuffer))
        logger.debug(tag, "Length first byte ${Integer.toHexString(length)}")
        if (length == 0x7f) {
            length = readInt24(readBytes(3, msgLengthBuffer))
            logger.debug(tag, "Long length bytes ${Integer.toHexString(length)}")
        }
        length *= 4

        logger.debug(tag, "About to read a message of length $length")
        val buffer = readBytes(length, msgBuffer)

        // Convert to a ByteArray
        val bytes = ByteArray(buffer.remaining())
        buffer.get(bytes, 0, buffer.remaining())
        return bytes
    }

    @Throws(IOException::class)
    override fun sendMessage(request: ByteArray) {
        val length = request.size / 4
        val headerLength = if (length >= 127) 4 else 1
        val totalLength = headerLength + request.size
        val buffer = ByteBuffer.allocate(totalLength)

        /*
        There is an abridged version of the same protocol: if the client sends 0xef as the first byte
        (**important:** only prior to the very first data packet),
        then packet length is encoded by a single byte (0x01..0x7e = data length divided by 4;
        or 0x7f followed by 3 length bytes (little endian) divided by 4) followed by the data themselves (sequence number and CRC32 not added).
        In this case, server responses look the same (the server does not send 0xef as the first byte).
         */
        if (headerLength == 4) {
            writeByte(0x7f, buffer)
            writeInt24(length, buffer)
        } else {
            writeByte(length, buffer)
        }

        buffer.put(request)
        buffer.flip()
        writeBytes(buffer)
    }

    @Throws(IOException::class)
    @Deprecated("Remove this, use RX instead")
    override fun executeMethodSync(request: ByteArray): ByteArray {
        // TODO: use RX to send/read and let user convert to blocking if needed
        sendMessage(request)
        return readMessage()
    }

    /**
     * Convenience mapping to [MTProtoWatchdog.getMessageObservable]
     */
    override fun getMessageObservable() = MTProtoWatchdog.getMessageObservable(this)

    override fun close() {
        logger.debug(tag, "Closing connection")
        try {
            socketChannel.close()
        } catch (e: IOException) {
        }
    }

    override fun isAlive() = socketChannel.isOpen && socketChannel.isConnected

    private fun readBytes(length: Int, recycledBuffer: ByteBuffer? = null, order: ByteOrder = ByteOrder.BIG_ENDIAN): ByteBuffer {
        recycledBuffer?.clear()
        val buffer =
                if (recycledBuffer == null || recycledBuffer.capacity() < length)
                    ByteBuffer.allocate(length)
                else recycledBuffer
        buffer.order(order)
        buffer.limit(length)

        var totalRead = 0
        logger.trace(tag, "readBytes(): $length, bufferSize: ${buffer.capacity()}")
        while (totalRead < length) {
            val read = socketChannel.read(buffer)

            // TODO Maybe https://github.com/badoualy/kotlogram/issues/33 is caused because not every arrived at once?
            // TODO Check logs to see if some part was read, maybe missing bytes will arrive after
            if (read == -1)
                throw EOFException(
                        "Reached end-of-stream while reading $length bytes ($totalRead read)")

            totalRead += read

            if (read == 0 && totalRead < length) {
                logger.error(tag, "Yield ---------------------------------------- ${buffer.remaining()} $totalRead $length")
                Thread.yield()
            }
        }

        if (totalRead != length) {
            logger.error("Read $totalRead instead of $length")
        }

        buffer.flip()
        return buffer
    }

    private fun writeBytes(buffer: ByteBuffer) {
        while (buffer.hasRemaining())
            socketChannel.write(buffer)
    }

    companion object {
        private val logger = Logger.Factory.create(MTProtoTcpConnection::class)

        /** Initial connection attempt count before considering failure */
        private const val ATTEMPT_COUNT = 3

        private const val BUFFER_SIZE = 64 * 1024
    }
}
