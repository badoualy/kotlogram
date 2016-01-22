package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputUser;
import com.github.badoualy.telegram.tl.api.photos.TLAbsPhotos;
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
public class TLRequestPhotosGetUserPhotos extends TLMethod<TLAbsPhotos> {
    public static final int CLASS_ID = 0x91cd32a8;

    protected TLAbsInputUser userId;

    protected int offset;

    protected long maxId;

    protected int limit;

    public TLRequestPhotosGetUserPhotos() {
    }

    public TLRequestPhotosGetUserPhotos(TLAbsInputUser userId, int offset, long maxId, int limit) {
        this.userId = userId;
        this.offset = offset;
        this.maxId = maxId;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsPhotos deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsPhotos)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsPhotos) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(userId, stream);
        writeInt(offset, stream);
        writeLong(maxId, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        userId = (com.github.badoualy.telegram.tl.api.TLAbsInputUser) readTLObject(stream, context);
        offset = readInt(stream);
        maxId = readLong(stream);
        limit = readInt(stream);
    }

    @Override
    public String toString() {
        return "photos.getUserPhotos#91cd32a8";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(TLAbsInputUser userId) {
        this.userId = userId;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public long getMaxId() {
        return maxId;
    }

    public void setMaxId(long maxId) {
        this.maxId = maxId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
