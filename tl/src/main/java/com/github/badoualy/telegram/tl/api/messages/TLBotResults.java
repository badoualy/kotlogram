
package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLBotResults extends TLObject {

    public static final int CLASS_ID = 0x1170b0a3;

    public TLBotResults() {

    }


    public TLBotResults(        int _flags,         boolean _gallery,         long _queryId,         String _nextOffset,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsBotInlineResult> _results) {
        this.flags = _flags;
        this.gallery = _gallery;
        this.queryId = _queryId;
        this.nextOffset = _nextOffset;
        this.results = _results;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected boolean gallery;

    protected long queryId;

    protected String nextOffset;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsBotInlineResult> results;


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

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long value) {
        this.queryId = value;
    }

    public String getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(String value) {
        this.nextOffset = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsBotInlineResult> getResults() {
        return results;
    }

    public void setResults(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsBotInlineResult> value) {
        this.results = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = gallery ? (flags | 1) : (flags &~ 1);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.gallery, stream);
        writeLong(this.queryId, stream);
        if ((this.flags & 2) != 0)
            writeTLString(this.nextOffset, stream);
        writeTLVector(this.results, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.gallery = (this.flags & 1) != 0;
        this.queryId = readLong(stream);
        if ((this.flags & 2) != 0)
            this.nextOffset = readTLString(stream);
        this.results = readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "messages.botResults#1170b0a3";
    }

}
