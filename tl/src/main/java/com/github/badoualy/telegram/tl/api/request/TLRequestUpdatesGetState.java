package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.updates.TLState;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestUpdatesGetState extends TLMethod<TLState> {
    public static final int CLASS_ID = 0xedd4882a;

    public TLRequestUpdatesGetState() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLState deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLState)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLState) response;
    }

    @Override
    public String toString() {
        return "updates.getState#edd4882a";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }
}
