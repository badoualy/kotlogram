package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateShort extends TLAbsUpdates {
    public static final int CONSTRUCTOR_ID = 0x78d4dec1;

    protected TLAbsUpdate update;

    protected int date;

    public TLUpdateShort() {
    }

    public TLUpdateShort(TLAbsUpdate update, int date) {
        this.update = update;
        this.date = date;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(update, stream);
        writeInt(date, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        update = (com.github.badoualy.telegram.tl.api.TLAbsUpdate) readTLObject(stream, context);
        date = readInt(stream);
    }

    @Override
    public String toString() {
        return "updateShort#78d4dec1";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAbsUpdate getUpdate() {
        return update;
    }

    public void setUpdate(TLAbsUpdate update) {
        this.update = update;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
