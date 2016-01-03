
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLPhoto extends TLAbsPhoto {
    public static final int CLASS_ID = 0x22b56751;

    public TLPhoto() {

    }


    public TLPhoto(        long _id,         long _accessHash,         int _userId,         int _date,         String _caption,         com.github.badoualy.telegram.tl.api.TLAbsGeoPoint _geo,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhotoSize> _sizes) {
        this.id = _id;
        this.accessHash = _accessHash;
        this.userId = _userId;
        this.date = _date;
        this.caption = _caption;
        this.geo = _geo;
        this.sizes = _sizes;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long accessHash;

    protected int userId;

    protected int date;

    protected String caption;

    protected com.github.badoualy.telegram.tl.api.TLAbsGeoPoint geo;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhotoSize> sizes;


    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String value) {
        this.caption = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(com.github.badoualy.telegram.tl.api.TLAbsGeoPoint value) {
        this.geo = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhotoSize> getSizes() {
        return sizes;
    }

    public void setSizes(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsPhotoSize> value) {
        this.sizes = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
        writeLong(this.accessHash, stream);
        writeInt(this.userId, stream);
        writeInt(this.date, stream);
        writeTLString(this.caption, stream);
        writeTLObject(this.geo, stream);
        writeTLVector(this.sizes, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.accessHash = readLong(stream);
        this.userId = readInt(stream);
        this.date = readInt(stream);
        this.caption = readTLString(stream);
        this.geo = (com.github.badoualy.telegram.tl.api.TLAbsGeoPoint)readTLObject(stream, context);
        this.sizes = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "photo#22b56751";
    }

}
