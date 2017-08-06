package com.github.badoualy.telegram.sample

import com.github.badoualy.telegram.api.Kotlogram
import com.github.badoualy.telegram.api.utils.id
import com.github.badoualy.telegram.api.utils.toInputPeer
import com.github.badoualy.telegram.sample.config.Config
import com.github.badoualy.telegram.sample.config.FileApiStorage
import com.github.badoualy.telegram.tl.api.*
import com.github.badoualy.telegram.tl.core.TLObject
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException

object GetHistorySample {

    @JvmStatic fun main(args: Array<String>) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        val client = Kotlogram.getDefaultClient(Config.application, FileApiStorage())

        // How many messages we want to get (same than dialogs, there is a cap)
        // (Telegram has an internal max, your value will be capped)
        val count = 10

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

            val tlAbsMessages = client.messagesGetHistory(inputPeer, 0, 0, 0, count, 0, 0)
            // Note: first message in the list is most recent
            tlAbsMessages.messages.reversed().forEach {
                val messageContent =
                        if (it is TLMessage) it.message
                        else if (it is TLMessageService) "Service: ${it.action}"
                        else "Empty message (TLMessageEmpty)"
                println(messageContent)
            }
        } catch (e: RpcErrorException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            client.close() // Important, do not forget this, or your process won't finish
        }
    }

}