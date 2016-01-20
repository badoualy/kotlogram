
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLStickerPack extends TLObject {

    public static final int CLASS_ID = 0x12b299d4;

    public TLStickerPack() {

    }


    public TLStickerPack(        String _emoticon,         com.github.badoualy.telegram.tl.core.TLLongVector _documents) {
        this.emoticon = _emoticon;
        this.documents = _documents;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String emoticon;

    protected com.github.badoualy.telegram.tl.core.TLLongVector documents;


    public String getEmoticon() {
        return emoticon;
    }

    public void setEmoticon(String value) {
        this.emoticon = value;
    }

    public com.github.badoualy.telegram.tl.core.TLLongVector getDocuments() {
        return documents;
    }

    public void setDocuments(com.github.badoualy.telegram.tl.core.TLLongVector value) {
        this.documents = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.emoticon, stream);
        writeTLVector(this.documents, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.emoticon = readTLString(stream);
        this.documents = readTLLongVector(stream, context);
    }


    @Override
    public String toString() {
        return "stickerPack#12b299d4";
    }

}
