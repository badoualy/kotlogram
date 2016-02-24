package com.github.badoualy.telegram.mtproto.util

import com.github.badoualy.telegram.tl.api.*

/////////////// Message
fun TLAbsMessage.getDate(): Long = when (this) {
    is TLMessage -> date.toLong()
    is TLMessageService -> date.toLong()
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



/////////////// TLAbsPeer

fun TLAbsPeer.isChat() = this is TLPeerChat
fun TLAbsPeer.isChannel() = this is TLPeerChannel
fun TLAbsPeer.isSimpleDicussion() = this is TLPeerUser



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


/////////////// TLAbsMessageMedia

fun TLAbsMessageMedia.getAbsMediaInput() = when (this) {
    is TLMessageMediaAudio -> getMediaInput()
    is TLMessageMediaContact -> null
    is TLMessageMediaDocument -> getMediaInput()
    is TLMessageMediaEmpty -> null
    is TLMessageMediaGeo -> null
    is TLMessageMediaPhoto -> null
    is TLMessageMediaUnsupported -> null
    is TLMessageMediaVenue -> null
    is TLMessageMediaVideo -> getMediaInput()
    is TLMessageMediaWebPage -> null
    else -> null
}

fun TLMessageMediaDocument.getMediaInput() = when (document) {
    is TLDocument -> {
        val document = document as TLDocument
        MediaInput(TLInputDocumentFileLocation(document.id, (document.accessHash)), document.size, document.mimeType)
    }
    else -> null
}

fun TLMessageMediaAudio.getMediaInput() = when (audio) {
    is TLAudio -> {
        val audio = audio as TLAudio
        MediaInput(TLInputAudioFileLocation(audio.id, audio.accessHash), audio.size, audio.mimeType)
    }
    else -> null
}

fun TLMessageMediaVideo.getMediaInput() = when (video) {
    is TLVideo -> {
        val video = video as TLVideo
        MediaInput(TLInputVideoFileLocation(video.id, video.accessHash), video.size, video.mimeType)
    }
    else -> null
}

data class MediaInput(val inputFileLocation: TLAbsInputFileLocation, val size: Int, val mimeType: String)