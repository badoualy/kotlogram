package com.github.badoualy.telegram.api

import com.github.badoualy.telegram.tl.api.TLUpdateNewMessage
import com.github.badoualy.telegram.tl.api.TLUpdateShortChatMessage
import com.github.badoualy.telegram.tl.api.TLUpdateShortMessage

interface UpdateCallback {

    fun onUpdateTooLong()

    fun onShortMessage(message: TLUpdateShortMessage)

    fun onShortChatMessage(message: TLUpdateShortChatMessage)

    fun onNewMessage(message: TLUpdateNewMessage)

}