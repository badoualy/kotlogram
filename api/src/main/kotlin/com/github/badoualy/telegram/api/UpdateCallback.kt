package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.tl.api.TLUpdateShortChatMessage
import com.github.badoualy.telegram.tl.api.TLUpdateShortMessage
import com.github.badoualy.telegram.tl.api.TLUpdateShortSentMessage
import com.github.badoualy.telegram.tl.api.TLUpdates

interface UpdateCallback {

    fun onUpdates(client: TelegramClient, message: TLUpdates)

    fun onShortMessage(client: TelegramClient, message: TLUpdateShortMessage)

    fun onShortChatMessage(client: TelegramClient, message: TLUpdateShortChatMessage)

    fun onShortSentMessage(client: TelegramClient, message: TLUpdateShortSentMessage)

    fun onUpdateTooLong(client: TelegramClient)

    //fun onNewMessage(client: TelegramClient, message: TLUpdateNewMessage, container: TLAbsUpdates)

    //fun onNewEncryptedMessage(client: TelegramClient, message: TLUpdateNewEncryptedMessage, container: TLAbsUpdates)

    //fun onNewChannelMessage(client: TelegramClient, message: TLUpdateNewChannelMessage, container: TLAbsUpdates)
}