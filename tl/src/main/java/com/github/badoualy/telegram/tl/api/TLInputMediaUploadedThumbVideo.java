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
public class TLInputMediaUploadedThumbVideo extends TLAbsInputMedia {
    public static final int CONSTRUCTOR_ID = 0x7780ddf9;

    protected TLAbsInputFile file;

    protected TLAbsInputFile thumb;

    protected int duration;

    protected int w;

    protected int h;

    protected String mimeType;

    protected String caption;

    public TLInputMediaUploadedThumbVideo() {
    }

    public TLInputMediaUploadedThumbVideo(TLAbsInputFile file, TLAbsInputFile thumb, int duration, int w, int h, String mimeType, String caption) {
        this.file = file;
        this.thumb = thumb;
        this.duration = duration;
        this.w = w;
        this.h = h;
        this.mimeType = mimeType;
        this.caption = caption;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(file, stream);
        writeTLObject(thumb, stream);
        writeInt(duration, stream);
        writeInt(w, stream);
        writeInt(h, stream);
        writeString(mimeType, stream);
        writeString(caption, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        file = readTLObject(stream, context, TLAbsInputFile.class, -1);
        thumb = readTLObject(stream, context, TLAbsInputFile.class, -1);
        duration = readInt(stream);
        w = readInt(stream);
        h = readInt(stream);
        mimeType = readTLString(stream);
        caption = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += file.computeSerializedSize();
        size += thumb.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(mimeType);
        size += computeTLStringSerializedSize(caption);
        return size;
    }

    @Override
    public String toString() {
        return "inputMediaUploadedThumbVideo#7780ddf9";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLInputMediaUploadedThumbVideo)) return false;
        if (object == this) return true;

        TLInputMediaUploadedThumbVideo o = (TLInputMediaUploadedThumbVideo) object;

        return (file == o.file || (file != null && o.file != null && file.equals(o.file)))
                && (thumb == o.thumb || (thumb != null && o.thumb != null && thumb.equals(o.thumb)))
                && duration == o.duration
                && w == o.w
                && h == o.h
                && (mimeType == o.mimeType || (mimeType != null && o.mimeType != null && mimeType.equals(o.mimeType)))
                && (caption == o.caption || (caption != null && o.caption != null && caption.equals(o.caption)));
    }

    public TLAbsInputFile getFile() {
        return file;
    }

    public void setFile(TLAbsInputFile file) {
        this.file = file;
    }

    public TLAbsInputFile getThumb() {
        return thumb;
    }

    public void setThumb(TLAbsInputFile thumb) {
        this.thumb = thumb;
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

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }
}
