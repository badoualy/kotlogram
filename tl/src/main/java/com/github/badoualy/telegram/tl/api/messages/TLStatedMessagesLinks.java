
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLStatedMessagesLinks extends TLAbsStatedMessages {
    public static final int CLASS_ID = 0x3e74f5c6;

    public TLStatedMessagesLinks() {

    }


    public TLStatedMessagesLinks(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> _messages,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> _chats,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.contacts.TLLink> _links,         int _pts,         int _seq) {
        this.messages = _messages;
        this.chats = _chats;
        this.users = _users;
        this.links = _links;
        this.pts = _pts;
        this.seq = _seq;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.contacts.TLLink> links;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.contacts.TLLink> getLinks() {
        return links;
    }

    public void setLinks(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.contacts.TLLink> value) {
        this.links = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.messages, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
        writeTLVector(this.links, stream);
        writeInt(this.pts, stream);
        writeInt(this.seq, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.messages = readTLVector(stream, context);
        this.chats = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
        this.links = readTLVector(stream, context);
        this.pts = readInt(stream);
        this.seq = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.statedMessagesLinks#3e74f5c6";
    }

}
