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
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLVideo extends TLAbsVideo {
    public static final int CLASS_ID = 0xf72887d3;

    protected long accessHash;

    protected int date;

    protected int duration;

    protected String mimeType;

    protected int size;

    protected TLAbsPhotoSize thumb;

    protected int dcId;

    protected int w;

    protected int h;

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
        writeTLString(mimeType, stream);
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
        thumb = (com.github.badoualy.telegram.tl.api.TLAbsPhotoSize) readTLObject(stream, context);
        dcId = readInt(stream);
        w = readInt(stream);
        h = readInt(stream);
    }

    @Override
    public String toString() {
        return "video#f72887d3";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
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
}
