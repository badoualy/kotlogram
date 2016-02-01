package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

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
        photo = (com.github.badoualy.telegram.tl.api.TLAbsPhoto) readTLObject(stream, context);
        document = (com.github.badoualy.telegram.tl.api.TLAbsDocument) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "foundGifCached#9c750409";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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
