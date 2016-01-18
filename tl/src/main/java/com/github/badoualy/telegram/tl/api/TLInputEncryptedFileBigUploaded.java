
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;



public class TLInputEncryptedFileBigUploaded extends TLAbsInputEncryptedFile {
    public static final int CLASS_ID = 0x2dc173c8;

    public TLInputEncryptedFileBigUploaded() {

    }


    public TLInputEncryptedFileBigUploaded(        long _id,         int _parts,         int _keyFingerprint) {
        this.id = _id;
        this.parts = _parts;
        this.keyFingerprint = _keyFingerprint;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long id;

    protected int parts;

    protected int keyFingerprint;


    public long getId() {
        return id;
    }

    public void setId(long value) {
        this.id = value;
    }

    public int getParts() {
        return parts;
    }

    public void setParts(int value) {
        this.parts = value;
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
        writeInt(this.parts, stream);
        writeInt(this.keyFingerprint, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readLong(stream);
        this.parts = readInt(stream);
        this.keyFingerprint = readInt(stream);
    }



    @Override
    public String toString() {
        return "inputEncryptedFileBigUploaded#2dc173c8";
    }

}
