
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLFoundGifCached extends TLAbsFoundGif {
    public static final int CLASS_ID = 0x9c750409;

    public TLFoundGifCached() {

    }


    public TLFoundGifCached(        String _url,         com.github.badoualy.telegram.tl.api.TLAbsPhoto _photo,         com.github.badoualy.telegram.tl.api.TLAbsDocument _document) {
        this.url = _url;
        this.photo = _photo;
        this.document = _document;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsPhoto photo;

    protected com.github.badoualy.telegram.tl.api.TLAbsDocument document;


    public com.github.badoualy.telegram.tl.api.TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(com.github.badoualy.telegram.tl.api.TLAbsPhoto value) {
        this.photo = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(com.github.badoualy.telegram.tl.api.TLAbsDocument value) {
        this.document = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.url, stream);
        writeTLObject(this.photo, stream);
        writeTLObject(this.document, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.url = readTLString(stream);
        this.photo = (com.github.badoualy.telegram.tl.api.TLAbsPhoto)readTLObject(stream, context);
        this.document = (com.github.badoualy.telegram.tl.api.TLAbsDocument)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "foundGifCached#9c750409";
    }

}
