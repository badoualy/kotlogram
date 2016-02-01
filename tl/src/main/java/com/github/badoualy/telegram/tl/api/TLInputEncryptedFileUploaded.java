package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputEncryptedFileUploaded extends TLAbsInputEncryptedFile {
    public static final int CONSTRUCTOR_ID = 0x64bd0306;

    protected long id;

    protected int parts;

    protected String md5Checksum;

    protected int keyFingerprint;

    public TLInputEncryptedFileUploaded() {
    }

    public TLInputEncryptedFileUploaded(long id, int parts, String md5Checksum, int keyFingerprint) {
        this.id = id;
        this.parts = parts;
        this.md5Checksum = md5Checksum;
        this.keyFingerprint = keyFingerprint;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(id, stream);
        writeInt(parts, stream);
        writeTLString(md5Checksum, stream);
        writeInt(keyFingerprint, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readLong(stream);
        parts = readInt(stream);
        md5Checksum = readTLString(stream);
        keyFingerprint = readInt(stream);
    }

    @Override
    public String toString() {
        return "inputEncryptedFileUploaded#64bd0306";
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

    public int getParts() {
        return parts;
    }

    public void setParts(int parts) {
        this.parts = parts;
    }

    public String getMd5Checksum() {
        return md5Checksum;
    }

    public void setMd5Checksum(String md5Checksum) {
        this.md5Checksum = md5Checksum;
    }

    public int getKeyFingerprint() {
        return keyFingerprint;
    }

    public void setKeyFingerprint(int keyFingerprint) {
        this.keyFingerprint = keyFingerprint;
    }
}
