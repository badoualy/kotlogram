package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsBotInlineResult;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
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
public class TLBotResults extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x1170b0a3;

    protected int flags;

    protected boolean gallery;

    protected long queryId;

    protected String nextOffset;

    protected TLVector<? extends TLAbsBotInlineResult> results;

    public TLBotResults() {
    }

    public TLBotResults(boolean gallery, long queryId, String nextOffset, TLVector<? extends TLAbsBotInlineResult> results) {
        this.gallery = gallery;
        this.queryId = queryId;
        this.nextOffset = nextOffset;
        this.results = results;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = gallery ? (flags | 1) : (flags &~ 1);
        flags = nextOffset != null ? (flags | 2) : (flags &~ 2);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeBoolean(gallery, stream);
        writeLong(queryId, stream);
        if ((flags & 2) != 0) writeString(nextOffset, stream);
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
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
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

    public TLVector<? extends TLAbsBotInlineResult> getResults() {
        return results;
    }

    public void setResults(TLVector<? extends TLAbsBotInlineResult> results) {
        this.results = results;
    }
}
