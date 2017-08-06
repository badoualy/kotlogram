package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.*

fun TLUser.toInputPeer() = TLInputPeerUser(id, accessHash)
fun TLAbsChat.toInputPeer() = when (this) {
    is TLChat -> TLInputPeerChat(id)
    is TLChannel -> TLInputPeerChannel(id, accessHash)
    else -> null
}