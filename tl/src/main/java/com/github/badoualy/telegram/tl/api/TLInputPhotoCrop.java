package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readDouble;
import static com.github.badoualy.telegram.tl.StreamUtils.writeDouble;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_DOUBLE;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputPhotoCrop extends TLAbsInputPhotoCrop {
    public static final int CONSTRUCTOR_ID = 0xd9915325;

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
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_DOUBLE;
        size += SIZE_DOUBLE;
        size += SIZE_DOUBLE;
        return size;
    }

    @Override
    public String toString() {
        return "inputPhotoCrop#d9915325";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputPhotoCrop)) return false;
        if (object == this) return true;

        TLInputPhotoCrop o = (TLInputPhotoCrop) object;

        return cropLeft == o.cropLeft
                && cropTop == o.cropTop
                && cropWidth == o.cropWidth;
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
