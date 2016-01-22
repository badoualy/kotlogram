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
public class TLMessageGroup extends TLObject {
    public static final int CLASS_ID = 0xe8346f53;

    protected int minId;

    protected int maxId;

    protected int count;

    protected int date;

    public TLMessageGroup() {
    }

    public TLMessageGroup(int minId, int maxId, int count, int date) {
        this.minId = minId;
        this.maxId = maxId;
        this.count = count;
        this.date = date;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(minId, stream);
        writeInt(maxId, stream);
        writeInt(count, stream);
        writeInt(date, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        minId = readInt(stream);
        maxId = readInt(stream);
        count = readInt(stream);
        date = readInt(stream);
    }

    @Override
    public String toString() {
        return "messageGroup#e8346f53";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getMinId() {
        return minId;
    }

    public void setMinId(int minId) {
        this.minId = minId;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }
}
