
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLMessageMediaDocument extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0xf3e02ea8;

    public TLMessageMediaDocument() {

    }


    public TLMessageMediaDocument(        com.github.badoualy.telegram.tl.api.TLAbsDocument _document,         String _caption) {
        this.document = _document;
        this.caption = _caption;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsDocument document;

    protected String caption;


    public com.github.badoualy.telegram.tl.api.TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(com.github.badoualy.telegram.tl.api.TLAbsDocument value) {
        this.document = value;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String value) {
        this.caption = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.document, stream);
        writeTLString(this.caption, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.document = (com.github.badoualy.telegram.tl.api.TLAbsDocument)readTLObject(stream, context);
        this.caption = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messageMediaDocument#f3e02ea8";
    }

}
