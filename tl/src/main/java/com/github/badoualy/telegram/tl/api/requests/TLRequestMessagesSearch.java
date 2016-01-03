
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesSearch extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsMessages> {

    public static final int CLASS_ID = 0x7e9f2ab;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSearch(        com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         String _q,         com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter _filter,         int _minDate,         int _maxDate,         int _offset,         int _maxId,         int _limit) {
        this.peer = _peer;
        this.q = _q;
        this.filter = _filter;
        this.minDate = _minDate;
        this.maxDate = _maxDate;
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

    protected String q;

    protected com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter filter;

    protected int minDate;

    protected int maxDate;

    protected int offset;

    protected int maxId;

    protected int limit;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String value) {
        this.q = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter getFilter() {
        return filter;
    }

    public void setFilter(com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter value) {
        this.filter = value;
    }

    public int getMinDate() {
        return minDate;
    }

    public void setMinDate(int value) {
        this.minDate = value;
    }

    public int getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(int value) {
        this.maxDate = value;
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
        writeTLString(this.q, stream);
        writeTLObject(this.filter, stream);
        writeInt(this.minDate, stream);
        writeInt(this.maxDate, stream);
        writeInt(this.offset, stream);
        writeInt(this.maxId, stream);
        writeInt(this.limit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.q = readTLString(stream);
        this.filter = (com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter)readTLObject(stream, context);
        this.minDate = readInt(stream);
        this.maxDate = readInt(stream);
        this.offset = readInt(stream);
        this.maxId = readInt(stream);
        this.limit = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.search#7e9f2ab";
    }

}
