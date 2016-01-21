
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateReadHistoryOutbox extends TLAbsUpdate {
    public static final int CLASS_ID = 0x2f2f21bf;

    public TLUpdateReadHistoryOutbox() {

    }


    public TLUpdateReadHistoryOutbox(        com.github.badoualy.telegram.tl.api.TLAbsPeer _peer,         int _maxId,         int _pts,         int _ptsCount) {
        this.peer = _peer;
        this.maxId = _maxId;
        this.pts = _pts;
        this.ptsCount = _ptsCount;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsPeer peer;

    protected int maxId;

    protected int pts;

    protected int ptsCount;


    public com.github.badoualy.telegram.tl.api.TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsPeer value) {
        this.peer = value;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int value) {
        this.maxId = value;
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

        writeTLObject(this.peer, stream);
        writeInt(this.maxId, stream);
        writeInt(this.pts, stream);
        writeInt(this.ptsCount, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsPeer)readTLObject(stream, context);
        this.maxId = readInt(stream);
        this.pts = readInt(stream);
        this.ptsCount = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateReadHistoryOutbox#2f2f21bf";
    }

}
