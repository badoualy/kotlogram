package com.github.badoualy.telegram.sample

import com.github.badoualy.telegram.api.Kotlogram
import com.github.badoualy.telegram.api.utils.id
import com.github.badoualy.telegram.api.utils.toInputDocument
import com.github.badoualy.telegram.api.utils.toInputPeer
import com.github.badoualy.telegram.mtproto.secure.RandomUtils
import com.github.badoualy.telegram.sample.config.Config
import com.github.badoualy.telegram.sample.config.FileApiStorage
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.api.messages.TLAllStickers
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException

object SendStickerSample {

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

            // Retrieve inputPeer to send sticker to
            val inputPeer = when (tlPeerObj) {
                is TLUser -> tlPeerObj.toInputPeer()
                is TLAbsChat -> tlPeerObj.toInputPeer()
                else -> null
            } ?: TLInputPeerEmpty()

            val tlAllStickers = client.messagesGetAllStickers(0) as TLAllStickers
            val tlStickerSet = tlAllStickers.sets.firstOrNull { it.count > 0 } ?:
                    throw RuntimeException("Found no stickers")

            println("Using sticker set: ${tlStickerSet.title}")
            // We have 2 different classes called TLStickerSet, one in message subpackage
            val set = client.messagesGetStickerSet(TLInputStickerSetID(tlStickerSet.id,
                                                                       tlStickerSet.accessHash))

            if (set.documents.isNotEmpty()) {
                val tlInputDocument = set.documents.first().toInputDocument()
                val tlInputMediaDocument = TLInputMediaDocument(tlInputDocument, "")

                val tlAbsUpdates = client.messagesSendMedia(false, false, false,
                                                            inputPeer, null,
                                                            tlInputMediaDocument,
                                                            RandomUtils.randomLong(), null)
                // tlAbsUpdates contains the id and date of the message in a TLUpdateShortSentMessage
            } else throw RuntimeException("No sticker found in set")
        } catch (e: RpcErrorException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            client.close() // Important, do not forget this, or your process won't finish
        }
    }

}