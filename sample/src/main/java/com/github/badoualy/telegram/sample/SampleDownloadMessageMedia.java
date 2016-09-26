package com.github.badoualy.telegram.sample;

import com.github.badoualy.telegram.api.Kotlogram;
import com.github.badoualy.telegram.api.TelegramClient;
import com.github.badoualy.telegram.api.utils.MediaInput;
import com.github.badoualy.telegram.api.utils.TLMediaUtilsKt;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsMessageMedia;
import com.github.badoualy.telegram.tl.api.TLDocument;
import com.github.badoualy.telegram.tl.api.TLDocumentAttributeFilename;
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty;
import com.github.badoualy.telegram.tl.api.TLMessage;
import com.github.badoualy.telegram.tl.api.TLMessageMediaDocument;
import com.github.badoualy.telegram.tl.api.TLMessageMediaPhoto;
import com.github.badoualy.telegram.tl.api.TLMessageMediaWebPage;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages;
import com.github.badoualy.telegram.tl.exception.RpcErrorException;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.github.badoualy.telegram.sample.C.ApiStorage;
import static com.github.badoualy.telegram.sample.C.ROOT_DIR;
import static com.github.badoualy.telegram.sample.C.application;
import static com.github.badoualy.telegram.sample.SampleGetHistory.getInputPeer;

/**
 * This snippet will get the most recent conversation and download the media attached with the message (if any)
 */
public class SampleDownloadMessageMedia {

    public static void main(String[] args) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        TelegramClient client = Kotlogram.getDefaultClient(application, new ApiStorage());

        // You can start making requests
        try {
            TLAbsDialogs tlAbsDialogs = client.messagesGetDialogs(0, 0, new TLInputPeerEmpty(), 1);
            TLAbsInputPeer inputPeer = getInputPeer(tlAbsDialogs);

            // Get most recent message
            TLAbsMessages tlAbsMessages = client.messagesGetHistory(inputPeer, 0, 0, 0, 1, 0, 0);
            TLAbsMessage tlAbsMessage = tlAbsMessages.getMessages().get(0);

            if (tlAbsMessage instanceof TLMessage && ((TLMessage) tlAbsMessage).getMedia() != null) {
                TLAbsMessageMedia media = ((TLMessage) tlAbsMessage).getMedia();

                // Magic utils method from api module
                MediaInput mediaInput = TLMediaUtilsKt.getAbsMediaInput(media);

                if (mediaInput != null) {
                    String filename;
                    if (media instanceof TLMessageMediaPhoto || media instanceof TLMessageMediaWebPage) {
                        filename = "photo.jpg";
                    } else {
                        // Retrieve real name
                        TLDocument tlDocument = ((TLMessageMediaDocument) media).getDocument().getAsDocument();
                        filename = ((TLDocumentAttributeFilename) tlDocument.getAttributes().stream()
                                                                            .filter(attr -> attr instanceof TLDocumentAttributeFilename)
                                                                            .findFirst().get()).getFileName();
                    }

                    FileOutputStream fos = new FileOutputStream(new File(ROOT_DIR, filename));
                    client.downloadSync(mediaInput.getInputFileLocation(), mediaInput.getSize(), fos);
                    // downloadSync closes the stream automatically
                } else {
                    System.err.println("MessageMedia type not supported" + media.getClass().getSimpleName());
                }
            } else {
                System.err.println("Latest message has no media attached");
            }
        } catch (RpcErrorException | IOException e) {
            e.printStackTrace();
        } finally {
            client.close(); // Important, do not forget this, or your process won't finish
        }
    }
}
