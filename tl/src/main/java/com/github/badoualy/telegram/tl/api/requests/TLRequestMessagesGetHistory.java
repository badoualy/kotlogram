
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

    public static final int CLASS_ID = 0x8a8ec2da;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetHistory(        com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         int _offsetId,         int _addOffset,         int _limit,         int _maxId,         int _minId) {
        this.peer = _peer;
        this.offsetId = _offsetId;
        this.addOffset = _addOffset;
        this.limit = _limit;
        this.maxId = _maxId;
        this.minId = _minId;

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

    protected int offsetId;

    protected int addOffset;

    protected int limit;

    protected int maxId;

    protected int minId;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public int getOffsetId() {
        return offsetId;
    }

    public void setOffsetId(int value) {
        this.offsetId = value;
    }

    public int getAddOffset() {
        return addOffset;
    }

    public void setAddOffset(int value) {
        this.addOffset = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
    }

    public int getMinId() {
        return minId;
    }

    public void setMinId(int value) {
        this.minId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeInt(this.offsetId, stream);
        writeInt(this.addOffset, stream);
        writeInt(this.limit, stream);
        writeInt(this.maxId, stream);
        writeInt(this.minId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.offsetId = readInt(stream);
        this.addOffset = readInt(stream);
        this.limit = readInt(stream);
        this.maxId = readInt(stream);
        this.minId = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.getHistory#8a8ec2da";
    }

}
