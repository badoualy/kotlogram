package com.github.badoualy.telegram.tl.api.updates;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelDifferenceTooLong extends TLAbsChannelDifference {
    public static final int CONSTRUCTOR_ID = 0x5e167646;

    protected int topMessage;

    protected int topImportantMessage;

    protected int readInboxMaxId;

    protected int unreadCount;

    protected int unreadImportantCount;

    protected TLVector<TLAbsMessage> messages;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    private final String _constructor = "updates.channelDifferenceTooLong#5e167646";

    public TLChannelDifferenceTooLong() {
    }

    public TLChannelDifferenceTooLong(boolean _final, int pts, Integer timeout, int topMessage, int topImportantMessage, int readInboxMaxId, int unreadCount, int unreadImportantCount, TLVector<TLAbsMessage> messages, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users) {
        this._final = _final;
        this.pts = pts;
        this.timeout = timeout;
        this.topMessage = topMessage;
        this.topImportantMessage = topImportantMessage;
        this.readInboxMaxId = readInboxMaxId;
        this.unreadCount = unreadCount;
        this.unreadImportantCount = unreadImportantCount;
        this.messages = messages;
        this.chats = chats;
        this.users = users;
    }

    private void computeFlags() {
        flags = 0;
        flags = _final ? (flags | 1) : (flags &~ 1);
        flags = timeout != null ? (flags | 2) : (flags &~ 2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(pts, stream);
        if ((flags & 2) != 0) writeInt(timeout, stream);
        writeInt(topMessage, stream);
        writeInt(topImportantMessage, stream);
        writeInt(readInboxMaxId, stream);
        writeInt(unreadCount, stream);
        writeInt(unreadImportantCount, stream);
        writeTLVector(messages, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        _final = (flags & 1) != 0;
        pts = readInt(stream);
        timeout = (flags & 2) != 0 ? readInt(stream) : null;
        topMessage = readInt(stream);
        topImportantMessage = readInt(stream);
        readInboxMaxId = readInt(stream);
        unreadCount = readInt(stream);
        unreadImportantCount = readInt(stream);
        messages = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 2) != 0) size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += messages.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLChannelDifferenceTooLong)) return false;
        if (object == this) return true;

        TLChannelDifferenceTooLong o = (TLChannelDifferenceTooLong) object;

        return flags == o.flags
                && _final == o._final
                && pts == o.pts
                && (timeout == o.timeout || (timeout != null && o.timeout != null && timeout.equals(o.timeout)))
                && topMessage == o.topMessage
                && topImportantMessage == o.topImportantMessage
                && readInboxMaxId == o.readInboxMaxId
                && unreadCount == o.unreadCount
                && unreadImportantCount == o.unreadImportantCount
                && (messages == o.messages || (messages != null && o.messages != null && messages.equals(o.messages)))
                && (chats == o.chats || (chats != null && o.chats != null && chats.equals(o.chats)))
                && (users == o.users || (users != null && o.users != null && users.equals(o.users)));
    }

    public boolean getFinal() {
        return _final;
    }

    public void setFinal(boolean _final) {
        this._final = _final;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public Integer getTimeout() {
        return timeout;
    }

    public void setTimeout(Integer timeout) {
        this.timeout = timeout;
    }

    public int getTopMessage() {
        return topMessage;
    }

    public void setTopMessage(int topMessage) {
        this.topMessage = topMessage;
    }

    public int getTopImportantMessage() {
        return topImportantMessage;
    }

    public void setTopImportantMessage(int topImportantMessage) {
        this.topImportantMessage = topImportantMessage;
    }

    public int getReadInboxMaxId() {
        return readInboxMaxId;
    }

    public void setReadInboxMaxId(int readInboxMaxId) {
        this.readInboxMaxId = readInboxMaxId;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public int getUnreadImportantCount() {
        return unreadImportantCount;
    }

    public void setUnreadImportantCount(int unreadImportantCount) {
        this.unreadImportantCount = unreadImportantCount;
    }

    public TLVector<TLAbsMessage> getMessages() {
        return messages;
    }

    public void setMessages(TLVector<TLAbsMessage> messages) {
        this.messages = messages;
    }

    public TLVector<TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
