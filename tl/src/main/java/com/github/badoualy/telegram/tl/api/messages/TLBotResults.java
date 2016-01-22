package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsBotInlineResult;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;
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
public class TLBotResults extends TLObject {
    public static final int CLASS_ID = 0x1170b0a3;

    protected int flags;

    protected boolean gallery;

    protected long queryId;

    protected String nextOffset;

    protected TLVector<TLAbsBotInlineResult> results;

    public TLBotResults() {
    }

    public TLBotResults(int flags, boolean gallery, long queryId, String nextOffset, TLVector<TLAbsBotInlineResult> results) {
        this.flags = flags;
        this.gallery = gallery;
        this.queryId = queryId;
        this.nextOffset = nextOffset;
        this.results = results;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(flags, stream);
        if ((flags & 1) != 0) writeTLBool(gallery, stream);
        writeLong(queryId, stream);
        if ((flags & 2) != 0) writeTLString(nextOffset, stream);
        writeTLVector(results, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        gallery = (flags & 1) != 0;
        queryId = readLong(stream);
        if ((flags & 2) != 0) nextOffset = readTLString(stream);
        results = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "messages.botResults#1170b0a3";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
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

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public String getNextOffset() {
        return nextOffset;
    }

    public void setNextOffset(String nextOffset) {
        this.nextOffset = nextOffset;
    }

    public TLVector<TLAbsBotInlineResult> getResults() {
        return results;
    }

    public void setResults(TLVector<TLAbsBotInlineResult> results) {
        this.results = results;
    }
}
