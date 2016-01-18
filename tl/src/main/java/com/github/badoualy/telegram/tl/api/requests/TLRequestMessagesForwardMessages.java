
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLRequestMessagesForwardMessages extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages> {

    public static final int CLASS_ID = 0x514cd10f;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesForwardMessages(        com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         com.github.badoualy.telegram.tl.core.TLIntVector _id) {
        this.peer = _peer;
        this.id = _id;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessages, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer;

    protected com.github.badoualy.telegram.tl.core.TLIntVector id;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public com.github.badoualy.telegram.tl.core.TLIntVector getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.core.TLIntVector value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLVector(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.id = readTLIntVector(stream, context);
    }



    @Override
    public String toString() {
        return "messages.forwardMessages#514cd10f";
    }

}
