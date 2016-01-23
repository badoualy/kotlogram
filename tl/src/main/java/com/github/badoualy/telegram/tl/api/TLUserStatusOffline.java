package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUserStatusOffline extends TLAbsUserStatus {
    public static final int CLASS_ID = 0x8c703f;

    protected int wasOnline;

    public TLUserStatusOffline() {
    }

    public TLUserStatusOffline(int wasOnline) {
        this.wasOnline = wasOnline;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(wasOnline, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        wasOnline = readInt(stream);
    }

    @Override
    public String toString() {
        return "userStatusOffline#8c703f";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getWasOnline() {
        return wasOnline;
    }

    public void setWasOnline(int wasOnline) {
        this.wasOnline = wasOnline;
    }
}
