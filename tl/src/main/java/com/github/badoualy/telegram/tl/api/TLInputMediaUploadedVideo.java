
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLInputMediaUploadedVideo extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x133ad6f6;

    public TLInputMediaUploadedVideo() {

    }


    public TLInputMediaUploadedVideo(        com.github.badoualy.telegram.tl.api.TLAbsInputFile _file,         int _duration,         int _w,         int _h,         String _mimeType) {
        this.file = _file;
        this.duration = _duration;
        this.w = _w;
        this.h = _h;
        this.mimeType = _mimeType;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputFile file;

    protected int duration;

    protected int w;

    protected int h;

    protected String mimeType;


    public com.github.badoualy.telegram.tl.api.TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(com.github.badoualy.telegram.tl.api.TLAbsInputFile value) {
        this.file = value;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int value) {
        this.duration = value;
    }

    public int getW() {
        return w;
    }

    public void setW(int value) {
        this.w = value;
    }

    public int getH() {
        return h;
    }

    public void setH(int value) {
        this.h = value;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String value) {
        this.mimeType = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.file, stream);
        writeInt(this.duration, stream);
        writeInt(this.w, stream);
        writeInt(this.h, stream);
        writeTLString(this.mimeType, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.file = (com.github.badoualy.telegram.tl.api.TLAbsInputFile)readTLObject(stream, context);
        this.duration = readInt(stream);
        this.w = readInt(stream);
        this.h = readInt(stream);
        this.mimeType = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputMediaUploadedVideo#133ad6f6";
    }

}
