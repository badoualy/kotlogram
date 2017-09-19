package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.*

fun TLUser.toInputPeer() = TLInputPeerUser(id, accessHash ?: 0)
fun TLAbsChat.toInputPeer() = when (this) {
    is TLChat -> TLInputPeerChat(id)
    is TLChannel -> TLInputPeerChannel(id, accessHash ?: 0)
    else -> null
}