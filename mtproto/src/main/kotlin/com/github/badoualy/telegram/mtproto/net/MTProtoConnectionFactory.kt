package com.github.badoualy.telegram.mtproto.net

import com.github.badoualy.telegram.mtproto.log.LogTag
import com.github.badoualy.telegram.mtproto.model.DataCenter

interface MTProtoConnectionFactory {
    fun create(dataCenter: DataCenter, tag: LogTag): MTProtoConnection
}

class MTProtoTcpConnectionFactory : MTProtoConnectionFactory {
    override fun create(dataCenter: DataCenter, tag: LogTag): MTProtoConnection =
            MTProtoTcpConnection(dataCenter, tag)
}
