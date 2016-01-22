package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.auth.TLPasswordRecovery;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAuthRequestPasswordRecovery extends TLMethod<TLPasswordRecovery> {
    public static final int CLASS_ID = 0xd897bc66;

    public TLRequestAuthRequestPasswordRecovery() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLPasswordRecovery deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLPasswordRecovery)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLPasswordRecovery) response;
    }

    @Override
    public String toString() {
        return "auth.requestPasswordRecovery#d897bc66";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
