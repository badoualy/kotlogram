
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLMessageEntityTextUrl extends TLAbsMessageEntity {
    public static final int CLASS_ID = 0x76a6d327;

    public TLMessageEntityTextUrl() {

    }


    public TLMessageEntityTextUrl(        int _offset,         int _length,         String _url) {
        this.offset = _offset;
        this.length = _length;
        this.url = _url;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String url;


    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.offset, stream);
        writeInt(this.length, stream);
        writeTLString(this.url, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.offset = readInt(stream);
        this.length = readInt(stream);
        this.url = readTLString(stream);
    }



    @Override
    public String toString() {
        return "messageEntityTextUrl#76a6d327";
    }

}
