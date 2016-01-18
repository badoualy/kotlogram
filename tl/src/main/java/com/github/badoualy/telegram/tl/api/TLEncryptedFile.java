
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;



public class TLEncryptedFile extends TLAbsEncryptedFile {
    public static final int CLASS_ID = 0x4a70994c;

    public TLEncryptedFile() {

    }


    public TLEncryptedFile(        long _id,         long _accessHash,         int _size,         int _dcId,         int _keyFingerprint) {
        this.id = _id;
        this.accessHash = _accessHash;
        this.size = _size;
        this.dcId = _dcId;
        this.keyFingerprint = _keyFingerprint;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long id;

    protected long accessHash;

    protected int size;

    protected int dcId;

    protected int keyFingerprint;


    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
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

    public int getKeyFingerprint() {
        return keyFingerprint;
    }

    public void setKeyFingerprint(int value) {
        this.keyFingerprint = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.id, stream);
        writeLong(this.accessHash, stream);
        writeInt(this.size, stream);
        writeInt(this.dcId, stream);
        writeInt(this.keyFingerprint, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.accessHash = readLong(stream);
        this.size = readInt(stream);
        this.dcId = readInt(stream);
        this.keyFingerprint = readInt(stream);
    }



    @Override
    public String toString() {
        return "encryptedFile#4a70994c";
    }

}
