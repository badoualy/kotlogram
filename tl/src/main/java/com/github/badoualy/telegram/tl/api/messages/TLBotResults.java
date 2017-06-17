package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsBotInlineResult;
import com.github.badoualy.telegram.tl.api.TLInlineBotSwitchPM;
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
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotResults extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xccd3563d;

    protected int flags;

    protected boolean gallery;

    protected long queryId;

    protected String nextOffset;

    protected TLInlineBotSwitchPM switchPm;

    protected TLVector<TLAbsBotInlineResult> results;

    protected int cacheTime;

    private final String _constructor = "messages.botResults#ccd3563d";

    public TLBotResults() {
    }

    public TLBotResults(boolean gallery, long queryId, String nextOffset, TLInlineBotSwitchPM switchPm, TLVector<TLAbsBotInlineResult> results, int cacheTime) {
        this.gallery = gallery;
        this.queryId = queryId;
        this.nextOffset = nextOffset;
        this.switchPm = switchPm;
        this.results = results;
        this.cacheTime = cacheTime;
    }

    private void computeFlags() {
        flags = 0;
        flags = gallery ? (flags | 1) : (flags & ~1);
        flags = nextOffset != null ? (flags | 2) : (flags & ~2);
        flags = switchPm != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(queryId, stream);
        if ((flags & 2) != 0) {
            if (nextOffset == null) throwNullFieldException("nextOffset", flags);
            writeString(nextOffset, stream);
        }
        if ((flags & 4) != 0) {
            if (switchPm == null) throwNullFieldException("switchPm", flags);
            writeTLObject(switchPm, stream);
        }
        writeTLVector(results, stream);
        writeInt(cacheTime, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        gallery = (flags & 1) != 0;
        queryId = readLong(stream);
        nextOffset = (flags & 2) != 0 ? readTLString(stream) : null;
        switchPm = (flags & 4) != 0 ? readTLObject(stream, context, TLInlineBotSwitchPM.class,
                                                   TLInlineBotSwitchPM.CONSTRUCTOR_ID) : null;
        results = readTLVector(stream, context);
        cacheTime = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        if ((flags & 2) != 0) {
            if (nextOffset == null) throwNullFieldException("nextOffset", flags);
            size += computeTLStringSerializedSize(nextOffset);
        }
        if ((flags & 4) != 0) {
            if (switchPm == null) throwNullFieldException("switchPm", flags);
            size += switchPm.computeSerializedSize();
        }
        size += results.computeSerializedSize();
        size += SIZE_INT32;
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

    public TLInlineBotSwitchPM getSwitchPm() {
        return switchPm;
    }

    public void setSwitchPm(TLInlineBotSwitchPM switchPm) {
        this.switchPm = switchPm;
    }

    public TLVector<TLAbsBotInlineResult> getResults() {
        return results;
    }

    public void setResults(TLVector<TLAbsBotInlineResult> results) {
        this.results = results;
    }

    public int getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(int cacheTime) {
        this.cacheTime = cacheTime;
    }
}
