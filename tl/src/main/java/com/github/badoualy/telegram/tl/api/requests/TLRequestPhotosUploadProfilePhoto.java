
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestPhotosUploadProfilePhoto extends TLMethod<com.github.badoualy.telegram.tl.api.photos.TLPhoto> {

    public static final int CLASS_ID = 0xd50f9c88;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestPhotosUploadProfilePhoto(        com.github.badoualy.telegram.tl.api.TLAbsInputFile _file,         String _caption,         com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint _geoPoint,         com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop _crop) {
        this.file = _file;
        this.caption = _caption;
        this.geoPoint = _geoPoint;
        this.crop = _crop;

    }



    public com.github.badoualy.telegram.tl.api.photos.TLPhoto deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.photos.TLPhoto) {
            return (com.github.badoualy.telegram.tl.api.photos.TLPhoto)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.photos.TLPhoto, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputFile file;

    protected String caption;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint geoPoint;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop crop;


    public com.github.badoualy.telegram.tl.api.TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(com.github.badoualy.telegram.tl.api.TLAbsInputFile value) {
        this.file = value;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String value) {
        this.caption = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint getGeoPoint() {
        return geoPoint;
    }

    public void setGeoPoint(com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint value) {
        this.geoPoint = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop getCrop() {
        return crop;
    }

    public void setCrop(com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop value) {
        this.crop = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.file, stream);
        writeTLString(this.caption, stream);
        writeTLObject(this.geoPoint, stream);
        writeTLObject(this.crop, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile)readTLObject(stream, context);
        this.caption = readTLString(stream);
        this.geoPoint = (com.github.badoualy.telegram.tl.api.TLAbsInputGeoPoint)readTLObject(stream, context);
        this.crop = (com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "photos.uploadProfilePhoto#d50f9c88";
    }

}
