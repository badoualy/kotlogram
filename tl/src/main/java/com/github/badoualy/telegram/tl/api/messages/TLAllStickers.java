
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLAllStickers extends TLAbsAllStickers {
    public static final int CLASS_ID = 0xedfd405f;

    public TLAllStickers() {

    }


    public TLAllStickers(        int _hash,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLStickerSet> _sets) {
        this.hash = _hash;
        this.sets = _sets;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int hash;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLStickerSet> sets;


    public int getHash() {
        return hash;
    }

    public void setHash(int value) {
        this.hash = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLStickerSet> getSets() {
        return sets;
    }

    public void setSets(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLStickerSet> value) {
        this.sets = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.hash, stream);
        writeTLVector(this.sets, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.hash = readInt(stream);
        this.sets = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "messages.allStickers#edfd405f";
    }

}
