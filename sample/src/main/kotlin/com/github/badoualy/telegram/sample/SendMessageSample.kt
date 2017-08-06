package com.github.badoualy.telegram.sample

import com.github.badoualy.telegram.api.Kotlogram
import com.github.badoualy.telegram.api.utils.id
import com.github.badoualy.telegram.api.utils.toInputPeer
import com.github.badoualy.telegram.mtproto.secure.RandomUtils
import com.github.badoualy.telegram.sample.config.Config
import com.github.badoualy.telegram.sample.config.FileApiStorage
import com.github.badoualy.telegram.tl.api.TLAbsChat
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLPeerUser
import com.github.badoualy.telegram.tl.api.TLUser
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException

object SendMessageSample {

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

            // Retrieve inputPeer to send message to
            val inputPeer = when (tlPeerObj) {
                is TLUser -> tlPeerObj.toInputPeer()
                is TLAbsChat -> tlPeerObj.toInputPeer()
                else -> null
            } ?: TLInputPeerEmpty()

            val tlAbsUpdates = client.messagesSendMessage(inputPeer,
                                                          "Sent from Kotlogram :)",
                                                          RandomUtils.randomLong())
            // tlAbsUpdates contains the id and date of the message in a TLUpdateShortSentMessage
        } catch (e: RpcErrorException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            client.close() // Important, do not forget this, or your process won't finish
        }
    }

}