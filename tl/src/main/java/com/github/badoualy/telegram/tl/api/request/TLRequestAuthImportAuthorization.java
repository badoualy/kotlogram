package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.auth.TLAuthorization;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAuthImportAuthorization extends TLMethod<TLAuthorization> {
    public static final int CLASS_ID = 0xe3ef9613;

    protected int id;

    protected TLBytes bytes;

    public TLRequestAuthImportAuthorization() {
    }

    public TLRequestAuthImportAuthorization(int id, TLBytes bytes) {
        this.id = id;
        this.bytes = bytes;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAuthorization deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAuthorization)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAuthorization) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(id, stream);
        writeTLBytes(bytes, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readInt(stream);
        bytes = readTLBytes(stream, context);
    }

    @Override
    public String toString() {
        return "auth.importAuthorization#e3ef9613";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TLBytes getBytes() {
        return bytes;
    }

    public void setBytes(TLBytes bytes) {
        this.bytes = bytes;
    }
}
