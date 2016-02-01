package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsWallPaper;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountGetWallPapers extends TLMethod<TLVector<TLAbsWallPaper>> {
    public static final int CONSTRUCTOR_ID = 0xc04cfac2;

    public TLRequestAccountGetWallPapers() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLVector<TLAbsWallPaper> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLVector)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLVector<TLAbsWallPaper>) response;
    }

    @Override
    public String toString() {
        return "account.getWallPapers#c04cfac2";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }
}
