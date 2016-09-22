package com.github.badoualy.telegram.sample;

import com.github.badoualy.telegram.api.Kotlogram;
import com.github.badoualy.telegram.api.TelegramClient;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
import com.github.badoualy.telegram.tl.exception.RpcErrorException;

import java.io.IOException;
import java.util.Random;

import static com.github.badoualy.telegram.sample.C.ApiStorage;
import static com.github.badoualy.telegram.sample.C.application;
import static com.github.badoualy.telegram.sample.SampleGetHistory.getInputPeer;

/**
 * This snippet will get the most recent conversation and send a message in this conversation.
 */
public class SampleSendMessage {

    public static void main(String[] args) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        // A client which return an Observable<T> where T is the response type will be available soon
        TelegramClient client = Kotlogram.getDefaultClient(application, new ApiStorage());

        // You can start making requests
        try {
            TLAbsDialogs tlAbsDialogs = client.messagesGetDialogs(0, 0, new TLInputPeerEmpty(), 1);
            TLAbsInputPeer inputPeer = getInputPeer(tlAbsDialogs);

            TLAbsUpdates tlAbsUpdates = client.messagesSendMessage(inputPeer, "Sent from Kotlogram :)", Math.abs(new Random().nextLong()));

            // tlAbsUpdates contains the id and date of the message in a TLUpdateShortSentMessage
        } catch (RpcErrorException | IOException e) {
            e.printStackTrace();
        } finally {
            client.close(); // Important, do not forget this, or your process won't finish
        }
    }

}
