
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

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
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLDocument extends TLAbsDocument {
    public static final int CLASS_ID = 0xf9a39f4f;

    public TLDocument() {

    }


    public TLDocument(        long _id,         long _accessHash,         int _date,         String _mimeType,         int _size,         com.github.badoualy.telegram.tl.api.TLAbsPhotoSize _thumb,         int _dcId,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocumentAttribute> _attributes) {
        this.id = _id;
        this.accessHash = _accessHash;
        this.date = _date;
        this.mimeType = _mimeType;
        this.size = _size;
        this.thumb = _thumb;
        this.dcId = _dcId;
        this.attributes = _attributes;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long accessHash;

    protected int date;

    protected String mimeType;

    protected int size;

    protected com.github.badoualy.telegram.tl.api.TLAbsPhotoSize thumb;

    protected int dcId;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocumentAttribute> attributes;


    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String value) {
        this.mimeType = value;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int value) {
        this.size = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsPhotoSize getThumb() {
        return thumb;
    }

    public void setThumb(com.github.badoualy.telegram.tl.api.TLAbsPhotoSize value) {
        this.thumb = value;
    }

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int value) {
        this.dcId = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocumentAttribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsDocumentAttribute> value) {
        this.attributes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
        writeLong(this.accessHash, stream);
        writeInt(this.date, stream);
        writeTLString(this.mimeType, stream);
        writeInt(this.size, stream);
        writeTLObject(this.thumb, stream);
        writeInt(this.dcId, stream);
        writeTLVector(this.attributes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.accessHash = readLong(stream);
        this.date = readInt(stream);
        this.mimeType = readTLString(stream);
        this.size = readInt(stream);
        this.thumb = (com.github.badoualy.telegram.tl.api.TLAbsPhotoSize)readTLObject(stream, context);
        this.dcId = readInt(stream);
        this.attributes = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "document#f9a39f4f";
    }

}
