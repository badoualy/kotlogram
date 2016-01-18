
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLUpdateDeleteMessages extends TLAbsUpdate {
    public static final int CLASS_ID = 0xa92bfe26;

    public TLUpdateDeleteMessages() {

    }


    public TLUpdateDeleteMessages(        com.github.badoualy.telegram.tl.core.TLIntVector _messages,         int _pts) {
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
        return "updateDeleteMessages#a92bfe26";
    }

}
