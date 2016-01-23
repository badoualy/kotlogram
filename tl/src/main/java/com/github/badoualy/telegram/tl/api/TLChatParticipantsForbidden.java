package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatParticipantsForbidden extends TLAbsChatParticipants {
    public static final int CLASS_ID = 0xfc900c2b;

    protected int flags;

    protected TLAbsChatParticipant selfParticipant;

    public TLChatParticipantsForbidden() {
    }

    public TLChatParticipantsForbidden(int flags, int chatId, TLAbsChatParticipant selfParticipant) {
        this.flags = flags;
        this.chatId = chatId;
        this.selfParticipant = selfParticipant;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;

        writeInt(flags, stream);
        writeInt(chatId, stream);
        if ((flags & 1) != 0) writeTLObject(selfParticipant, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        chatId = readInt(stream);
        if ((flags & 1) != 0) selfParticipant = (com.github.badoualy.telegram.tl.api.TLAbsChatParticipant) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "chatParticipantsForbidden#fc900c2b";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
        this.chatId = chatId;
    }

    public TLAbsChatParticipant getSelfParticipant() {
        return selfParticipant;
    }

    public void setSelfParticipant(TLAbsChatParticipant selfParticipant) {
        this.selfParticipant = selfParticipant;
    }
}
