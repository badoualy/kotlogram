
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLInputMediaGifExternal extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x4843b0fd;

    public TLInputMediaGifExternal() {

    }


    public TLInputMediaGifExternal(        String _url,         String _q) {
        this.url = _url;
        this.q = _q;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String url;

    protected String q;


    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String value) {
        this.q = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.url, stream);
        writeTLString(this.q, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.url = readTLString(stream);
        this.q = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputMediaGifExternal#4843b0fd";
    }

}
