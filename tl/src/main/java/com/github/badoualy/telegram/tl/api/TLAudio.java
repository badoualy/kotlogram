
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLAudio extends TLAbsAudio {
    public static final int CLASS_ID = 0xc7ac6496;

    public TLAudio() {

    }


    public TLAudio(        long _id,         long _accessHash,         int _userId,         int _date,         int _duration,         String _mimeType,         int _size,         int _dcId) {
        this.id = _id;
        this.accessHash = _accessHash;
        this.userId = _userId;
        this.date = _date;
        this.duration = _duration;
        this.mimeType = _mimeType;
        this.size = _size;
        this.dcId = _dcId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long accessHash;

    protected int userId;

    protected int date;

    protected int duration;

    protected String mimeType;

    protected int size;

    protected int dcId;


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

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int value) {
        this.dcId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
        writeLong(this.accessHash, stream);
        writeInt(this.userId, stream);
        writeInt(this.date, stream);
        writeInt(this.duration, stream);
        writeTLString(this.mimeType, stream);
        writeInt(this.size, stream);
        writeInt(this.dcId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.accessHash = readLong(stream);
        this.userId = readInt(stream);
        this.date = readInt(stream);
        this.duration = readInt(stream);
        this.mimeType = readTLString(stream);
        this.size = readInt(stream);
        this.dcId = readInt(stream);
    }



    @Override
    public String toString() {
        return "audio#c7ac6496";
    }

}
