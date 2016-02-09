package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputChatUploadedPhoto extends TLAbsInputChatPhoto {
    public static final int CONSTRUCTOR_ID = 0x94254732;

    protected TLAbsInputFile file;

    protected TLAbsInputPhotoCrop crop;

    public TLInputChatUploadedPhoto() {
    }

    public TLInputChatUploadedPhoto(TLAbsInputFile file, TLAbsInputPhotoCrop crop) {
        this.file = file;
        this.crop = crop;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(file, stream);
        writeTLObject(crop, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        file = readTLObject(stream, context, TLAbsInputFile.class, -1);
        crop = readTLObject(stream, context, TLAbsInputPhotoCrop.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += file.computeSerializedSize();
        size += crop.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "inputChatUploadedPhoto#94254732";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputChatUploadedPhoto)) return false;
        if (object == this) return true;

        TLInputChatUploadedPhoto o = (TLInputChatUploadedPhoto) object;

        return (file == o.file || (file != null && o.file != null && file.equals(o.file)))
                && (crop == o.crop || (crop != null && o.crop != null && crop.equals(o.crop)));
    }

    public TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputFile file) {
        this.file = file;
    }

    public TLAbsInputPhotoCrop getCrop() {
        return crop;
    }

    public void setCrop(TLAbsInputPhotoCrop crop) {
        this.crop = crop;
    }
}
