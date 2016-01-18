
package com.github.badoualy.telegram.tl.api.requests;

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


public class TLRequestAuthBindTempAuthKey extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0xcdd42a05;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthBindTempAuthKey(        long _permAuthKeyId,         long _nonce,         int _expiresAt,         TLBytes _encryptedMessage) {
        this.permAuthKeyId = _permAuthKeyId;
        this.nonce = _nonce;
        this.expiresAt = _expiresAt;
        this.encryptedMessage = _encryptedMessage;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected long permAuthKeyId;

    protected long nonce;

    protected int expiresAt;

    protected TLBytes encryptedMessage;


    public long getPermAuthKeyId() {
        return permAuthKeyId;
    }

    public void setPermAuthKeyId(long value) {
        this.permAuthKeyId = value;
    }

    public long getNonce() {
        return nonce;
    }

    public void setNonce(long value) {
        this.nonce = value;
    }

    public int getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(int value) {
        this.expiresAt = value;
    }

    public TLBytes getEncryptedMessage() {
        return encryptedMessage;
    }

    public void setEncryptedMessage(TLBytes value) {
        this.encryptedMessage = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.permAuthKeyId, stream);
        writeLong(this.nonce, stream);
        writeInt(this.expiresAt, stream);
        writeTLBytes(this.encryptedMessage, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.permAuthKeyId = readLong(stream);
        this.nonce = readLong(stream);
        this.expiresAt = readInt(stream);
        this.encryptedMessage = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "auth.bindTempAuthKey#cdd42a05";
    }

}
