
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLInputChatPhoto extends TLAbsInputChatPhoto {
    public static final int CLASS_ID = 0xb2e1bf08;

    public TLInputChatPhoto() {

    }


    public TLInputChatPhoto(        com.github.badoualy.telegram.tl.api.TLAbsInputPhoto _id,         com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop _crop) {
        this.id = _id;
        this.crop = _crop;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputPhoto id;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop crop;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPhoto getId() {
        return id;
    }

    public void setId(com.github.badoualy.telegram.tl.api.TLAbsInputPhoto value) {
        this.id = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop getCrop() {
        return crop;
    }

    public void setCrop(com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop value) {
        this.crop = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.id, stream);
        writeTLObject(this.crop, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = (com.github.badoualy.telegram.tl.api.TLAbsInputPhoto)readTLObject(stream, context);
        this.crop = (com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "inputChatPhoto#b2e1bf08";
    }

}
