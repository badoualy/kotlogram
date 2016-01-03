package com.github.badoualy.telegram.mtproto.transport

import com.github.badoualy.telegram.tl.StreamUtils.*
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.net.InetSocketAddress
import java.net.Socket

class MTProtoTcpConnection
@Throws(IOException::class)
@JvmOverloads constructor(ip: String, port: Int, abridgedProtocol: Boolean = true) : MTProtoConnection {

    private val socket: Socket
    private val outStream: OutputStream
    private val inStream: InputStream

    init {
        socket = Socket()
        socket.connect(InetSocketAddress(ip, port))
        socket.keepAlive = true
        socket.tcpNoDelay = true

        outStream = socket.outputStream
        inStream = socket.inputStream

        if (abridgedProtocol)
            outStream.write(239) // @see https://core.telegram.org/mtproto/samples-auth_key

        println("Connected to $ip:$port")
    }

    @Throws(IOException::class)
    override fun readMessage(): ByteArray {
        /*
        (0x01..0x7e = data length divided by 4;
        or 0x7f followed by 3 length bytes (little endian) divided by 4)
         */
        var headerLen = readByte(inStream)
        if (headerLen == 127)
            headerLen = readByte(inStream) + (readByte(inStream) shl 8) + (readByte(inStream) shl 16)

        return readBytes(headerLen * 4, inStream)
    }

    @Throws(IOException::class)
    override fun writeMessage(request: ByteArray) {
        val stream = ByteArrayOutputStream()

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
        val pkg = stream.toByteArray()
        outStream.write(pkg, 0, pkg.size)
        outStream.flush()
    }

    @Throws(IOException::class)
    override fun executeMethod(request: ByteArray): ByteArray {
        writeMessage(request)
        return readMessage()
    }

    @Throws(IOException::class)
    override fun close() = socket.close()
}
