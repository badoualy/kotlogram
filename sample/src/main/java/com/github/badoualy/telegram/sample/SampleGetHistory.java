package com.github.badoualy.telegram.sample;

import com.github.badoualy.telegram.api.Kotlogram;
import com.github.badoualy.telegram.api.TelegramClient;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsPeer;
import com.github.badoualy.telegram.tl.api.TLChannel;
import com.github.badoualy.telegram.tl.api.TLChat;
import com.github.badoualy.telegram.tl.api.TLInputPeerChannel;
import com.github.badoualy.telegram.tl.api.TLInputPeerChat;
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty;
import com.github.badoualy.telegram.tl.api.TLInputPeerUser;
import com.github.badoualy.telegram.tl.api.TLMessage;
import com.github.badoualy.telegram.tl.api.TLPeerUser;
import com.github.badoualy.telegram.tl.api.TLUser;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.exception.RpcErrorException;

import java.io.IOException;

import static com.github.badoualy.telegram.sample.C.ApiStorage;
import static com.github.badoualy.telegram.sample.C.application;
import static com.github.badoualy.telegram.sample.SampleGetDialogs.getId;

/**
 * This snippet will get the most recent conversation and print the last 10 messages
 */
public class SampleGetHistory {

    public static void main(String[] args) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        TelegramClient client = Kotlogram.getDefaultClient(application, new ApiStorage());

        // How many messages we want to get (same than dialogs, there is a cap)
        int count = 10;

        // You can start making requests
        try {
            TLAbsDialogs tlAbsDialogs = client.messagesGetDialogs(0, 0, new TLInputPeerEmpty(), 1);
            TLAbsInputPeer inputPeer = getInputPeer(tlAbsDialogs);

            TLAbsMessages tlAbsMessages = client.messagesGetHistory(inputPeer, 0, 0, 0, count, 0, 0);
            tlAbsMessages.getMessages().forEach(message -> {
                if (message instanceof TLMessage)
                    System.out.println(((TLMessage) message).getMessage());
                else
                    System.out.println("Service message");
            });
        } catch (RpcErrorException | IOException e) {
            e.printStackTrace();
        } finally {
            client.close(); // Important, do not forget this, or your process won't finish
        }
    }

    /**
     * Get the first peer and return it as an InputPeer to use with methods
     */
    public static TLAbsInputPeer getInputPeer(TLAbsDialogs tlAbsDialogs) {
        TLAbsPeer tlAbsPeer = tlAbsDialogs.getDialogs().get(0).getPeer();
        int peerId = getId(tlAbsPeer);
        TLObject peer = tlAbsPeer instanceof TLPeerUser ?
                tlAbsDialogs.getUsers().stream().filter(user -> user.getId() == peerId).findFirst().get()
                : tlAbsDialogs.getChats().stream().filter(chat -> chat.getId() == peerId).findFirst().get();

        if (peer instanceof TLChannel)
            return new TLInputPeerChannel(((TLChannel) peer).getId(), ((TLChannel) peer).getAccessHash());
        if (peer instanceof TLChat)
            return new TLInputPeerChat(((TLChat) peer).getId());
        if (peer instanceof TLUser)
            return new TLInputPeerUser(((TLUser) peer).getId(), ((TLUser) peer).getAccessHash());

        return new TLInputPeerEmpty();
    }
}
