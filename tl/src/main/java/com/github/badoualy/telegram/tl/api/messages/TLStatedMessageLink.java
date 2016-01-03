
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLStatedMessageLink extends TLAbsStatedMessage {
    public static final int CLASS_ID = 0xa9af2881;

    public TLStatedMessageLink() {

    }


    public TLStatedMessageLink(        com.github.badoualy.telegram.tl.api.TLAbsMessage _message,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> _chats,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.contacts.TLLink> _links,         int _pts,         int _seq) {
        this.message = _message;
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

        writeTLObject(this.message, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
        writeTLVector(this.links, stream);
        writeInt(this.pts, stream);
        writeInt(this.seq, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.message = (com.github.badoualy.telegram.tl.api.TLAbsMessage)readTLObject(stream, context);
        this.chats = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
        this.links = readTLVector(stream, context);
        this.pts = readInt(stream);
        this.seq = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.statedMessageLink#a9af2881";
    }

}
