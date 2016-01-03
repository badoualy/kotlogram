
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageMediaDocument extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0x2fda2204;

    public TLMessageMediaDocument() {

    }


    public TLMessageMediaDocument(        com.github.badoualy.telegram.tl.api.TLAbsDocument _document) {
        this.document = _document;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsDocument document;


    public com.github.badoualy.telegram.tl.api.TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(com.github.badoualy.telegram.tl.api.TLAbsDocument value) {
        this.document = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.document, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.document = (com.github.badoualy.telegram.tl.api.TLAbsDocument)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messageMediaDocument#2fda2204";
    }

}
