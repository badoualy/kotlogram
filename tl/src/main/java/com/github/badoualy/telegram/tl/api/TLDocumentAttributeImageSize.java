
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLDocumentAttributeImageSize extends TLAbsDocumentAttribute {
    public static final int CLASS_ID = 0x6c37c15c;

    public TLDocumentAttributeImageSize() {

    }


    public TLDocumentAttributeImageSize(        int _w,         int _h) {
        this.w = _w;
        this.h = _h;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int w;

    protected int h;


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


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.w, stream);
        writeInt(this.h, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.w = readInt(stream);
        this.h = readInt(stream);
    }



    @Override
    public String toString() {
        return "documentAttributeImageSize#6c37c15c";
    }

}
