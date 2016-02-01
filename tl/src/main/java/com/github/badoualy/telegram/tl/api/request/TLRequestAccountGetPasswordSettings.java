package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.account.TLPasswordSettings;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountGetPasswordSettings extends TLMethod<TLPasswordSettings> {
    public static final int CONSTRUCTOR_ID = 0xbc8d11bb;

    protected TLBytes currentPasswordHash;

    public TLRequestAccountGetPasswordSettings() {
    }

    public TLRequestAccountGetPasswordSettings(TLBytes currentPasswordHash) {
        this.currentPasswordHash = currentPasswordHash;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLPasswordSettings deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLPasswordSettings)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLPasswordSettings) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(currentPasswordHash, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        currentPasswordHash = readTLBytes(stream, context);
    }

    @Override
    public String toString() {
        return "account.getPasswordSettings#bc8d11bb";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLBytes getCurrentPasswordHash() {
        return currentPasswordHash;
    }

    public void setCurrentPasswordHash(TLBytes currentPasswordHash) {
        this.currentPasswordHash = currentPasswordHash;
    }
}
