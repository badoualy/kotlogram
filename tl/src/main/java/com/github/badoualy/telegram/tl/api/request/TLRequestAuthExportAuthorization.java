package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.auth.TLExportedAuthorization;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAuthExportAuthorization extends TLMethod<TLExportedAuthorization> {
    public static final int CLASS_ID = 0xe5bfffcd;

    protected int dcId;

    public TLRequestAuthExportAuthorization() {
    }

    public TLRequestAuthExportAuthorization(int dcId) {
        this.dcId = dcId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLExportedAuthorization deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLExportedAuthorization)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLExportedAuthorization) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(dcId, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        dcId = readInt(stream);
    }

    @Override
    public String toString() {
        return "auth.exportAuthorization#e5bfffcd";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getDcId() {
        return dcId;
    }

    public void setDcId(int dcId) {
        this.dcId = dcId;
    }
}
