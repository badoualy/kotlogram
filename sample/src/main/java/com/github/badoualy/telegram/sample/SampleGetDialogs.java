package com.github.badoualy.telegram.sample;

import com.github.badoualy.telegram.api.Kotlogram;
import com.github.badoualy.telegram.api.TelegramClient;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsMessageAction;
import com.github.badoualy.telegram.tl.api.TLAbsPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLChannel;
import com.github.badoualy.telegram.tl.api.TLChannelForbidden;
import com.github.badoualy.telegram.tl.api.TLChat;
import com.github.badoualy.telegram.tl.api.TLChatEmpty;
import com.github.badoualy.telegram.tl.api.TLChatForbidden;
import com.github.badoualy.telegram.tl.api.TLInputPeerEmpty;
import com.github.badoualy.telegram.tl.api.TLMessage;
import com.github.badoualy.telegram.tl.api.TLMessageService;
import com.github.badoualy.telegram.tl.api.TLPeerChannel;
import com.github.badoualy.telegram.tl.api.TLPeerChat;
import com.github.badoualy.telegram.tl.api.TLPeerUser;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
import com.github.badoualy.telegram.tl.exception.RpcErrorException;

import java.io.IOException;
import java.util.HashMap;

import static com.github.badoualy.telegram.sample.C.ApiStorage;
import static com.github.badoualy.telegram.sample.C.application;

/**
 * This snippet will get the 10 most recent conversations and display the title + the latest message
 */
public class SampleGetDialogs {

    public static void main(String[] args) {
        // This is a synchronous client, that will block until the response arrive (or until timeout)
        TelegramClient client = Kotlogram.getDefaultClient(application, new ApiStorage());

        // Number of recent conversation you want to get (Telegram has an internal max, your value will be capped)
        int count = 10;

        // You can start making requests
        try {
            TLAbsDialogs tlAbsDialogs = client.messagesGetDialogs(0, 0, new TLInputPeerEmpty(), count);

            // Map peer id to displayable string
            HashMap<Integer, String> nameMap = createNameMap(tlAbsDialogs);

            // Map message id to message
            HashMap<Integer, TLAbsMessage> messageMap = new HashMap<>();
            tlAbsDialogs.getMessages().forEach(message -> messageMap.put(message.getId(), message));

            tlAbsDialogs.getDialogs().forEach(dialog -> {
                System.out.print(nameMap.get(getId(dialog.getPeer())) + ": ");
                TLAbsMessage topMessage = messageMap.get(dialog.getTopMessage());
                if (topMessage instanceof TLMessage) {
                    // The message could also be a file, a photo, a gif, ...
                    System.out.println(((TLMessage) topMessage).getMessage());
                } else if (topMessage instanceof TLMessageService) {
                    TLAbsMessageAction action = ((TLMessageService) topMessage).getAction();
                    // action defined the type of message (user joined group, ...)
                    System.out.println("Service message");
                }
            });
        } catch (RpcErrorException | IOException e) {
            e.printStackTrace();
        } finally {
            client.close(); // Important, do not forget this, or your process won't finish
        }
    }

    /**
     * @param tlAbsDialogs result from messagesGetDialogs
     * @return a map where the key is the peerId and the value is the chat/channel title or the user's name
     */
    public static HashMap<Integer, String> createNameMap(TLAbsDialogs tlAbsDialogs) {
        // Map peer id to name
        HashMap<Integer, String> nameMap = new HashMap<>();

        tlAbsDialogs.getUsers().stream()
                    .map(TLAbsUser::getAsUser)
                    .forEach(user -> nameMap.put(user.getId(),
                                                 user.getFirstName() + " " + user.getLastName()));

        tlAbsDialogs.getChats().stream()
                    .forEach(chat -> {
                        if (chat instanceof TLChannel) {
                            nameMap.put(chat.getId(), ((TLChannel) chat).getTitle());
                        } else if (chat instanceof TLChannelForbidden) {
                            nameMap.put(chat.getId(), ((TLChannelForbidden) chat).getTitle());
                        } else if (chat instanceof TLChat) {
                            nameMap.put(chat.getId(), ((TLChat) chat).getTitle());
                        } else if (chat instanceof TLChatEmpty) {
                            nameMap.put(chat.getId(), "Empty chat");
                        } else if (chat instanceof TLChatForbidden) {
                            nameMap.put(chat.getId(), ((TLChatForbidden) chat).getTitle());
                        }
                    });

        return nameMap;
    }

    public static int getId(TLAbsPeer peer) {
        if (peer instanceof TLPeerUser)
            return ((TLPeerUser) peer).getUserId();
        if (peer instanceof TLPeerChat)
            return ((TLPeerChat) peer).getChatId();

        return ((TLPeerChannel) peer).getChannelId();
    }
}
