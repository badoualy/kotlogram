
package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLAffectedMessages extends TLObject {

    public static final int CLASS_ID = 0x84d19185;

    public TLAffectedMessages() {

    }


    public TLAffectedMessages(        int _pts,         int _ptsCount) {
        this.pts = _pts;
        this.ptsCount = _ptsCount;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int pts;

    protected int ptsCount;


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

        writeInt(this.pts, stream);
        writeInt(this.ptsCount, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.pts = readInt(stream);
        this.ptsCount = readInt(stream);
    }


    @Override
    public String toString() {
        return "messages.affectedMessages#84d19185";
    }

}
