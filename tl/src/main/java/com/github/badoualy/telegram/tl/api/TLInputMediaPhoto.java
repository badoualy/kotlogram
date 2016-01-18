
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLInputMediaPhoto extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x8f2ab2ec;

    public TLInputMediaPhoto() {

    }


    public TLInputMediaPhoto(        com.github.badoualy.telegram.tl.api.TLAbsInputPhoto _id) {
        this.id = _id;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputPhoto id;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPhoto getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.api.TLAbsInputPhoto value) {
        this.id = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.id, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = (com.github.badoualy.telegram.tl.api.TLAbsInputPhoto)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "inputMediaPhoto#8f2ab2ec";
    }

}
