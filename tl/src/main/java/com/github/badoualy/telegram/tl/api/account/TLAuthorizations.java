package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAuthorization;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLAuthorizations extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x1250abde;

    protected TLVector<? extends TLAuthorization> authorizations;

    public TLAuthorizations() {
    }

    public TLAuthorizations(TLVector<? extends TLAuthorization> authorizations) {
        this.authorizations = authorizations;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(authorizations, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        authorizations = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += authorizations.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "account.authorizations#1250abde";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLAuthorizations)) return false;
        if (object == this) return true;

        TLAuthorizations o = (TLAuthorizations) object;

        return (authorizations == o.authorizations || (authorizations != null && o.authorizations != null && authorizations.equals(o.authorizations)));
    }

    public TLVector<? extends TLAuthorization> getAuthorizations() {
        return authorizations;
    }

    public void setAuthorizations(TLVector<? extends TLAuthorization> authorizations) {
        this.authorizations = authorizations;
    }
}
