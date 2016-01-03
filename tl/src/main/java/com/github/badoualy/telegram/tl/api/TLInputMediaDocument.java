
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputMediaDocument extends TLAbsInputMedia {
    public static final int CLASS_ID = 0xd184e841;

    public TLInputMediaDocument() {

    }


    public TLInputMediaDocument(        com.github.badoualy.telegram.tl.api.TLAbsInputDocument _id) {
        this.id = _id;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputDocument id;


    public com.github.badoualy.telegram.tl.api.TLAbsInputDocument getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.api.TLAbsInputDocument value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = (com.github.badoualy.telegram.tl.api.TLAbsInputDocument)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "inputMediaDocument#d184e841";
    }

}
