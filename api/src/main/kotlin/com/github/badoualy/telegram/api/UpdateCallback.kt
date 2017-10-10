package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.tl.api.*

/** Map [TLAbsUpdates] updates into one method per constructor */
interface UpdateCallback {

    fun onUpdates(client: TelegramClientOld, updates: TLUpdates)

    fun onUpdatesCombined(client: TelegramClientOld, updates: TLUpdatesCombined)

    fun onUpdateShort(client: TelegramClientOld, update: TLUpdateShort)

    fun onShortChatMessage(client: TelegramClientOld, message: TLUpdateShortChatMessage)

    fun onShortMessage(client: TelegramClientOld, message: TLUpdateShortMessage)

    fun onShortSentMessage(client: TelegramClientOld, message: TLUpdateShortSentMessage)

    fun onUpdateTooLong(client: TelegramClientOld)

}