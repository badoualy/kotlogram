package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocument extends TLAbsDocument {
    public static final int CONSTRUCTOR_ID = 0xf9a39f4f;

    protected long accessHash;

    protected int date;

    protected String mimeType;

    protected int size;

    protected TLAbsPhotoSize thumb;

    protected int dcId;

    protected TLVector<TLAbsDocumentAttribute> attributes;

    public TLDocument() {
    }

    public TLDocument(long id, long accessHash, int date, String mimeType, int size, TLAbsPhotoSize thumb, int dcId, TLVector<TLAbsDocumentAttribute> attributes) {
        this.id = id;
        this.accessHash = accessHash;
        this.date = date;
        this.mimeType = mimeType;
        this.size = size;
        this.thumb = thumb;
        this.dcId = dcId;
        this.attributes = attributes;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(id, stream);
        writeLong(accessHash, stream);
        writeInt(date, stream);
        writeString(mimeType, stream);
        writeInt(size, stream);
        writeTLObject(thumb, stream);
        writeInt(dcId, stream);
        writeTLVector(attributes, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        accessHash = readLong(stream);
        date = readInt(stream);
        mimeType = readTLString(stream);
        size = readInt(stream);
        thumb = readTLObject(stream, context, TLAbsPhotoSize.class, -1);
        dcId = readInt(stream);
        attributes = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(mimeType);
        size += SIZE_INT32;
        size += thumb.computeSerializedSize();
        size += SIZE_INT32;
        size += attributes.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "document#f9a39f4f";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLDocument)) return false;
        if (object == this) return true;

        TLDocument o = (TLDocument) object;

        return id == o.id
                && accessHash == o.accessHash
                && date == o.date
                && (mimeType == o.mimeType || (mimeType != null && o.mimeType != null && mimeType.equals(o.mimeType)))
                && size == o.size
                && (thumb == o.thumb || (thumb != null && o.thumb != null && thumb.equals(o.thumb)))
                && dcId == o.dcId
                && (attributes == o.attributes || (attributes != null && o.attributes != null && attributes.equals(o.attributes)));
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

    public TLVector<TLAbsDocumentAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(TLVector<TLAbsDocumentAttribute> attributes) {
        this.attributes = attributes;
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
    public final TLDocument getAsDocument() {
        return this;
    }
}
