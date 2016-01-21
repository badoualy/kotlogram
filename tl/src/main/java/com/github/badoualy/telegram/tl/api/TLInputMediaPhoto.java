
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLInputMediaPhoto extends TLAbsInputMedia {
    public static final int CLASS_ID = 0xe9bfb4f3;

    public TLInputMediaPhoto() {

    }


    public TLInputMediaPhoto(        com.github.badoualy.telegram.tl.api.TLAbsInputPhoto _id,         String _caption) {
        this.id = _id;
        this.caption = _caption;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputPhoto id;

    protected String caption;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPhoto getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.api.TLAbsInputPhoto value) {
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

        this.id = (com.github.badoualy.telegram.tl.api.TLAbsInputPhoto)readTLObject(stream, context);
        this.caption = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputMediaPhoto#e9bfb4f3";
    }

}
