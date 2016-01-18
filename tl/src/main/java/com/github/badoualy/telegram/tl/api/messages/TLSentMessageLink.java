
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLSentMessageLink extends TLAbsSentMessage {
    public static final int CLASS_ID = 0xe9db4a3f;

    public TLSentMessageLink() {

    }


    public TLSentMessageLink(        int _id,         int _date,         int _pts,         int _seq,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.contacts.TLLink> _links) {
        this.id = _id;
        this.date = _date;
        this.pts = _pts;
        this.seq = _seq;
        this.links = _links;

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

        writeInt(this.id, stream);
        writeInt(this.date, stream);
        writeInt(this.pts, stream);
        writeInt(this.seq, stream);
        writeTLVector(this.links, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.date = readInt(stream);
        this.pts = readInt(stream);
        this.seq = readInt(stream);
        this.links = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "messages.sentMessageLink#e9db4a3f";
    }

}
