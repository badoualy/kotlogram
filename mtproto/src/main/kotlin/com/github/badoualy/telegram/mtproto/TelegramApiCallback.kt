package com.github.badoualy.telegram.mtproto

import com.github.badoualy.telegram.tl.api.TLAbsUpdates

interface TelegramApiCallback {
    fun onUpdates(update: TLAbsUpdates)
}