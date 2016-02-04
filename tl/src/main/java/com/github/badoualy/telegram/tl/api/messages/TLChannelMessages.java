package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLMessageGroup;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelMessages extends TLAbsMessages {
    public static final int CONSTRUCTOR_ID = 0xbc0f17bc;

    protected int flags;

    protected int pts;

    protected int count;

    protected TLVector<TLMessageGroup> collapsed;

    public TLChannelMessages() {
    }

    public TLChannelMessages(int pts, int count, TLVector<? extends TLAbsMessage> messages, TLVector<TLMessageGroup> collapsed, TLVector<? extends TLAbsChat> chats, TLVector<? extends TLAbsUser> users) {
        this.pts = pts;
        this.count = count;
        this.messages = messages;
        this.collapsed = collapsed;
        this.chats = chats;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = collapsed != null ? (flags | 1) : (flags &~ 1);

        writeInt(flags, stream);
        writeInt(pts, stream);
        writeInt(count, stream);
        writeTLVector(messages, stream);
        if ((flags & 1) != 0) writeTLVector(collapsed, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        pts = readInt(stream);
        count = readInt(stream);
        messages = readTLVector(stream, context);
        if ((flags & 1) != 0) collapsed = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.channelMessages#bc0f17bc";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TLVector<? extends TLAbsMessage> getMessages() {
        return messages;
    }

    public void setMessages(TLVector<? extends TLAbsMessage> messages) {
        this.messages = messages;
    }

    public TLVector<TLMessageGroup> getCollapsed() {
        return collapsed;
    }

    public void setCollapsed(TLVector<TLMessageGroup> collapsed) {
        this.collapsed = collapsed;
    }

    public TLVector<? extends TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<? extends TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<? extends TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<? extends TLAbsUser> users) {
        this.users = users;
    }
}
