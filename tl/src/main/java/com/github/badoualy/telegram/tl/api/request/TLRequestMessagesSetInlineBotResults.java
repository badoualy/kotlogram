package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputBotInlineResult;
import com.github.badoualy.telegram.tl.api.TLInlineBotSwitchPM;
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
public class TLRequestMessagesSetInlineBotResults extends TLMethod<TLBool> {

    public static final int CONSTRUCTOR_ID = 0xeb5ea206;

    protected int flags;

    protected boolean gallery;

    protected boolean _private;

    protected long queryId;

    protected TLVector<TLAbsInputBotInlineResult> results;

    protected int cacheTime;

    protected String nextOffset;

    protected TLInlineBotSwitchPM switchPm;

    private final String _constructor = "messages.setInlineBotResults#eb5ea206";

    public TLRequestMessagesSetInlineBotResults() {
    }

    public TLRequestMessagesSetInlineBotResults(boolean gallery, boolean _private, long queryId, TLVector<TLAbsInputBotInlineResult> results, int cacheTime, String nextOffset, TLInlineBotSwitchPM switchPm) {
        this.gallery = gallery;
        this._private = _private;
        this.queryId = queryId;
        this.results = results;
        this.cacheTime = cacheTime;
        this.nextOffset = nextOffset;
        this.switchPm = switchPm;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLBool)) {
            throw new IOException(
                    "Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response
                            .getClass().getCanonicalName());
        }
        return (TLBool) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = gallery ? (flags | 1) : (flags & ~1);
        flags = _private ? (flags | 2) : (flags & ~2);
        flags = nextOffset != null ? (flags | 4) : (flags & ~4);
        flags = switchPm != null ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeLong(queryId, stream);
        writeTLVector(results, stream);
        writeInt(cacheTime, stream);
        if ((flags & 4) != 0) {
            if (nextOffset == null) throwNullFieldException("nextOffset", flags);
            writeString(nextOffset, stream);
        }
        if ((flags & 8) != 0) {
            if (switchPm == null) throwNullFieldException("switchPm", flags);
            writeTLObject(switchPm, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        gallery = (flags & 1) != 0;
        _private = (flags & 2) != 0;
        queryId = readLong(stream);
        results = readTLVector(stream, context);
        cacheTime = readInt(stream);
        nextOffset = (flags & 4) != 0 ? readTLString(stream) : null;
        switchPm = (flags & 8) != 0 ? readTLObject(stream, context, TLInlineBotSwitchPM.class,
                                                   TLInlineBotSwitchPM.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT64;
        size += results.computeSerializedSize();
        size += SIZE_INT32;
        if ((flags & 4) != 0) {
            if (nextOffset == null) throwNullFieldException("nextOffset", flags);
            size += computeTLStringSerializedSize(nextOffset);
        }
        if ((flags & 8) != 0) {
            if (switchPm == null) throwNullFieldException("switchPm", flags);
            size += switchPm.computeSerializedSize();
        }
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

    public TLVector<TLAbsInputBotInlineResult> getResults() {
        return results;
    }

    public void setResults(TLVector<TLAbsInputBotInlineResult> results) {
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

    public TLInlineBotSwitchPM getSwitchPm() {
        return switchPm;
    }

    public void setSwitchPm(TLInlineBotSwitchPM switchPm) {
        this.switchPm = switchPm;
    }
}
