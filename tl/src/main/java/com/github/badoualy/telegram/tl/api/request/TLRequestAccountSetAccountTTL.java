package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAccountDaysTTL;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountSetAccountTTL extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x2442485e;

    protected TLAccountDaysTTL ttl;

    public TLRequestAccountSetAccountTTL() {
    }

    public TLRequestAccountSetAccountTTL(TLAccountDaysTTL ttl) {
        this.ttl = ttl;
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
        writeTLObject(ttl, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        ttl = (com.github.badoualy.telegram.tl.api.TLAccountDaysTTL) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "account.setAccountTTL#2442485e";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLAccountDaysTTL getTtl() {
        return ttl;
    }

    public void setTtl(TLAccountDaysTTL ttl) {
        this.ttl = ttl;
    }
}
