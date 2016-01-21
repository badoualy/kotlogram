
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLInputMediaDocument extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x1a77f29c;

    public TLInputMediaDocument() {

    }


    public TLInputMediaDocument(        com.github.badoualy.telegram.tl.api.TLAbsInputDocument _id,         String _caption) {
        this.id = _id;
        this.caption = _caption;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputDocument id;

    protected String caption;


    public com.github.badoualy.telegram.tl.api.TLAbsInputDocument getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.api.TLAbsInputDocument value) {
        this.id = value;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String value) {
        this.caption = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.id, stream);
        writeTLString(this.caption, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = (com.github.badoualy.telegram.tl.api.TLAbsInputDocument)readTLObject(stream, context);
        this.caption = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputMediaDocument#1a77f29c";
    }

}
