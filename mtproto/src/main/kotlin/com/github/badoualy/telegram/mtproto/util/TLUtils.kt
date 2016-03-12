package com.github.badoualy.telegram.mtproto.util

import com.github.badoualy.telegram.tl.api.*

/////////////// Message
fun TLAbsMessage.getDate(): Int = when (this) {
    is TLMessage -> date
    is TLMessageService -> date
    else -> 0
}

fun TLAbsMessage.getFromId(): Int = when (this) {
    is TLMessage -> fromId
    is TLMessageService -> fromId
    else -> 0
}

fun TLAbsMessage.isUnread(): Boolean = when (this) {
    is TLMessage -> unread
    is TLMessageService -> unread
    else -> false
}

fun TLAbsMessage.getMessageOrEmpty() = when (this) {
    is TLMessage -> message
    else -> ""
}

fun TLAbsMessage.getToAsPeer() = when (this) {
    is TLMessage -> toId
    is TLMessageService -> toId
    else -> null
}

fun TLAbsMessage.isReply() = this is TLMessage && replyToMsgId != null
fun TLAbsMessage.getReplyTo() = if (this.isReply()) (this as TLMessage).replyToMsgId else null

fun TLMessage.isForward() = fwdFromId != null
fun TLMessage.isReply() = replyToMsgId != null
fun TLAbsMessage.isSticker(): Boolean {
    if (this !is TLMessage) return false
    if (media == null || media !is TLMessageMediaDocument) return false
    val media = this.media as TLMessageMediaDocument
    if (media.document.isEmpty) return false
    return media.document.asDocument.attributes.any { it is TLDocumentAttributeSticker }
}

fun TLAbsMessage.getStickerAlt() = when (isSticker()) {
    true -> ((this as TLMessage).media as TLMessageMediaDocument).document.asDocument.attributes.filterIsInstance<TLDocumentAttributeSticker>().first().alt
    false -> null
}

fun TLAbsMessage.getSticker(): TLDocument? {
    if (!isSticker()) return null
    return ((this as TLMessage).media as TLMessageMediaDocument).document.asDocument
}

fun TLAbsMessage.getToId() = when (this) {
    is TLMessage -> toId
    is TLMessageService -> toId
    else -> null
}

fun TLAbsPeer.getPeerId() = when (this) {
    is TLPeerUser -> userId
    is TLPeerChat -> chatId
    is TLPeerChannel -> channelId
    else -> null
}



/////////////// TLAbsPeer

fun TLAbsPeer.isChat() = this is TLPeerChat
fun TLAbsPeer.isChannel() = this is TLPeerChannel
fun TLAbsPeer.is1v1() = this is TLPeerUser



/////////////// TLAbsMessageAction

fun TLAbsMessageAction.getChatTitle(): String? = when (this) {
    is TLMessageActionChannelCreate -> title
    is TLMessageActionChatCreate -> title
    is TLMessageActionChatEditTitle -> title
    is TLMessageActionChannelMigrateFrom -> title
    else -> null
}

fun TLAbsMessageAction.getIdList(): IntArray? = when (this) {
    is TLMessageActionChatAddUser -> users.toIntArray()
    is TLMessageActionChatCreate -> users.toIntArray()
    is TLMessageActionChatDeleteUser -> intArrayOf(userId)
    is TLMessageActionChatJoinedByLink -> intArrayOf(inviterId)
    is TLMessageActionChannelMigrateFrom -> intArrayOf(chatId)
    is TLMessageActionChatMigrateTo -> intArrayOf(channelId)
    else -> null
}



/////////////// TLNotifySettings

fun TLAbsPeerNotifySettings.isMuted() = when (this) {
    is TLPeerNotifySettings -> muteUntil > ((System.currentTimeMillis() / 1000) + 60)
    else -> false
}
