package com.github.badoualy.telegram.mtproto.net

import java.nio.channels.SelectableChannel
import java.nio.channels.SelectionKey
import java.nio.channels.Selector

interface SelectableConnection {

    val channel: SelectableChannel

    fun register(selector: Selector, ops: Int): SelectionKey {
        channel.configureBlocking(false)
        return channel.register(selector, ops)!!
    }
}