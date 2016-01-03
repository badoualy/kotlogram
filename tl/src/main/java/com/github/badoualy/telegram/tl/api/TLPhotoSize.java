
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLPhotoSize extends TLAbsPhotoSize {
    public static final int CLASS_ID = 0x77bfb61b;

    public TLPhotoSize() {

    }


    public TLPhotoSize(        String _type,         com.github.badoualy.telegram.tl.api.TLAbsFileLocation _location,         int _w,         int _h,         int _size) {
        this.type = _type;
        this.location = _location;
        this.w = _w;
        this.h = _h;
        this.size = _size;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsFileLocation location;

    protected int w;

    protected int h;

    protected int size;


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

    public int getSize() {
        return size;
    }

    public void setSize(int value) {
        this.size = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.type, stream);
        writeTLObject(this.location, stream);
        writeInt(this.w, stream);
        writeInt(this.h, stream);
        writeInt(this.size, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.type = readTLString(stream);
        this.location = (com.github.badoualy.telegram.tl.api.TLAbsFileLocation)readTLObject(stream, context);
        this.w = readInt(stream);
        this.h = readInt(stream);
        this.size = readInt(stream);
    }



    @Override
    public String toString() {
        return "photoSize#77bfb61b";
    }

}
