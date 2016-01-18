
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLPhotoCachedSize extends TLAbsPhotoSize {
    public static final int CLASS_ID = 0xe9a734fa;

    public TLPhotoCachedSize() {

    }


    public TLPhotoCachedSize(        String _type,         com.github.badoualy.telegram.tl.api.TLAbsFileLocation _location,         int _w,         int _h,         TLBytes _bytes) {
        this.type = _type;
        this.location = _location;
        this.w = _w;
        this.h = _h;
        this.bytes = _bytes;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsFileLocation location;

    protected int w;

    protected int h;

    protected TLBytes bytes;


    public com.github.badoualy.telegram.tl.api.TLAbsFileLocation getLocation() {
        return location;
    }

    public void setLocation(com.github.badoualy.telegram.tl.api.TLAbsFileLocation value) {
        this.location = value;
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

    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes value) {
        this.bytes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.type, stream);
        writeTLObject(this.location, stream);
        writeInt(this.w, stream);
        writeInt(this.h, stream);
        writeTLBytes(this.bytes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.type = readTLString(stream);
        this.location = (com.github.badoualy.telegram.tl.api.TLAbsFileLocation)readTLObject(stream, context);
        this.w = readInt(stream);
        this.h = readInt(stream);
        this.bytes = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "photoCachedSize#e9a734fa";
    }

}
