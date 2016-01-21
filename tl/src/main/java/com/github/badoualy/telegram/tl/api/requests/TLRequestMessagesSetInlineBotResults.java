
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
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
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLRequestMessagesSetInlineBotResults extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x3f23ec12;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSetInlineBotResults(        int _flags,         boolean _gallery,         boolean _privat,         long _queryId,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputBotInlineResult> _results,         int _cacheTime,         String _nextOffset) {
        this.flags = _flags;
        this.gallery = _gallery;
        this.privat = _privat;
        this.queryId = _queryId;
        this.results = _results;
        this.cacheTime = _cacheTime;
        this.nextOffset = _nextOffset;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int flags;

    protected boolean gallery;

    protected boolean privat;

    protected long queryId;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputBotInlineResult> results;

    protected int cacheTime;

    protected String nextOffset;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getGallery() {
        return gallery;
    }

    public void setGallery(boolean value) {
        this.gallery = value;
    }

    public boolean getPrivat() {
        return privat;
    }

    public void setPrivat(boolean value) {
        this.privat = value;
    }

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long value) {
        this.queryId = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputBotInlineResult> getResults() {
        return results;
    }

    public void setResults(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLInputBotInlineResult> value) {
        this.results = value;
    }

    public int getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(int value) {
        this.cacheTime = value;
    }

    public String getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(String value) {
        this.nextOffset = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = gallery ? (flags | 1) : (flags &~ 1);
        flags = privat ? (flags | 2) : (flags &~ 2);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.gallery, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.privat, stream);
        writeLong(this.queryId, stream);
        writeTLVector(this.results, stream);
        writeInt(this.cacheTime, stream);
        if ((this.flags & 4) != 0)
            writeTLString(this.nextOffset, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.gallery = (this.flags & 1) != 0;
        this.privat = (this.flags & 2) != 0;
        this.queryId = readLong(stream);
        this.results = readTLVector(stream, context);
        this.cacheTime = readInt(stream);
        if ((this.flags & 4) != 0)
            this.nextOffset = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messages.setInlineBotResults#3f23ec12";
    }

}
