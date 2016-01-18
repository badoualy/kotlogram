
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUserProfilePhoto extends TLAbsUserProfilePhoto {
    public static final int CLASS_ID = 0xd559d8c8;

    public TLUserProfilePhoto() {

    }


    public TLUserProfilePhoto(        long _photoId,         com.github.badoualy.telegram.tl.api.TLAbsFileLocation _photoSmall,         com.github.badoualy.telegram.tl.api.TLAbsFileLocation _photoBig) {
        this.photoId = _photoId;
        this.photoSmall = _photoSmall;
        this.photoBig = _photoBig;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long photoId;

    protected com.github.badoualy.telegram.tl.api.TLAbsFileLocation photoSmall;

    protected com.github.badoualy.telegram.tl.api.TLAbsFileLocation photoBig;


    public long getPhotoId() {
        return photoId;
    }

    public void setPhotoId(long value) {
        this.photoId = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsFileLocation getPhotoSmall() {
        return photoSmall;
    }

    public void setPhotoSmall(com.github.badoualy.telegram.tl.api.TLAbsFileLocation value) {
        this.photoSmall = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsFileLocation getPhotoBig() {
        return photoBig;
    }

    public void setPhotoBig(com.github.badoualy.telegram.tl.api.TLAbsFileLocation value) {
        this.photoBig = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.photoId, stream);
        writeTLObject(this.photoSmall, stream);
        writeTLObject(this.photoBig, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.photoId = readLong(stream);
        this.photoSmall = (com.github.badoualy.telegram.tl.api.TLAbsFileLocation)readTLObject(stream, context);
        this.photoBig = (com.github.badoualy.telegram.tl.api.TLAbsFileLocation)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "userProfilePhoto#d559d8c8";
    }

}
