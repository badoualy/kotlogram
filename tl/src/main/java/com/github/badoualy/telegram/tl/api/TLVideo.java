
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLVideo extends TLAbsVideo {
    public static final int CLASS_ID = 0x388fa391;

    public TLVideo() {

    }


    public TLVideo(        long _id,         long _accessHash,         int _userId,         int _date,         String _caption,         int _duration,         String _mimeType,         int _size,         com.github.badoualy.telegram.tl.api.TLAbsPhotoSize _thumb,         int _dcId,         int _w,         int _h) {
        this.id = _id;
        this.accessHash = _accessHash;
        this.userId = _userId;
        this.date = _date;
        this.caption = _caption;
        this.duration = _duration;
        this.mimeType = _mimeType;
        this.size = _size;
        this.thumb = _thumb;
        this.dcId = _dcId;
        this.w = _w;
        this.h = _h;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long accessHash;

    protected int userId;

    protected int date;

    protected String caption;

    protected int duration;

    protected String mimeType;

    protected int size;

    protected com.github.badoualy.telegram.tl.api.TLAbsPhotoSize thumb;

    protected int dcId;

    protected int w;

    protected int h;


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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int value) {
        this.duration = value;
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

    public int getW() {
        return w;
    }

    public void setW(int value) {
        this.w = value;
    }

    public int getH() {
        return h;
    }

    public void setH(int value) {
        this.h = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
        writeLong(this.accessHash, stream);
        writeInt(this.userId, stream);
        writeInt(this.date, stream);
        writeTLString(this.caption, stream);
        writeInt(this.duration, stream);
        writeTLString(this.mimeType, stream);
        writeInt(this.size, stream);
        writeTLObject(this.thumb, stream);
        writeInt(this.dcId, stream);
        writeInt(this.w, stream);
        writeInt(this.h, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.accessHash = readLong(stream);
        this.userId = readInt(stream);
        this.date = readInt(stream);
        this.caption = readTLString(stream);
        this.duration = readInt(stream);
        this.mimeType = readTLString(stream);
        this.size = readInt(stream);
        this.thumb = (com.github.badoualy.telegram.tl.api.TLAbsPhotoSize)readTLObject(stream, context);
        this.dcId = readInt(stream);
        this.w = readInt(stream);
        this.h = readInt(stream);
    }



    @Override
    public String toString() {
        return "video#388fa391";
    }

}
