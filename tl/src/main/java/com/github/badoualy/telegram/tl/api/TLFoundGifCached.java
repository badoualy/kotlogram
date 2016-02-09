package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFoundGifCached extends TLAbsFoundGif {
    public static final int CONSTRUCTOR_ID = 0x9c750409;

    protected TLAbsPhoto photo;

    protected TLAbsDocument document;

    public TLFoundGifCached() {
    }

    public TLFoundGifCached(String url, TLAbsPhoto photo, TLAbsDocument document) {
        this.url = url;
        this.photo = photo;
        this.document = document;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(url, stream);
        writeTLObject(photo, stream);
        writeTLObject(document, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        url = readTLString(stream);
        photo = readTLObject(stream, context, TLAbsPhoto.class, -1);
        document = readTLObject(stream, context, TLAbsDocument.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(url);
        size += photo.computeSerializedSize();
        size += document.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "foundGifCached#9c750409";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLFoundGifCached)) return false;
        if (object == this) return true;

        TLFoundGifCached o = (TLFoundGifCached) object;

        return (url == o.url || (url != null && o.url != null && url.equals(o.url)))
                && (photo == o.photo || (photo != null && o.photo != null && photo.equals(o.photo)))
                && (document == o.document || (document != null && o.document != null && document.equals(o.document)));
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }
}
