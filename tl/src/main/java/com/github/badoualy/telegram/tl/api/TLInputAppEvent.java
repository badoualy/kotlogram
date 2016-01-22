package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputAppEvent extends TLObject {
    public static final int CLASS_ID = 0x770656a8;

    protected double time;

    protected String type;

    protected long peer;

    protected String data;

    public TLInputAppEvent() {
    }

    public TLInputAppEvent(double time, String type, long peer, String data) {
        this.time = time;
        this.type = type;
        this.peer = peer;
        this.data = data;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeDouble(time, stream);
        writeTLString(type, stream);
        writeLong(peer, stream);
        writeTLString(data, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        time = readDouble(stream);
        type = readTLString(stream);
        peer = readLong(stream);
        data = readTLString(stream);
    }

    @Override
    public String toString() {
        return "inputAppEvent#770656a8";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public double getTime() {
        return time;
    }

    public void setTime(double time) {
        this.time = time;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPeer() {
        return peer;
    }

    public void setPeer(long peer) {
        this.peer = peer;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
