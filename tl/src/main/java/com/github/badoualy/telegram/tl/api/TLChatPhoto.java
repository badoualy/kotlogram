
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLChatPhoto extends TLAbsChatPhoto {
    public static final int CLASS_ID = 0x6153276a;

    public TLChatPhoto() {

    }


    public TLChatPhoto(        com.github.badoualy.telegram.tl.api.TLAbsFileLocation _photoSmall,         com.github.badoualy.telegram.tl.api.TLAbsFileLocation _photoBig) {
        this.photoSmall = _photoSmall;
        this.photoBig = _photoBig;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsFileLocation photoSmall;

    protected com.github.badoualy.telegram.tl.api.TLAbsFileLocation photoBig;


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

        writeTLObject(this.photoSmall, stream);
        writeTLObject(this.photoBig, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.photoSmall = (com.github.badoualy.telegram.tl.api.TLAbsFileLocation)readTLObject(stream, context);
        this.photoBig = (com.github.badoualy.telegram.tl.api.TLAbsFileLocation)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "chatPhoto#6153276a";
    }

}
