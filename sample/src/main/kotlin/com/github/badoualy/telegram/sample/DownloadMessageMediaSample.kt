package com.github.badoualy.telegram.sample

import com.github.badoualy.telegram.api.Kotlogram
import com.github.badoualy.telegram.api.utils.getAbsMediaInput
import com.github.badoualy.telegram.api.utils.id
import com.github.badoualy.telegram.api.utils.toInputPeer
import com.github.badoualy.telegram.sample.config.Config
import com.github.badoualy.telegram.sample.config.FileApiStorage
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

object DownloadMessageMediaSample {

    @JvmStatic fun main(args: Array<String>) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        val client = Kotlogram.getDefaultClient(Config.application, FileApiStorage())

        // You can start making requests
        try {
            val tlAbsDialogs = client.messagesGetDialogs(false, 0, 0, TLInputPeerEmpty(), 1)
            val tlAbsPeer = tlAbsDialogs.dialogs[0].peer
            val tlPeerObj: TLObject =
                    if (tlAbsPeer is TLPeerUser) tlAbsDialogs.users.first { it.id == tlAbsPeer.id }
                    else tlAbsDialogs.chats.first { it.id == tlAbsPeer.id }

            // Retrieve inputPeer to get message history
            val inputPeer = when (tlPeerObj) {
                is TLUser -> tlPeerObj.toInputPeer()
                is TLAbsChat -> tlPeerObj.toInputPeer()
                else -> null
            } ?: TLInputPeerEmpty()

            val tlAbsMessages = client.messagesGetHistory(inputPeer, 0, 0, 0, 100, 0, 0)
            val tlMessage = tlAbsMessages.messages.firstOrNull { it is TLMessage && it.media != null } as TLMessage?
                    ?: throw RuntimeException("Found no messages with media in last 100 messages")

            val tlAbsMedia = tlMessage.media
            val mediaInput = tlAbsMedia.getAbsMediaInput()
            if (mediaInput != null) {
                val fileName = when (tlAbsMedia) {
                    is TLMessageMediaPhoto, is TLMessageMediaWebPage -> "photo.jpg"
                    else -> {
                        // Get real file name
                        val tlDocument = (tlAbsMedia as? TLMessageMediaDocument)?.document?.asDocument
                        tlDocument?.attributes?.filterIsInstance<TLDocumentAttributeFilename>()
                                ?.firstOrNull()?.fileName ?: "file"
                    }
                }

                val fos = FileOutputStream(File(Config.ROOT_DIR, fileName))
                client.downloadSync(mediaInput.inputFileLocation, mediaInput.size, fos)
            } else println("Nothing to download for this media...")
        } catch (e: RpcErrorException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            client.close() // Important, do not forget this, or your process won't finish
        }
    }

}