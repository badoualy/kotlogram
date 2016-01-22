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
public class TLUpdateChatUserTyping extends TLAbsUpdate {
    public static final int CLASS_ID = 0x9a65ea1f;

    protected int chatId;

    protected int userId;

    protected TLAbsSendMessageAction action;

    public TLUpdateChatUserTyping() {
    }

    public TLUpdateChatUserTyping(int chatId, int userId, TLAbsSendMessageAction action) {
        this.chatId = chatId;
        this.userId = userId;
        this.action = action;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(chatId, stream);
        writeInt(userId, stream);
        writeTLObject(action, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        chatId = readInt(stream);
        userId = readInt(stream);
        action = (com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "updateChatUserTyping#9a65ea1f";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public TLAbsSendMessageAction getAction() {
        return action;
    }

    public void setAction(TLAbsSendMessageAction action) {
        this.action = action;
    }
}
