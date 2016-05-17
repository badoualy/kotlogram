package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.tl.api.*

interface UpdateCallback {

    fun onUpdates(client: TelegramClient, updates: TLUpdates)

    fun onUpdatesCombined(client: TelegramClient, updates: TLUpdatesCombined)

    fun onUpdateShort(client: TelegramClient, update: TLUpdateShort)

    fun onShortChatMessage(client: TelegramClient, message: TLUpdateShortChatMessage)

    fun onShortMessage(client: TelegramClient, message: TLUpdateShortMessage)

    fun onShortSentMessage(client: TelegramClient, message: TLUpdateShortSentMessage)

    fun onUpdateTooLong(client: TelegramClient)

}