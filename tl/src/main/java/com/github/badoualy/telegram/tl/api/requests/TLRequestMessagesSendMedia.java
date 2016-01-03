
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesSendMedia extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> {

    public static final int CLASS_ID = 0xa3c85d76;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSendMedia(        com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         com.github.badoualy.telegram.tl.api.TLAbsInputMedia _media,         long _randomId) {
        this.peer = _peer;
        this.media = _media;
        this.randomId = _randomId;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputMedia media;

    protected long randomId;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputMedia getMedia() {
        return media;
    }

    public void setMedia(com.github.badoualy.telegram.tl.api.TLAbsInputMedia value) {
        this.media = value;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long value) {
        this.randomId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLObject(this.media, stream);
        writeLong(this.randomId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.media = (com.github.badoualy.telegram.tl.api.TLAbsInputMedia)readTLObject(stream, context);
        this.randomId = readLong(stream);
    }



    @Override
    public String toString() {
        return "messages.sendMedia#a3c85d76";
    }

}
