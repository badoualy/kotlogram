package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readDouble;
import static com.github.badoualy.telegram.tl.StreamUtils.writeDouble;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPhotoCrop extends TLAbsInputPhotoCrop {
    public static final int CLASS_ID = 0xd9915325;

    protected double cropLeft;

    protected double cropTop;

    protected double cropWidth;

    public TLInputPhotoCrop() {
    }

    public TLInputPhotoCrop(double cropLeft, double cropTop, double cropWidth) {
        this.cropLeft = cropLeft;
        this.cropTop = cropTop;
        this.cropWidth = cropWidth;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeDouble(cropLeft, stream);
        writeDouble(cropTop, stream);
        writeDouble(cropWidth, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        cropLeft = readDouble(stream);
        cropTop = readDouble(stream);
        cropWidth = readDouble(stream);
    }

    @Override
    public String toString() {
        return "inputPhotoCrop#d9915325";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public double getCropLeft() {
        return cropLeft;
    }

    public void setCropLeft(double cropLeft) {
        this.cropLeft = cropLeft;
    }

    public double getCropTop() {
        return cropTop;
    }

    public void setCropTop(double cropTop) {
        this.cropTop = cropTop;
    }

    public double getCropWidth() {
        return cropWidth;
    }

    public void setCropWidth(double cropWidth) {
        this.cropWidth = cropWidth;
    }
}
