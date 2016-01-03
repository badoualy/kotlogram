
package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLAffectedHistory extends TLObject {

    public static final int CLASS_ID = 0xb7de36f2;

    public TLAffectedHistory() {

    }


    public TLAffectedHistory(        int _pts,         int _seq,         int _offset) {
        this.pts = _pts;
        this.seq = _seq;
        this.offset = _offset;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int pts;

    protected int seq;

    protected int offset;


    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int value) {
        this.seq = value;
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
        writeInt(this.seq, stream);
        writeInt(this.offset, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.pts = readInt(stream);
        this.seq = readInt(stream);
        this.offset = readInt(stream);
    }


    @Override
    public String toString() {
        return "messages.affectedHistory#b7de36f2";
    }

}
