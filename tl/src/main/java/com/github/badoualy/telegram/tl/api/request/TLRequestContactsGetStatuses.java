package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLContactStatus;
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
public class TLRequestContactsGetStatuses extends TLMethod<TLVector<TLContactStatus>> {
    public static final int CONSTRUCTOR_ID = 0xc4a353ee;

    public TLRequestContactsGetStatuses() {
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLVector<TLContactStatus> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLVector)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLVector<TLContactStatus>) response;
    }

    @Override
    public String toString() {
        return "contacts.getStatuses#c4a353ee";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestContactsGetStatuses)) return false;
        if (object == this) return true;

        TLRequestContactsGetStatuses o = (TLRequestContactsGetStatuses) object;

        return true;
    }
}
