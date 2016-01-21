
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
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLRequestMessagesSendMessage extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUpdates> {

    public static final int CLASS_ID = 0xfa88427a;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSendMessage(        int _flags,         boolean _noWebpage,         boolean _broadcast,         com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         int _replyToMsgId,         String _message,         long _randomId,         com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup _replyMarkup,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> _entities) {
        this.flags = _flags;
        this.noWebpage = _noWebpage;
        this.broadcast = _broadcast;
        this.peer = _peer;
        this.replyToMsgId = _replyToMsgId;
        this.message = _message;
        this.randomId = _randomId;
        this.replyMarkup = _replyMarkup;
        this.entities = _entities;

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

    protected boolean noWebpage;

    protected boolean broadcast;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer;

    protected int replyToMsgId;

    protected String message;

    protected long randomId;

    protected com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup replyMarkup;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> entities;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getNoWebpage() {
        return noWebpage;
    }

    public void setNoWebpage(boolean value) {
        this.noWebpage = value;
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long value) {
        this.randomId = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup getReplyMarkup() {
        return replyMarkup;
    }

    public void setReplyMarkup(com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup value) {
        this.replyMarkup = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> value) {
        this.entities = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = noWebpage ? (flags | 2) : (flags &~ 2);
        flags = broadcast ? (flags | 16) : (flags &~ 16);
        writeInt(this.flags, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.noWebpage, stream);
        if ((this.flags & 16) != 0)
            writeTLBool(this.broadcast, stream);
        writeTLObject(this.peer, stream);
        if ((this.flags & 1) != 0)
            writeInt(this.replyToMsgId, stream);
        writeTLString(this.message, stream);
        writeLong(this.randomId, stream);
        if ((this.flags & 4) != 0)
            writeTLObject(this.replyMarkup, stream);
        if ((this.flags & 8) != 0)
            writeTLVector(this.entities, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.noWebpage = (this.flags & 2) != 0;
        this.broadcast = (this.flags & 16) != 0;
        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        if ((this.flags & 1) != 0)
            this.replyToMsgId = readInt(stream);
        this.message = readTLString(stream);
        this.randomId = readLong(stream);
        if ((this.flags & 4) != 0)
            this.replyMarkup = (com.github.badoualy.telegram.tl.api.TLAbsReplyMarkup)readTLObject(stream, context);
        if ((this.flags & 8) != 0)
            this.entities = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "messages.sendMessage#fa88427a";
    }

}
