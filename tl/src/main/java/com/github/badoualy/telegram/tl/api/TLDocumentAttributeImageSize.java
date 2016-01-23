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
public class TLDocumentAttributeImageSize extends TLAbsDocumentAttribute {
    public static final int CLASS_ID = 0x6c37c15c;

    protected int w;

    protected int h;

    public TLDocumentAttributeImageSize() {
    }

    public TLDocumentAttributeImageSize(int w, int h) {
        this.w = w;
        this.h = h;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(w, stream);
        writeInt(h, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        w = readInt(stream);
        h = readInt(stream);
    }

    @Override
    public String toString() {
        return "documentAttributeImageSize#6c37c15c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
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
}
