
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestMessagesSendInlineBotResult extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUpdates> {

    public static final int CLASS_ID = 0xb16e06fe;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSendInlineBotResult(        int _flags,         boolean _broadcast,         com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         int _replyToMsgId,         long _randomId,         long _queryId,         String _id) {
        this.flags = _flags;
        this.broadcast = _broadcast;
        this.peer = _peer;
        this.replyToMsgId = _replyToMsgId;
        this.randomId = _randomId;
        this.queryId = _queryId;
        this.id = _id;

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

    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer;

    protected int replyToMsgId;

    protected long randomId;

    protected long queryId;

    protected String id;


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

    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public int getReplyToMsgId() {
        return replyToMsgId;
    }

    public void setReplyToMsgId(int value) {
        this.replyToMsgId = value;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long value) {
        this.randomId = value;
    }

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long value) {
        this.queryId = value;
    }

    public String getId() {
        return id;
    }

    public void setId(String value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = broadcast ? (flags | 16) : (flags &~ 16);
        writeInt(this.flags, stream);
        if ((this.flags & 16) != 0)
            writeTLBool(this.broadcast, stream);
        writeTLObject(this.peer, stream);
        if ((this.flags & 1) != 0)
            writeInt(this.replyToMsgId, stream);
        writeLong(this.randomId, stream);
        writeLong(this.queryId, stream);
        writeTLString(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.broadcast = (this.flags & 16) != 0;
        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        if ((this.flags & 1) != 0)
            this.replyToMsgId = readInt(stream);
        this.randomId = readLong(stream);
        this.queryId = readLong(stream);
        this.id = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messages.sendInlineBotResult#b16e06fe";
    }

}
