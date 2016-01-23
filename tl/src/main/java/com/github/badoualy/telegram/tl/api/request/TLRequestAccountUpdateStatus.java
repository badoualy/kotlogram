package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountUpdateStatus extends TLMethod<TLBool> {
    public static final int CLASS_ID = 0x6628562c;

    protected boolean offline;

    public TLRequestAccountUpdateStatus() {
    }

    public TLRequestAccountUpdateStatus(boolean offline) {
        this.offline = offline;
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
        writeTLBool(offline, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        offline = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "account.updateStatus#6628562c";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public boolean getOffline() {
        return offline;
    }

    public void setOffline(boolean offline) {
        this.offline = offline;
    }
}
