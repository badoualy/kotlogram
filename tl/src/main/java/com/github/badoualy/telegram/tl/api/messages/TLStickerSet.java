
package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLStickerSet extends TLObject {

    public static final int CLASS_ID = 0xb60a24a6;

    public TLStickerSet() {

    }


    public TLStickerSet(        com.github.badoualy.telegram.tl.api.TLStickerSet _set,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLStickerPack> _packs,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> _documents) {
        this.set = _set;
        this.packs = _packs;
        this.documents = _documents;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLStickerSet set;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLStickerPack> packs;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocument> documents;


    public com.github.badoualy.telegram.tl.api.TLStickerSet getSet() {
        return set;
    }

    public void setSet(com.github.badoualy.telegram.tl.api.TLStickerSet value) {
        this.set = value;
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

        writeTLObject(this.set, stream);
        writeTLVector(this.packs, stream);
        writeTLVector(this.documents, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.set = (com.github.badoualy.telegram.tl.api.TLStickerSet)readTLObject(stream, context);
        this.packs = readTLVector(stream, context);
        this.documents = readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "messages.stickerSet#b60a24a6";
    }

}
