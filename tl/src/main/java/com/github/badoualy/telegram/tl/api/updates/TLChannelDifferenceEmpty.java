package com.github.badoualy.telegram.tl.api.updates;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelDifferenceEmpty extends TLAbsChannelDifference {
    public static final int CONSTRUCTOR_ID = 0x3e11affb;

    public TLChannelDifferenceEmpty() {
    }

    public TLChannelDifferenceEmpty(int flags, boolean _final, int pts, int timeout) {
        this.flags = flags;
        this._final = _final;
        this.pts = pts;
        this.timeout = timeout;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = _final ? (flags | 1) : (flags &~ 1);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeTLBool(_final, stream);
        writeInt(pts, stream);
        if ((flags & 2) != 0) writeInt(timeout, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        _final = (flags & 1) != 0;
        pts = readInt(stream);
        if ((flags & 2) != 0) timeout = readInt(stream);
    }

    @Override
    public String toString() {
        return "updates.channelDifferenceEmpty#3e11affb";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public boolean getFinal() {
        return _final;
    }

    public void setFinal(boolean _final) {
        this._final = _final;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int pts) {
        this.pts = pts;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }
}
