
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLWallPaper extends TLAbsWallPaper {
    public static final int CLASS_ID = 0xccb03657;

    public TLWallPaper() {

    }


    public TLWallPaper(        int _id,         String _title,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhotoSize> _sizes,         int _color) {
        this.id = _id;
        this.title = _title;
        this.sizes = _sizes;
        this.color = _color;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhotoSize> sizes;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhotoSize> value) {
        this.sizes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.title, stream);
        writeTLVector(this.sizes, stream);
        writeInt(this.color, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.title = readTLString(stream);
        this.sizes = readTLVector(stream, context);
        this.color = readInt(stream);
    }



    @Override
    public String toString() {
        return "wallPaper#ccb03657";
    }

}
