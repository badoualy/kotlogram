package com.github.badoualy.telegram.sample;

import com.github.badoualy.telegram.api.Kotlogram;
import com.github.badoualy.telegram.api.TelegramClient;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty;
import com.github.badoualy.telegram.tl.api.TLStickerSet;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
import com.github.badoualy.telegram.tl.api.messages.TLAllStickers;
import com.github.badoualy.telegram.tl.exception.RpcErrorException;

import java.io.IOException;

import static com.github.badoualy.telegram.sample.C.ApiStorage;
import static com.github.badoualy.telegram.sample.C.application;
import static com.github.badoualy.telegram.sample.SampleGetHistory.getInputPeer;

/**
 * This snippet will get the most recent conversation and send a sticker in this conversation.
 */
public class SampleSendSticker {

    public static void main(String[] args) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        TelegramClient client = Kotlogram.getDefaultClient(application, new ApiStorage());

        // You can start making requests
        try {
            TLAbsDialogs tlAbsDialogs = client.messagesGetDialogs(0, 0, new TLInputPeerEmpty(), 1);
            TLAbsInputPeer inputPeer = getInputPeer(tlAbsDialogs);

            TLAllStickers tlAllStickers = (TLAllStickers) client.messagesGetAllStickers(0);
            TLStickerSet tlStickerSet = tlAllStickers.getSets().get(0);
            // TODO fix, please!
            /*if (!tlStickers.getStickers().isEmpty()) {
                // Take first available one
                TLDocument tlDocument = tlStickers.getStickers().get(0).getAsDocument();
                TLInputDocument tlInputDocument = new TLInputDocument(tlDocument.getId(), tlDocument.getAccessHash());

                TLAbsUpdates tlAbsUpdates = client.messagesSendMedia(false, false, false,
                                                                     inputPeer, null, new TLInputMediaDocument(tlInputDocument, ""),
                                                                     Math.abs(new Random().nextLong()), null);
                // tlAbsUpdates contains the id and date of the message in a TLUpdateShortSentMessage
            } else {
                System.err.println("No sticker found");
            }*/
        } catch (RpcErrorException | IOException e) {
            e.printStackTrace();
        } finally {
            client.close(); // Important, do not forget this, or your process won't finish
        }
    }

}
