package com.github.badoualy.telegram.sample;

import com.github.badoualy.telegram.api.Kotlogram;
import com.github.badoualy.telegram.api.TelegramClient;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.api.TLDocument;
import com.github.badoualy.telegram.tl.api.TLInputDocument;
import com.github.badoualy.telegram.tl.api.TLInputMediaDocument;
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
import com.github.badoualy.telegram.tl.api.messages.TLStickers;
import com.github.badoualy.telegram.tl.exception.RpcErrorException;

import java.io.IOException;
import java.util.Random;

import static com.github.badoualy.telegram.sample.C.ApiStorage;
import static com.github.badoualy.telegram.sample.C.application;
import static com.github.badoualy.telegram.sample.SampleGetHistory.getInputPeer;

/**
 * This snippet will get the most recent conversation and send a sticker in thie conversation.
 */
public class SampleSendSticker {

    public static void main(String[] args) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        // A client which return an Observable<T> where T is the response type will be available soon
        TelegramClient client = Kotlogram.getDefaultClient(application, new ApiStorage());

        // You can start making requests
        try {
            TLAbsDialogs tlAbsDialogs = client.messagesGetDialogs(0, 0, new TLInputPeerEmpty(), 1);
            TLAbsInputPeer inputPeer = getInputPeer(tlAbsDialogs);

            // Get the stickers available for emoji sunglass
            TLStickers tlStickers = (TLStickers) client.messagesGetStickers("\uD83D\uDE0E", "");
            if (!tlStickers.getStickers().isEmpty()) {
                // Take first available one
                TLDocument tlDocument = tlStickers.getStickers().get(0).getAsDocument();
                TLInputDocument tlInputDocument = new TLInputDocument(tlDocument.getId(), tlDocument.getAccessHash());

                TLAbsUpdates tlAbsUpdates = client.messagesSendMedia(false, false, false,
                                                                     inputPeer, null, new TLInputMediaDocument(tlInputDocument, ""),
                                                                     Math.abs(new Random().nextLong()), null);
                // tlAbsUpdates contains the id and date of the message in a TLUpdateShortSentMessage
            } else {
                System.err.println("No sticker found");
            }
        } catch (RpcErrorException | IOException e) {
            e.printStackTrace();
        } finally {
            client.close(); // Important, do not forget this, or your process won't finish
        }
    }

}
