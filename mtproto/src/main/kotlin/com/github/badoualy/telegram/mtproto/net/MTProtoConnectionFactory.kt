package com.github.badoualy.telegram.mtproto.net

import com.github.badoualy.telegram.mtproto.log.LogTag

interface MTProtoConnectionFactory {
    fun create(ip: String, port: Int, tag: LogTag): MTProtoConnection
}

class MTProtoTcpConnectionFactory : MTProtoConnectionFactory {
    override fun create(ip: String, port: Int, tag: LogTag): MTProtoConnection =
            MTProtoTcpConnection(ip, port, tag)
}
