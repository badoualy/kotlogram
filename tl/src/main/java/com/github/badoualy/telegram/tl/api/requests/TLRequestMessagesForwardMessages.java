
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLRequestMessagesForwardMessages extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUpdates> {

    public static final int CLASS_ID = 0x708e0195;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesForwardMessages(        int _flags,         boolean _broadcast,         com.github.badoualy.telegram.tl.api.TLAbsInputPeer _fromPeer,         com.github.badoualy.telegram.tl.core.TLIntVector _id,         com.github.badoualy.telegram.tl.core.TLLongVector _randomId,         com.github.badoualy.telegram.tl.api.TLAbsInputPeer _toPeer) {
        this.flags = _flags;
        this.broadcast = _broadcast;
        this.fromPeer = _fromPeer;
        this.id = _id;
        this.randomId = _randomId;
        this.toPeer = _toPeer;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsUpdates) {
            return (com.github.badoualy.telegram.tl.api.TLAbsUpdates)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsUpdates, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int flags;

    protected boolean broadcast;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer fromPeer;

    protected com.github.badoualy.telegram.tl.core.TLIntVector id;

    protected com.github.badoualy.telegram.tl.core.TLLongVector randomId;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer toPeer;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean value) {
        this.broadcast = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getFromPeer() {
        return fromPeer;
    }

    public void setFromPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.fromPeer = value;
    }

    public com.github.badoualy.telegram.tl.core.TLIntVector getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.core.TLIntVector value) {
        this.id = value;
    }

    public com.github.badoualy.telegram.tl.core.TLLongVector getRandomId() {
        return randomId;
    }

    public void setRandomId(com.github.badoualy.telegram.tl.core.TLLongVector value) {
        this.randomId = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getToPeer() {
        return toPeer;
    }

    public void setToPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.toPeer = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = broadcast ? (flags | 16) : (flags &~ 16);
        writeInt(this.flags, stream);
        if ((this.flags & 16) != 0)
            writeTLBool(this.broadcast, stream);
        writeTLObject(this.fromPeer, stream);
        writeTLVector(this.id, stream);
        writeTLVector(this.randomId, stream);
        writeTLObject(this.toPeer, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.broadcast = (this.flags & 16) != 0;
        this.fromPeer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.id = readTLIntVector(stream, context);
        this.randomId = readTLLongVector(stream, context);
        this.toPeer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messages.forwardMessages#708e0195";
    }

}
