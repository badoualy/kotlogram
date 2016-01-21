
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateWebPage extends TLAbsUpdate {
    public static final int CLASS_ID = 0x7f891213;

    public TLUpdateWebPage() {

    }


    public TLUpdateWebPage(        com.github.badoualy.telegram.tl.api.TLAbsWebPage _webpage,         int _pts,         int _ptsCount) {
        this.webpage = _webpage;
        this.pts = _pts;
        this.ptsCount = _ptsCount;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsWebPage webpage;

    protected int pts;

    protected int ptsCount;


    public com.github.badoualy.telegram.tl.api.TLAbsWebPage getWebpage() {
        return webpage;
    }

    public void setWebpage(com.github.badoualy.telegram.tl.api.TLAbsWebPage value) {
        this.webpage = value;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int value) {
        this.ptsCount = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.webpage, stream);
        writeInt(this.pts, stream);
        writeInt(this.ptsCount, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.webpage = (com.github.badoualy.telegram.tl.api.TLAbsWebPage)readTLObject(stream, context);
        this.pts = readInt(stream);
        this.ptsCount = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateWebPage#7f891213";
    }

}
