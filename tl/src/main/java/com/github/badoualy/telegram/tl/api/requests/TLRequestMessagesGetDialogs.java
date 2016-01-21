
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


public class TLRequestMessagesGetDialogs extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs> {

    public static final int CLASS_ID = 0x6b47f94d;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetDialogs(        int _offsetDate,         int _offsetId,         com.github.badoualy.telegram.tl.api.TLAbsInputPeer _offsetPeer,         int _limit) {
        this.offsetDate = _offsetDate;
        this.offsetId = _offsetId;
        this.offsetPeer = _offsetPeer;
        this.limit = _limit;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int offsetDate;

    protected int offsetId;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer offsetPeer;

    protected int limit;


    public int getOffsetDate() {
        return offsetDate;
    }

    public void setOffsetDate(int value) {
        this.offsetDate = value;
    }

    public int getOffsetId() {
        return offsetId;
    }

    public void setOffsetId(int value) {
        this.offsetId = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getOffsetPeer() {
        return offsetPeer;
    }

    public void setOffsetPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.offsetPeer = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.offsetDate, stream);
        writeInt(this.offsetId, stream);
        writeTLObject(this.offsetPeer, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.offsetDate = readInt(stream);
        this.offsetId = readInt(stream);
        this.offsetPeer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.limit = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.getDialogs#6b47f94d";
    }

}
