
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLRequestMessagesGetMessagesViews extends TLMethod<com.github.badoualy.telegram.tl.core.TLIntVector> {

    public static final int CLASS_ID = 0xc4c8a55d;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetMessagesViews(        com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         com.github.badoualy.telegram.tl.core.TLIntVector _id,         boolean _increment) {
        this.peer = _peer;
        this.id = _id;
        this.increment = _increment;

    }



    public com.github.badoualy.telegram.tl.core.TLIntVector deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return readTLIntVector(stream, context);

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer;

    protected com.github.badoualy.telegram.tl.core.TLIntVector id;

    protected boolean increment;


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

    public boolean getIncrement() {
        return increment;
    }

    public void setIncrement(boolean value) {
        this.increment = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLVector(this.id, stream);
        writeTLBool(this.increment, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.id = readTLIntVector(stream, context);
        this.increment = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "messages.getMessagesViews#c4c8a55d";
    }

}
