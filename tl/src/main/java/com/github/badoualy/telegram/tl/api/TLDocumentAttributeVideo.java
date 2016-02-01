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
public class TLDocumentAttributeVideo extends TLAbsDocumentAttribute {
    public static final int CONSTRUCTOR_ID = 0x5910cccb;

    protected int duration;

    protected int w;

    protected int h;

    public TLDocumentAttributeVideo() {
    }

    public TLDocumentAttributeVideo(int duration, int w, int h) {
        this.duration = duration;
        this.w = w;
        this.h = h;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(duration, stream);
        writeInt(w, stream);
        writeInt(h, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        duration = readInt(stream);
        w = readInt(stream);
        h = readInt(stream);
    }

    @Override
    public String toString() {
        return "documentAttributeVideo#5910cccb";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
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
