package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.*

val TLAbsChat?.title: String?
    get() = when (this) {
        is TLChannel -> title
        is TLChannelForbidden -> title
        is TLChat -> title
        is TLChatForbidden -> title
        is TLChatEmpty -> null
        else -> null
    }