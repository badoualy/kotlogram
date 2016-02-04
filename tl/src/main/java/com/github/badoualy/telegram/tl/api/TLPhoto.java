package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPhoto extends TLAbsPhoto {
    public static final int CONSTRUCTOR_ID = 0xcded42fe;

    protected long accessHash;

    protected int date;

    protected TLVector<? extends TLAbsPhotoSize> sizes;

    public TLPhoto() {
    }

    public TLPhoto(long id, long accessHash, int date, TLVector<? extends TLAbsPhotoSize> sizes) {
        this.id = id;
        this.accessHash = accessHash;
        this.date = date;
        this.sizes = sizes;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeInt(date, stream);
        writeTLVector(sizes, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        accessHash = readLong(stream);
        date = readInt(stream);
        sizes = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "photo#cded42fe";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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

    public TLVector<? extends TLAbsPhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(TLVector<? extends TLAbsPhotoSize> sizes) {
        this.sizes = sizes;
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
    public final TLPhoto getAsPhoto() {
        return this;
    }
}
