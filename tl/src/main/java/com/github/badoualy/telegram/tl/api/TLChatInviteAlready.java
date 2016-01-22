package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatInviteAlready extends TLAbsChatInvite {
    public static final int CLASS_ID = 0x5a686d7c;

    protected TLAbsChat chat;

    public TLChatInviteAlready() {
    }

    public TLChatInviteAlready(TLAbsChat chat) {
        this.chat = chat;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(chat, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chat = (com.github.badoualy.telegram.tl.api.TLAbsChat) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "chatInviteAlready#5a686d7c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsChat getChat() {
        return chat;
    }

    public void setChat(TLAbsChat chat) {
        this.chat = chat;
    }
}
