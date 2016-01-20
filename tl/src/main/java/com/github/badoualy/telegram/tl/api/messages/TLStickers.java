
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLStickers extends TLAbsStickers {
    public static final int CLASS_ID = 0x8a8ecd32;

    public TLStickers() {

    }


    public TLStickers(        String _hash,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> _stickers) {
        this.hash = _hash;
        this.stickers = _stickers;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String hash;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> stickers;


    public String getHash() {
        return hash;
    }

    public void setHash(String value) {
        this.hash = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> getStickers() {
        return stickers;
    }

    public void setStickers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> value) {
        this.stickers = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.hash, stream);
        writeTLVector(this.stickers, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.hash = readTLString(stream);
        this.stickers = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "messages.stickers#8a8ecd32";
    }

}
