package com.github.badoualy.telegram.api.utils

import com.github.badoualy.telegram.tl.api.*

val TLAbsMessageAction.title: String?
    get() = when (this) {
        is TLMessageActionChannelCreate -> title
        is TLMessageActionChatCreate -> title
        is TLMessageActionChatEditTitle -> title
        is TLMessageActionChannelMigrateFrom -> title
        else -> null
    }

val TLAbsMessageAction.userIdList: IntArray?
    get() = when (this) {
        is TLMessageActionChatAddUser -> users.toIntArray()
        is TLMessageActionChatCreate -> users.toIntArray()
        is TLMessageActionChatDeleteUser -> intArrayOf(userId)
        is TLMessageActionChatJoinedByLink -> intArrayOf(inviterId)
        else -> null
    }
