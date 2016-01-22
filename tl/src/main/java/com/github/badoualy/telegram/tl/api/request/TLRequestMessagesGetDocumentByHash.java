package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsDocument;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesGetDocumentByHash extends TLMethod<TLAbsDocument> {
    public static final int CLASS_ID = 0x338e2464;

    protected TLBytes sha256;

    protected int size;

    protected String mimeType;

    public TLRequestMessagesGetDocumentByHash() {
    }

    public TLRequestMessagesGetDocumentByHash(TLBytes sha256, int size, String mimeType) {
        this.sha256 = sha256;
        this.size = size;
        this.mimeType = mimeType;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsDocument deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsDocument)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsDocument) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(sha256, stream);
        writeInt(size, stream);
        writeTLString(mimeType, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        sha256 = readTLBytes(stream, context);
        size = readInt(stream);
        mimeType = readTLString(stream);
    }

    @Override
    public String toString() {
        return "messages.getDocumentByHash#338e2464";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLBytes getSha256() {
        return sha256;
    }

    public void setSha256(TLBytes sha256) {
        this.sha256 = sha256;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }
}
