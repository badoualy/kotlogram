package com.github.badoualy.telegram.sample

import com.github.badoualy.telegram.api.Kotlogram
import com.github.badoualy.telegram.api.utils.id
import com.github.badoualy.telegram.api.utils.title
import com.github.badoualy.telegram.sample.config.Config
import com.github.badoualy.telegram.sample.config.FileApiStorage
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty
import com.github.badoualy.telegram.tl.api.TLMessage
import com.github.badoualy.telegram.tl.api.TLMessageService
import com.github.badoualy.telegram.tl.api.TLUser
import com.github.badoualy.telegram.tl.exception.RpcErrorException
import java.io.IOException

object GetDialogsSample {

    @JvmStatic fun main(args: Array<String>) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        val client = Kotlogram.getDefaultClient(Config.application, FileApiStorage())

        // Number of recent conversation you want to get
        // (Telegram has an internal max, your value will be capped)
        val count = 10

        // You can start making requests
        try {
            val tlAbsDialogs = client.messagesGetDialogs(true, 0, 0, TLInputPeerEmpty(), count)

            // Create a map of id to name map
            val nameMap = HashMap<Int, String>()
            tlAbsDialogs.users.filterIsInstance<TLUser>()
                    .map { Pair(it.id, "${it.firstName} ${it.lastName}") }
                    .toMap(nameMap)
            tlAbsDialogs.chats.map { Pair(it.id, it.title ?: "") }.toMap(nameMap)

            val messageMap = tlAbsDialogs.messages.map { Pair(it.id, it) }.toMap()

            tlAbsDialogs.dialogs.forEach { dialog ->
                val topMessage = messageMap[dialog.topMessage]!!
                val topMessageContent =
                        if (topMessage is TLMessage) topMessage.message
                        else if (topMessage is TLMessageService) "Service: ${topMessage.action}"
                        else "Empty message (TLMessageEmpty)"

                println("${nameMap[dialog.peer.id]}: $topMessageContent")
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