package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLReceivedNotifyMessage extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xa384b779;

    protected int id;

    protected int flags;

    public TLReceivedNotifyMessage() {
    }

    public TLReceivedNotifyMessage(int id, int flags) {
        this.id = id;
        this.flags = flags;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(id, stream);
        writeInt(flags, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readInt(stream);
        flags = readInt(stream);
    }

    @Override
    public String toString() {
        return "receivedNotifyMessage#a384b779";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }
}
