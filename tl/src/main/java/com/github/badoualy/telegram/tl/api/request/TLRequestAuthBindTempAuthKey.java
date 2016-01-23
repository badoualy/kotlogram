package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAuthBindTempAuthKey extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0xcdd42a05;

    protected long permAuthKeyId;

    protected long nonce;

    protected int expiresAt;

    protected TLBytes encryptedMessage;

    public TLRequestAuthBindTempAuthKey() {
    }

    public TLRequestAuthBindTempAuthKey(long permAuthKeyId, long nonce, int expiresAt, TLBytes encryptedMessage) {
        this.permAuthKeyId = permAuthKeyId;
        this.nonce = nonce;
        this.expiresAt = expiresAt;
        this.encryptedMessage = encryptedMessage;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLBool) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(permAuthKeyId, stream);
        writeLong(nonce, stream);
        writeInt(expiresAt, stream);
        writeTLBytes(encryptedMessage, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        permAuthKeyId = readLong(stream);
        nonce = readLong(stream);
        expiresAt = readInt(stream);
        encryptedMessage = readTLBytes(stream, context);
    }

    @Override
    public String toString() {
        return "auth.bindTempAuthKey#cdd42a05";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public long getPermAuthKeyId() {
        return permAuthKeyId;
    }

    public void setPermAuthKeyId(long permAuthKeyId) {
        this.permAuthKeyId = permAuthKeyId;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long nonce) {
        this.nonce = nonce;
    }

    public int getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(int expiresAt) {
        this.expiresAt = expiresAt;
    }

    public TLBytes getEncryptedMessage() {
        return encryptedMessage;
    }

    public void setEncryptedMessage(TLBytes encryptedMessage) {
        this.encryptedMessage = encryptedMessage;
    }
}
