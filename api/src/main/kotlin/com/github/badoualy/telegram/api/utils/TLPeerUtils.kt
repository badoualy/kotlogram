package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.TLAbsPeer
import com.github.badoualy.telegram.tl.api.TLPeerChannel
import com.github.badoualy.telegram.tl.api.TLPeerChat
import com.github.badoualy.telegram.tl.api.TLPeerUser

val TLAbsPeer.id: Int?
    get() = when (this) {
        is TLPeerUser -> userId
        is TLPeerChat -> chatId
        is TLPeerChannel -> channelId
        else -> null
    }

val TLAbsPeer.isChat: Boolean
    get() = this is TLPeerChat
val TLAbsPeer.isChannel: Boolean
    get() = this is TLPeerChannel
val TLAbsPeer.is1v1: Boolean
    get() = this is TLPeerUser