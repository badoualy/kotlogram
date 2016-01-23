package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountUpdatePasswordSettings extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0xfa7c4b86;

    protected TLBytes currentPasswordHash;

    protected TLPasswordInputSettings newSettings;

    public TLRequestAccountUpdatePasswordSettings() {
    }

    public TLRequestAccountUpdatePasswordSettings(TLBytes currentPasswordHash, TLPasswordInputSettings newSettings) {
        this.currentPasswordHash = currentPasswordHash;
        this.newSettings = newSettings;
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
        writeTLBytes(currentPasswordHash, stream);
        writeTLObject(newSettings, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        currentPasswordHash = readTLBytes(stream, context);
        newSettings = (com.github.badoualy.telegram.tl.api.account.TLPasswordInputSettings) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "account.updatePasswordSettings#fa7c4b86";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLBytes getCurrentPasswordHash() {
        return currentPasswordHash;
    }

    public void setCurrentPasswordHash(TLBytes currentPasswordHash) {
        this.currentPasswordHash = currentPasswordHash;
    }

    public TLPasswordInputSettings getNewSettings() {
        return newSettings;
    }

    public void setNewSettings(TLPasswordInputSettings newSettings) {
        this.newSettings = newSettings;
    }
}
