
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestMessagesSearchGlobal extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsMessages> {

    public static final int CLASS_ID = 0x9e3cacb0;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSearchGlobal(        String _q,         int _offsetDate,         com.github.badoualy.telegram.tl.api.TLAbsInputPeer _offsetPeer,         int _offsetId,         int _limit) {
        this.q = _q;
        this.offsetDate = _offsetDate;
        this.offsetPeer = _offsetPeer;
        this.offsetId = _offsetId;
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
        


    protected String q;

    protected int offsetDate;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer offsetPeer;

    protected int offsetId;

    protected int limit;


    public String getQ() {
        return q;
    }

    public void setQ(String value) {
        this.q = value;
    }

    public int getOffsetDate() {
        return offsetDate;
    }

    public void setOffsetDate(int value) {
        this.offsetDate = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getOffsetPeer() {
        return offsetPeer;
    }

    public void setOffsetPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.offsetPeer = value;
    }

    public int getOffsetId() {
        return offsetId;
    }

    public void setOffsetId(int value) {
        this.offsetId = value;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int value) {
        this.limit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.q, stream);
        writeInt(this.offsetDate, stream);
        writeTLObject(this.offsetPeer, stream);
        writeInt(this.offsetId, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.q = readTLString(stream);
        this.offsetDate = readInt(stream);
        this.offsetPeer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.offsetId = readInt(stream);
        this.limit = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.searchGlobal#9e3cacb0";
    }

}
