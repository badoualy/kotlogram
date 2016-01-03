
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLInputAppEvent extends TLObject {

    public static final int CLASS_ID = 0x770656a8;

    public TLInputAppEvent() {

    }


    public TLInputAppEvent(        double _time,         String _type,         long _peer,         String _data) {
        this.time = _time;
        this.type = _type;
        this.peer = _peer;
        this.data = _data;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected double time;

    protected String type;

    protected long peer;

    protected String data;


    public double getTime() {
        return time;
    }

    public void setTime(double value) {
        this.time = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public long getPeer() {
        return peer;
    }

    public void setPeer(long value) {
        this.peer = value;
    }

    public String getData() {
        return data;
    }

    public void setData(String value) {
        this.data = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeDouble(this.time, stream);
        writeTLString(this.type, stream);
        writeLong(this.peer, stream);
        writeTLString(this.data, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.time = readDouble(stream);
        this.type = readTLString(stream);
        this.peer = readLong(stream);
        this.data = readTLString(stream);
    }


    @Override
    public String toString() {
        return "inputAppEvent#770656a8";
    }

}
