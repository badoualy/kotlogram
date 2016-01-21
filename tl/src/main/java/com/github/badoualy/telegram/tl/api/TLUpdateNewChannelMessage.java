
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateNewChannelMessage extends TLAbsUpdate {
    public static final int CLASS_ID = 0x62ba04d9;

    public TLUpdateNewChannelMessage() {

    }


    public TLUpdateNewChannelMessage(        com.github.badoualy.telegram.tl.api.TLAbsMessage _message,         int _pts,         int _ptsCount) {
        this.message = _message;
        this.pts = _pts;
        this.ptsCount = _ptsCount;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsMessage message;

    protected int pts;

    protected int ptsCount;


    public com.github.badoualy.telegram.tl.api.TLAbsMessage getMessage() {
        return message;
    }

    public void setMessage(com.github.badoualy.telegram.tl.api.TLAbsMessage value) {
        this.message = value;
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

        writeTLObject(this.message, stream);
        writeInt(this.pts, stream);
        writeInt(this.ptsCount, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.message = (com.github.badoualy.telegram.tl.api.TLAbsMessage)readTLObject(stream, context);
        this.pts = readInt(stream);
        this.ptsCount = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateNewChannelMessage#62ba04d9";
    }

}
