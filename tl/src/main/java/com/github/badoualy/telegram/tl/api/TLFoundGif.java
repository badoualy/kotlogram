
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLFoundGif extends TLAbsFoundGif {
    public static final int CLASS_ID = 0x162ecc1f;

    public TLFoundGif() {

    }


    public TLFoundGif(        String _url,         String _thumbUrl,         String _contentUrl,         String _contentType,         int _w,         int _h) {
        this.url = _url;
        this.thumbUrl = _thumbUrl;
        this.contentUrl = _contentUrl;
        this.contentType = _contentType;
        this.w = _w;
        this.h = _h;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String thumbUrl;

    protected String contentUrl;

    protected String contentType;

    protected int w;

    protected int h;


    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String value) {
        this.thumbUrl = value;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String value) {
        this.contentUrl = value;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String value) {
        this.contentType = value;
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


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.url, stream);
        writeTLString(this.thumbUrl, stream);
        writeTLString(this.contentUrl, stream);
        writeTLString(this.contentType, stream);
        writeInt(this.w, stream);
        writeInt(this.h, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.url = readTLString(stream);
        this.thumbUrl = readTLString(stream);
        this.contentUrl = readTLString(stream);
        this.contentType = readTLString(stream);
        this.w = readInt(stream);
        this.h = readInt(stream);
    }



    @Override
    public String toString() {
        return "foundGif#162ecc1f";
    }

}
