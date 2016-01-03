
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUpdateNewMessage extends TLAbsUpdate {
    public static final int CLASS_ID = 0x13abdb3;

    public TLUpdateNewMessage() {

    }


    public TLUpdateNewMessage(        com.github.badoualy.telegram.tl.api.TLAbsMessage _message,         int _pts) {
        this.message = _message;
        this.pts = _pts;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsMessage message;

    protected int pts;


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


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.message, stream);
        writeInt(this.pts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.message = (com.github.badoualy.telegram.tl.api.TLAbsMessage)readTLObject(stream, context);
        this.pts = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateNewMessage#13abdb3";
    }

}
