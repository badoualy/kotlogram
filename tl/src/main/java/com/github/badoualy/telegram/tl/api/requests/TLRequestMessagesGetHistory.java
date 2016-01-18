
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestMessagesGetHistory extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsMessages> {

    public static final int CLASS_ID = 0x92a1df2f;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetHistory(        com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         int _offset,         int _maxId,         int _limit) {
        this.peer = _peer;
        this.offset = _offset;
        this.maxId = _maxId;
        this.limit = _limit;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsMessages deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsMessages) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsMessages)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsMessages, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer;

    protected int offset;

    protected int maxId;

    protected int limit;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeInt(this.offset, stream);
        writeInt(this.maxId, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.offset = readInt(stream);
        this.maxId = readInt(stream);
        this.limit = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.getHistory#92a1df2f";
    }

}
