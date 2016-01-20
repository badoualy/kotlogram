
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLAllStickers extends TLAbsAllStickers {
    public static final int CLASS_ID = 0xdcef3102;

    public TLAllStickers() {

    }


    public TLAllStickers(        String _hash,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLStickerPack> _packs,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> _documents) {
        this.hash = _hash;
        this.packs = _packs;
        this.documents = _documents;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String hash;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLStickerPack> packs;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> documents;


    public String getHash() {
        return hash;
    }

    public void setHash(String value) {
        this.hash = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLStickerPack> getPacks() {
        return packs;
    }

    public void setPacks(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLStickerPack> value) {
        this.packs = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> value) {
        this.documents = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.hash, stream);
        writeTLVector(this.packs, stream);
        writeTLVector(this.documents, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.hash = readTLString(stream);
        this.packs = readTLVector(stream, context);
        this.documents = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "messages.allStickers#dcef3102";
    }

}
