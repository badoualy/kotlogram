package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputMediaUploadedAudio extends TLAbsInputMedia {
    public static final int CONSTRUCTOR_ID = 0x4e498cab;

    protected TLAbsInputFile file;

    protected int duration;

    protected String mimeType;

    private final String _constructor = "inputMediaUploadedAudio#4e498cab";

    public TLInputMediaUploadedAudio() {
    }

    public TLInputMediaUploadedAudio(TLAbsInputFile file, int duration, String mimeType) {
        this.file = file;
        this.duration = duration;
        this.mimeType = mimeType;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(file, stream);
        writeInt(duration, stream);
        writeString(mimeType, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        file = readTLObject(stream, context, TLAbsInputFile.class, -1);
        duration = readInt(stream);
        mimeType = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += file.computeSerializedSize();
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(mimeType);
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputMediaUploadedAudio)) return false;
        if (object == this) return true;

        TLInputMediaUploadedAudio o = (TLInputMediaUploadedAudio) object;

        return (file == o.file || (file != null && o.file != null && file.equals(o.file)))
                && duration == o.duration
                && (mimeType == o.mimeType || (mimeType != null && o.mimeType != null && mimeType.equals(o.mimeType)));
    }

    public TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputFile file) {
        this.file = file;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
