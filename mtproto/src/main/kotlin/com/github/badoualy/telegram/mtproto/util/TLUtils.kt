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

fun TLAbsMessageMedia.getLocation(): TLGeoPoint? = when (this) {
    is TLMessageMediaGeo -> geo as TLGeoPoint
    else -> null
}

fun TLMessageMediaGeo.getLocation(): TLGeoPoint? = when (geo) {
    is TLGeoPoint -> geo as TLGeoPoint
    else -> null
}

fun TLAbsMessageMedia.getAbsMediaInput() = when (this) {
    is TLMessageMediaAudio -> getMediaInput()
    is TLMessageMediaContact -> null // nothing to download
    is TLMessageMediaDocument -> getMediaInput()
    is TLMessageMediaEmpty -> null // nothing to download
    is TLMessageMediaGeo -> null // nothing to download
    is TLMessageMediaPhoto -> getMediaInput()
    is TLMessageMediaUnsupported -> null // nothing to download
    is TLMessageMediaVenue -> null // nothing to download
    is TLMessageMediaVideo -> getMediaInput()
    is TLMessageMediaWebPage -> null // nothing to download
    else -> null
}

fun TLMessageMediaDocument.getMediaInput() = when (document) {
    is TLDocument -> {
        val document = document as TLDocument
        MediaInput(TLInputDocumentFileLocation(document.id, (document.accessHash)), document.size, document.mimeType, document.dcId)
    }
    else -> null
}

fun TLMessageMediaAudio.getMediaInput() = when (audio) {
    is TLAudio -> {
        val audio = audio as TLAudio
        MediaInput(TLInputAudioFileLocation(audio.id, audio.accessHash), audio.size, audio.mimeType, audio.dcId)
    }
    else -> null
}

fun TLMessageMediaVideo.getMediaInput() = when (video) {
    is TLVideo -> {
        val video = video as TLVideo
        MediaInput(TLInputVideoFileLocation(video.id, video.accessHash), video.size, video.mimeType, video.dcId)
    }
    else -> null
}

fun TLMessageMediaPhoto.getMediaInput() = when (photo) {
    is TLPhoto -> {
        val photo = photo as TLPhoto
        val photoSize = photo.sizes.filterIsInstance<TLPhotoSize>().maxBy { it.w * it.h } // Biggest
        if (photoSize != null) {
            val location = photoSize.location
            if (location is TLFileLocation) {
                TLInputFileLocation(location.volumeId, location.localId, location.secret)
                MediaInput(TLInputDocumentFileLocation(photo.id, photo.accessHash), photoSize.size, "image/jpeg", location.dcId)
            } else null
        } else null
    }
    else -> null
}


data class MediaInput(val inputFileLocation: TLAbsInputFileLocation, val size: Int, val mimeType: String, val dcId: Int)