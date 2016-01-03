
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUpdateReadMessages extends TLAbsUpdate {
    public static final int CLASS_ID = 0xc6649e31;

    public TLUpdateReadMessages() {

    }


    public TLUpdateReadMessages(        com.github.badoualy.telegram.tl.core.TLIntVector _messages,         int _pts) {
        this.messages = _messages;
        this.pts = _pts;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.core.TLIntVector messages;

    protected int pts;


    public com.github.badoualy.telegram.tl.core.TLIntVector getMessages() {
        return messages;
    }

    public void setMessages(com.github.badoualy.telegram.tl.core.TLIntVector value) {
        this.messages = value;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.messages, stream);
        writeInt(this.pts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.messages = readTLIntVector(stream, context);
        this.pts = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateReadMessages#c6649e31";
    }

}
