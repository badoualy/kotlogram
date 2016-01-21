
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLMessageMediaWebPage extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0xa32dd600;

    public TLMessageMediaWebPage() {

    }


    public TLMessageMediaWebPage(        com.github.badoualy.telegram.tl.api.TLAbsWebPage _webpage) {
        this.webpage = _webpage;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsWebPage webpage;


    public com.github.badoualy.telegram.tl.api.TLAbsWebPage getWebpage() {
        return webpage;
    }

    public void setWebpage(com.github.badoualy.telegram.tl.api.TLAbsWebPage value) {
        this.webpage = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.webpage, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.webpage = (com.github.badoualy.telegram.tl.api.TLAbsWebPage)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messageMediaWebPage#a32dd600";
    }

}
