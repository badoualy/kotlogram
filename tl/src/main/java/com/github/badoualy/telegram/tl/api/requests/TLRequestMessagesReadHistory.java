
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestMessagesReadHistory extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory> {

    public static final int CLASS_ID = 0xeed884c6;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesReadHistory(        com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         int _maxId,         int _offset,         boolean _readContents) {
        this.peer = _peer;
        this.maxId = _maxId;
        this.offset = _offset;
        this.readContents = _readContents;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAffectedHistory, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer;

    protected int maxId;

    protected int offset;

    protected boolean readContents;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }

    public boolean getReadContents() {
        return readContents;
    }

    public void setReadContents(boolean value) {
        this.readContents = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeInt(this.maxId, stream);
        writeInt(this.offset, stream);
        writeTLBool(this.readContents, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.maxId = readInt(stream);
        this.offset = readInt(stream);
        this.readContents = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "messages.readHistory#eed884c6";
    }

}
