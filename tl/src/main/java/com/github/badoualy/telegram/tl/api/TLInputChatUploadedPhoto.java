
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputChatUploadedPhoto extends TLAbsInputChatPhoto {
    public static final int CLASS_ID = 0x94254732;

    public TLInputChatUploadedPhoto() {

    }


    public TLInputChatUploadedPhoto(        com.github.badoualy.telegram.tl.api.TLAbsInputFile _file,         com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop _crop) {
        this.file = _file;
        this.crop = _crop;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputFile file;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop crop;


    public com.github.badoualy.telegram.tl.api.TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(com.github.badoualy.telegram.tl.api.TLAbsInputFile value) {
        this.file = value;
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
        writeTLObject(this.crop, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile)readTLObject(stream, context);
        this.crop = (com.github.badoualy.telegram.tl.api.TLAbsInputPhotoCrop)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "inputChatUploadedPhoto#94254732";
    }

}
