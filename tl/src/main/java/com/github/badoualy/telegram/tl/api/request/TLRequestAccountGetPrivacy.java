package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLInputPrivacyKeyStatusTimestamp;
import com.github.badoualy.telegram.tl.api.account.TLPrivacyRules;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountGetPrivacy extends TLMethod<TLPrivacyRules> {
    public static final int CONSTRUCTOR_ID = 0xdadbc950;

    protected TLInputPrivacyKeyStatusTimestamp key;

    public TLRequestAccountGetPrivacy() {
    }

    public TLRequestAccountGetPrivacy(TLInputPrivacyKeyStatusTimestamp key) {
        this.key = key;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLPrivacyRules deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLPrivacyRules)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLPrivacyRules) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(key, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        key = readTLObject(stream, context, TLInputPrivacyKeyStatusTimestamp.class, TLInputPrivacyKeyStatusTimestamp.CONSTRUCTOR_ID);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += key.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "account.getPrivacy#dadbc950";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLInputPrivacyKeyStatusTimestamp getKey() {
        return key;
    }

    public void setKey(TLInputPrivacyKeyStatusTimestamp key) {
        this.key = key;
    }
}
