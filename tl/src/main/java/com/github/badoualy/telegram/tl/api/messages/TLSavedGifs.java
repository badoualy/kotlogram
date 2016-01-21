
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLSavedGifs extends TLAbsSavedGifs {
    public static final int CLASS_ID = 0x2e0709a5;

    public TLSavedGifs() {

    }


    public TLSavedGifs(        int _hash,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> _gifs) {
        this.hash = _hash;
        this.gifs = _gifs;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int hash;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> gifs;


    public int getHash() {
        return hash;
    }

    public void setHash(int value) {
        this.hash = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> getGifs() {
        return gifs;
    }

    public void setGifs(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> value) {
        this.gifs = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.hash, stream);
        writeTLVector(this.gifs, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.hash = readInt(stream);
        this.gifs = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "messages.savedGifs#2e0709a5";
    }

}
