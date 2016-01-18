
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLMessageMediaPhoto extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0xc8c45a2a;

    public TLMessageMediaPhoto() {

    }


    public TLMessageMediaPhoto(        com.github.badoualy.telegram.tl.api.TLAbsPhoto _photo) {
        this.photo = _photo;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsPhoto photo;


    public com.github.badoualy.telegram.tl.api.TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(com.github.badoualy.telegram.tl.api.TLAbsPhoto value) {
        this.photo = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.photo, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.photo = (com.github.badoualy.telegram.tl.api.TLAbsPhoto)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messageMediaPhoto#c8c45a2a";
    }

}
