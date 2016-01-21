
package com.github.badoualy.telegram.tl.api.updates;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLChannelDifferenceTooLong extends TLAbsChannelDifference {
    public static final int CLASS_ID = 0x5e167646;

    public TLChannelDifferenceTooLong() {

    }


    public TLChannelDifferenceTooLong(        int _flags,         boolean _fina,         int _pts,         int _timeout,         int _topMessage,         int _topImportantMessage,         int _readInboxMaxId,         int _unreadCount,         int _unreadImportantCount,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> _messages,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> _chats,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users) {
        this.flags = _flags;
        this.fina = _fina;
        this.pts = _pts;
        this.timeout = _timeout;
        this.topMessage = _topMessage;
        this.topImportantMessage = _topImportantMessage;
        this.readInboxMaxId = _readInboxMaxId;
        this.unreadCount = _unreadCount;
        this.unreadImportantCount = _unreadImportantCount;
        this.messages = _messages;
        this.chats = _chats;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int topMessage;

    protected int topImportantMessage;

    protected int readInboxMaxId;

    protected int unreadCount;

    protected int unreadImportantCount;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> messages;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> chats;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> users;


    public int getTopMessage() {
        return topMessage;
    }

    public void setTopMessage(int value) {
        this.topMessage = value;
    }

    public int getTopImportantMessage() {
        return topImportantMessage;
    }

    public void setTopImportantMessage(int value) {
        this.topImportantMessage = value;
    }

    public int getReadInboxMaxId() {
        return readInboxMaxId;
    }

    public void setReadInboxMaxId(int value) {
        this.readInboxMaxId = value;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int value) {
        this.unreadCount = value;
    }

    public int getUnreadImportantCount() {
        return unreadImportantCount;
    }

    public void setUnreadImportantCount(int value) {
        this.unreadImportantCount = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> getMessages() {
        return messages;
    }

    public void setMessages(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> value) {
        this.messages = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> value) {
        this.chats = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = fina ? (flags | 1) : (flags &~ 1);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.fina, stream);
        writeInt(this.pts, stream);
        if ((this.flags & 2) != 0)
            writeInt(this.timeout, stream);
        writeInt(this.topMessage, stream);
        writeInt(this.topImportantMessage, stream);
        writeInt(this.readInboxMaxId, stream);
        writeInt(this.unreadCount, stream);
        writeInt(this.unreadImportantCount, stream);
        writeTLVector(this.messages, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.fina = (this.flags & 1) != 0;
        this.pts = readInt(stream);
        if ((this.flags & 2) != 0)
            this.timeout = readInt(stream);
        this.topMessage = readInt(stream);
        this.topImportantMessage = readInt(stream);
        this.readInboxMaxId = readInt(stream);
        this.unreadCount = readInt(stream);
        this.unreadImportantCount = readInt(stream);
        this.messages = readTLVector(stream, context);
        this.chats = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "updates.channelDifferenceTooLong#5e167646";
    }

}
