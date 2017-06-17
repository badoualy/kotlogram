package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdateBotInlineQuery extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0x54826690;

    protected int flags;

    protected long queryId;

    protected int userId;

    protected String query;

    protected TLAbsGeoPoint geo;

    protected String offset;

    private final String _constructor = "updateBotInlineQuery#54826690";

    public TLUpdateBotInlineQuery() {
    }

    public TLUpdateBotInlineQuery(long queryId, int userId, String query, TLAbsGeoPoint geo, String offset) {
        this.queryId = queryId;
        this.userId = userId;
        this.query = query;
        this.geo = geo;
        this.offset = offset;
    }

    private void computeFlags() {
        flags = 0;
        flags = geo != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(queryId, stream);
        writeInt(userId, stream);
        writeString(query, stream);
        if ((flags & 1) != 0) {
            if (geo == null) throwNullFieldException("geo", flags);
            writeTLObject(geo, stream);
        }
        writeString(offset, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        queryId = readLong(stream);
        userId = readInt(stream);
        query = readTLString(stream);
        geo = (flags & 1) != 0 ? readTLObject(stream, context, TLAbsGeoPoint.class, -1) : null;
        offset = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(query);
        if ((flags & 1) != 0) {
            if (geo == null) throwNullFieldException("geo", flags);
            size += geo.computeSerializedSize();
        }
        size += computeTLStringSerializedSize(offset);
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public TLAbsGeoPoint getGeo() {
        return geo;
    }

    public void setGeo(TLAbsGeoPoint geo) {
        this.geo = geo;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }
}
