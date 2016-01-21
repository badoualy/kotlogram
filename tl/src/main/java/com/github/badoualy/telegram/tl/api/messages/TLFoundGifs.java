
package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLFoundGifs extends TLObject {

    public static final int CLASS_ID = 0x450a1c0a;

    public TLFoundGifs() {

    }


    public TLFoundGifs(        int _nextOffset,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsFoundGif> _results) {
        this.nextOffset = _nextOffset;
        this.results = _results;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int nextOffset;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsFoundGif> results;


    public int getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(int value) {
        this.nextOffset = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsFoundGif> getResults() {
        return results;
    }

    public void setResults(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsFoundGif> value) {
        this.results = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.nextOffset, stream);
        writeTLVector(this.results, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.nextOffset = readInt(stream);
        this.results = readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "messages.foundGifs#450a1c0a";
    }

}
