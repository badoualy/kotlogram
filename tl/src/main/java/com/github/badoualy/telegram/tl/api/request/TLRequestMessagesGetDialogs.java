package com.github.badoualy.telegram.tl.api.request;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDialogs;
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
public class TLRequestMessagesGetDialogs extends TLMethod<TLAbsDialogs> {
    public static final int CLASS_ID = 0x6b47f94d;

    protected int offsetDate;

    protected int offsetId;

    protected TLAbsInputPeer offsetPeer;

    protected int limit;

    public TLRequestMessagesGetDialogs() {
    }

    public TLRequestMessagesGetDialogs(int offsetDate, int offsetId, TLAbsInputPeer offsetPeer, int limit) {
        this.offsetDate = offsetDate;
        this.offsetId = offsetId;
        this.offsetPeer = offsetPeer;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsDialogs deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsDialogs)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsDialogs) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(offsetDate, stream);
        writeInt(offsetId, stream);
        writeTLObject(offsetPeer, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        offsetDate = readInt(stream);
        offsetId = readInt(stream);
        offsetPeer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer) readTLObject(stream, context);
        limit = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.getDialogs#6b47f94d";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getOffsetDate() {
        return offsetDate;
    }

    public void setOffsetDate(int offsetDate) {
        this.offsetDate = offsetDate;
    }

    public int getOffsetId() {
        return offsetId;
    }

    public void setOffsetId(int offsetId) {
        this.offsetId = offsetId;
    }

    public TLAbsInputPeer getOffsetPeer() {
        return offsetPeer;
    }

    public void setOffsetPeer(TLAbsInputPeer offsetPeer) {
        this.offsetPeer = offsetPeer;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
