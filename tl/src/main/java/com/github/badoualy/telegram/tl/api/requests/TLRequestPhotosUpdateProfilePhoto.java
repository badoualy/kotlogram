
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestPhotosUpdateProfilePhoto extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto> {

    public static final int CLASS_ID = 0xeef579a0;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestPhotosUpdateProfilePhoto(        com.github.badoualy.telegram.tl.api.TLAbsInputPhoto _id,         com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop _crop) {
        this.id = _id;
        this.crop = _crop;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto) {
            return (com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto, got: " + res.getClass().getCanonicalName());
        }

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
        return "photos.updateProfilePhoto#eef579a0";
    }

}
