
package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLAffectedHistory extends TLObject {

    public static final int CLASS_ID = 0xb45c69d1;

    public TLAffectedHistory() {

    }


    public TLAffectedHistory(        int _pts,         int _ptsCount,         int _offset) {
        this.pts = _pts;
        this.ptsCount = _ptsCount;
        this.offset = _offset;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int pts;

    protected int ptsCount;

    protected int offset;


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

    public int getOffset() {
        return offset;
    }

    public void setOffset(int value) {
        this.offset = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.pts, stream);
        writeInt(this.ptsCount, stream);
        writeInt(this.offset, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.pts = readInt(stream);
        this.ptsCount = readInt(stream);
        this.offset = readInt(stream);
    }


    @Override
    public String toString() {
        return "messages.affectedHistory#b45c69d1";
    }

}
