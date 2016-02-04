package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLInputBotInlineResult;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesSetInlineBotResults extends TLMethod<TLBool> {
    public static final int CONSTRUCTOR_ID = 0x3f23ec12;

    protected int flags;

    protected boolean gallery;

    protected boolean _private;

    protected long queryId;

    protected TLVector<TLInputBotInlineResult> results;

    protected int cacheTime;

    protected String nextOffset;

    public TLRequestMessagesSetInlineBotResults() {
    }

    public TLRequestMessagesSetInlineBotResults(int flags, boolean gallery, boolean _private, long queryId, TLVector<TLInputBotInlineResult> results, int cacheTime, String nextOffset) {
        this.flags = flags;
        this.gallery = gallery;
        this._private = _private;
        this.queryId = queryId;
        this.results = results;
        this.cacheTime = cacheTime;
        this.nextOffset = nextOffset;
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
        flags = 0;
        flags = gallery ? (flags | 1) : (flags &~ 1);
        flags = _private ? (flags | 2) : (flags &~ 2);
        flags = nextOffset != null ? (flags | 4) : (flags &~ 4);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeBoolean(gallery, stream);
        if ((flags & 2) != 0) writeBoolean(_private, stream);
        writeLong(queryId, stream);
        writeTLVector(results, stream);
        writeInt(cacheTime, stream);
        if ((flags & 4) != 0) writeString(nextOffset, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        gallery = (flags & 1) != 0;
        _private = (flags & 2) != 0;
        queryId = readLong(stream);
        results = readTLVector(stream, context);
        cacheTime = readInt(stream);
        if ((flags & 4) != 0) nextOffset = readTLString(stream);
    }

    @Override
    public String toString() {
        return "messages.setInlineBotResults#3f23ec12";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public boolean getGallery() {
        return gallery;
    }

    public void setGallery(boolean gallery) {
        this.gallery = gallery;
    }

    public boolean getPrivate() {
        return _private;
    }

    public void setPrivate(boolean _private) {
        this._private = _private;
    }

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public TLVector<TLInputBotInlineResult> getResults() {
        return results;
    }

    public void setResults(TLVector<TLInputBotInlineResult> results) {
        this.results = results;
    }

    public int getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(int cacheTime) {
        this.cacheTime = cacheTime;
    }

    public String getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
    }
}
