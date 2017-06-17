package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readDouble;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeDouble;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputAppEvent extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x770656a8;

    protected double time;

    protected String type;

    protected long peer;

    protected String data;

    private final String _constructor = "inputAppEvent#770656a8";

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
        writeString(type, stream);
        writeLong(peer, stream);
        writeString(data, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        time = readDouble(stream);
        type = readTLString(stream);
        peer = readLong(stream);
        data = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_DOUBLE;
        size += computeTLStringSerializedSize(type);
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(data);
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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
