
package com.github.badoualy.telegram.tl.api.updates;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;



public class TLDifferenceEmpty extends TLAbsDifference {
    public static final int CLASS_ID = 0x5d75a138;

    public TLDifferenceEmpty() {

    }


    public TLDifferenceEmpty(        int _date,         int _seq) {
        this.date = _date;
        this.seq = _seq;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int date;

    protected int seq;


    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int value) {
        this.seq = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.date, stream);
        writeInt(this.seq, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.date = readInt(stream);
        this.seq = readInt(stream);
    }



    @Override
    public String toString() {
        return "updates.differenceEmpty#5d75a138";
    }

}
