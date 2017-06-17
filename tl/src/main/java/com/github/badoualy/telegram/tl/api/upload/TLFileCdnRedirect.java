package com.github.badoualy.telegram.tl.api.upload;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFileCdnRedirect extends TLAbsFile {

    public static final int CONSTRUCTOR_ID = 0x1508485a;

    protected int dcId;

    protected TLBytes fileToken;

    protected TLBytes encryptionKey;

    protected TLBytes encryptionIv;

    private final String _constructor = "upload.fileCdnRedirect#1508485a";

    public TLFileCdnRedirect() {
    }

    public TLFileCdnRedirect(int dcId, TLBytes fileToken, TLBytes encryptionKey, TLBytes encryptionIv) {
        this.dcId = dcId;
        this.fileToken = fileToken;
        this.encryptionKey = encryptionKey;
        this.encryptionIv = encryptionIv;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(dcId, stream);
        writeTLBytes(fileToken, stream);
        writeTLBytes(encryptionKey, stream);
        writeTLBytes(encryptionIv, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        dcId = readInt(stream);
        fileToken = readTLBytes(stream, context);
        encryptionKey = readTLBytes(stream, context);
        encryptionIv = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(fileToken);
        size += computeTLBytesSerializedSize(encryptionKey);
        size += computeTLBytesSerializedSize(encryptionIv);
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int dcId) {
        this.dcId = dcId;
    }

    public TLBytes getFileToken() {
        return fileToken;
    }

    public void setFileToken(TLBytes fileToken) {
        this.fileToken = fileToken;
    }

    public TLBytes getEncryptionKey() {
        return encryptionKey;
    }

    public void setEncryptionKey(TLBytes encryptionKey) {
        this.encryptionKey = encryptionKey;
    }

    public TLBytes getEncryptionIv() {
        return encryptionIv;
    }

    public void setEncryptionIv(TLBytes encryptionIv) {
        this.encryptionIv = encryptionIv;
    }
}
