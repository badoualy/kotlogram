package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLVideo extends TLAbsVideo {
    public static final int CONSTRUCTOR_ID = 0xf72887d3;

    protected long accessHash;

    protected int date;

    protected int duration;

    protected String mimeType;

    protected int size;

    protected TLAbsPhotoSize thumb;

    protected int dcId;

    protected int w;

    protected int h;

    private final String _constructor = "video#f72887d3";

    public TLVideo() {
    }

    public TLVideo(long id, long accessHash, int date, int duration, String mimeType, int size, TLAbsPhotoSize thumb, int dcId, int w, int h) {
        this.id = id;
        this.accessHash = accessHash;
        this.date = date;
        this.duration = duration;
        this.mimeType = mimeType;
        this.size = size;
        this.thumb = thumb;
        this.dcId = dcId;
        this.w = w;
        this.h = h;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeInt(date, stream);
        writeInt(duration, stream);
        writeString(mimeType, stream);
        writeInt(size, stream);
        writeTLObject(thumb, stream);
        writeInt(dcId, stream);
        writeInt(w, stream);
        writeInt(h, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        accessHash = readLong(stream);
        date = readInt(stream);
        duration = readInt(stream);
        mimeType = readTLString(stream);
        size = readInt(stream);
        thumb = readTLObject(stream, context, TLAbsPhotoSize.class, -1);
        dcId = readInt(stream);
        w = readInt(stream);
        h = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(mimeType);
        size += SIZE_INT32;
        size += thumb.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
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
        if (!(object instanceof TLVideo)) return false;
        if (object == this) return true;

        TLVideo o = (TLVideo) object;

        return id == o.id
                && accessHash == o.accessHash
                && date == o.date
                && duration == o.duration
                && (mimeType == o.mimeType || (mimeType != null && o.mimeType != null && mimeType.equals(o.mimeType)))
                && size == o.size
                && (thumb == o.thumb || (thumb != null && o.thumb != null && thumb.equals(o.thumb)))
                && dcId == o.dcId
                && w == o.w
                && h == o.h;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long accessHash) {
        this.accessHash = accessHash;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
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

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public TLAbsPhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(TLAbsPhotoSize thumb) {
        this.thumb = thumb;
    }

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int dcId) {
        this.dcId = dcId;
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

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLVideo getAsVideo() {
        return this;
    }
}
