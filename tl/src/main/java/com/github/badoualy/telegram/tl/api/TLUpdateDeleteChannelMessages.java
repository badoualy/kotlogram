
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLUpdateDeleteChannelMessages extends TLAbsUpdate {
    public static final int CLASS_ID = 0xc37521c9;

    public TLUpdateDeleteChannelMessages() {

    }


    public TLUpdateDeleteChannelMessages(        int _channelId,         com.github.badoualy.telegram.tl.core.TLIntVector _messages,         int _pts,         int _ptsCount) {
        this.channelId = _channelId;
        this.messages = _messages;
        this.pts = _pts;
        this.ptsCount = _ptsCount;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int channelId;

    protected com.github.badoualy.telegram.tl.core.TLIntVector messages;

    protected int pts;

    protected int ptsCount;


    public int getChannelId() {
        return channelId;
    }

    public void setChannelId(int value) {
        this.channelId = value;
    }

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

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int value) {
        this.ptsCount = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.channelId, stream);
        writeTLVector(this.messages, stream);
        writeInt(this.pts, stream);
        writeInt(this.ptsCount, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.channelId = readInt(stream);
        this.messages = readTLIntVector(stream, context);
        this.pts = readInt(stream);
        this.ptsCount = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateDeleteChannelMessages#c37521c9";
    }

}
