package com.github.badoualy.telegram.mtproto.net

import java.nio.channels.SelectableChannel

/** An implementation of an [MTProtoConnection] that rely on a [SelectableChannel] */
interface MTProtoSelectableConnection : MTProtoConnection {
    val channel: SelectableChannel
}