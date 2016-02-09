package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.tl.api.*

interface UpdateCallback {

    fun onShortMessage(message: TLUpdateShortMessage)

    fun onShortChatMessage(message: TLUpdateShortChatMessage)

    fun onShortSentMessage(message: TLUpdateShortSentMessage)

    fun onUpdateTooLong()

    fun onNewMessage(message: TLUpdateNewMessage, container: TLAbsUpdates)

    fun onNewEncryptedMessage(message: TLUpdateNewEncryptedMessage, container: TLAbsUpdates)

    fun onNewChannelMessage(message: TLUpdateNewChannelMessage, container: TLAbsUpdates)
}