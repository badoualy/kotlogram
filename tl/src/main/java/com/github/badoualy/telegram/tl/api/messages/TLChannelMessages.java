
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLChannelMessages extends TLAbsMessages {
    public static final int CLASS_ID = 0xbc0f17bc;

    public TLChannelMessages() {

    }


    public TLChannelMessages(        int _flags,         int _pts,         int _count,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> _messages,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLMessageGroup> _collapsed,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> _chats,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users) {
        this.flags = _flags;
        this.pts = _pts;
        this.count = _count;
        this.messages = _messages;
        this.collapsed = _collapsed;
        this.chats = _chats;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected int pts;

    protected int count;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLMessageGroup> collapsed;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLMessageGroup> getCollapsed() {
        return collapsed;
    }

    public void setCollapsed(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLMessageGroup> value) {
        this.collapsed = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.flags, stream);
        writeInt(this.pts, stream);
        writeInt(this.count, stream);
        writeTLVector(this.messages, stream);
        if ((this.flags & 1) != 0)
            writeTLVector(this.collapsed, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.pts = readInt(stream);
        this.count = readInt(stream);
        this.messages = readTLVector(stream, context);
        if ((this.flags & 1) != 0)
            this.collapsed = readTLVector(stream, context);
        this.chats = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "messages.channelMessages#bc0f17bc";
    }

}
