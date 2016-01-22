package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation;
import com.github.badoualy.telegram.tl.api.upload.TLFile;
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
public class TLRequestUploadGetFile extends TLMethod<TLFile> {
    public static final int CLASS_ID = 0xe3a6cfb5;

    protected TLAbsInputFileLocation location;

    protected int offset;

    protected int limit;

    public TLRequestUploadGetFile() {
    }

    public TLRequestUploadGetFile(TLAbsInputFileLocation location, int offset, int limit) {
        this.location = location;
        this.offset = offset;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLFile deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLFile)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLFile) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(location, stream);
        writeInt(offset, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        location = (com.github.badoualy.telegram.tl.api.TLAbsInputFileLocation) readTLObject(stream, context);
        offset = readInt(stream);
        limit = readInt(stream);
    }

    @Override
    public String toString() {
        return "upload.getFile#e3a6cfb5";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputFileLocation getLocation() {
        return location;
    }

    public void setLocation(TLAbsInputFileLocation location) {
        this.location = location;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
