package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPhotoSize extends TLAbsPhotoSize {
    public static final int CLASS_ID = 0x77bfb61b;

    protected TLAbsFileLocation location;

    protected int w;

    protected int h;

    protected int size;

    public TLPhotoSize() {
    }

    public TLPhotoSize(String type, TLAbsFileLocation location, int w, int h, int size) {
        this.type = type;
        this.location = location;
        this.w = w;
        this.h = h;
        this.size = size;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(type, stream);
        writeTLObject(location, stream);
        writeInt(w, stream);
        writeInt(h, stream);
        writeInt(size, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        type = readTLString(stream);
        location = (com.github.badoualy.telegram.tl.api.TLAbsFileLocation) readTLObject(stream, context);
        w = readInt(stream);
        h = readInt(stream);
        size = readInt(stream);
    }

    @Override
    public String toString() {
        return "photoSize#77bfb61b";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TLAbsFileLocation getLocation() {
        return location;
    }

    public void setLocation(TLAbsFileLocation location) {
        this.location = location;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
