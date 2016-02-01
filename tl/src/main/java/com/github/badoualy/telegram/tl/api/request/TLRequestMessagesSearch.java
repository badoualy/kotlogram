package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter;
import com.github.badoualy.telegram.tl.api.messages.TLAbsMessages;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesSearch extends TLMethod<TLAbsMessages> {
    public static final int CONSTRUCTOR_ID = 0xd4569248;

    protected int flags;

    protected boolean importantOnly;

    protected TLAbsInputPeer peer;

    protected String q;

    protected TLAbsMessagesFilter filter;

    protected int minDate;

    protected int maxDate;

    protected int offset;

    protected int maxId;

    protected int limit;

    public TLRequestMessagesSearch() {
    }

    public TLRequestMessagesSearch(int flags, boolean importantOnly, TLAbsInputPeer peer, String q, TLAbsMessagesFilter filter, int minDate, int maxDate, int offset, int maxId, int limit) {
        this.flags = flags;
        this.importantOnly = importantOnly;
        this.peer = peer;
        this.q = q;
        this.filter = filter;
        this.minDate = minDate;
        this.maxDate = maxDate;
        this.offset = offset;
        this.maxId = maxId;
        this.limit = limit;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsMessages deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsMessages)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsMessages) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = importantOnly ? (flags | 1) : (flags &~ 1);

        writeInt(flags, stream);
        if ((flags & 1) != 0) writeTLBool(importantOnly, stream);
        writeTLObject(peer, stream);
        writeTLString(q, stream);
        writeTLObject(filter, stream);
        writeInt(minDate, stream);
        writeInt(maxDate, stream);
        writeInt(offset, stream);
        writeInt(maxId, stream);
        writeInt(limit, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        importantOnly = (flags & 1) != 0;
        peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer) readTLObject(stream, context);
        q = readTLString(stream);
        filter = (com.github.badoualy.telegram.tl.api.TLAbsMessagesFilter) readTLObject(stream, context);
        minDate = readInt(stream);
        maxDate = readInt(stream);
        offset = readInt(stream);
        maxId = readInt(stream);
        limit = readInt(stream);
    }

    @Override
    public String toString() {
        return "messages.search#d4569248";
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

    public boolean getImportantOnly() {
        return importantOnly;
    }

    public void setImportantOnly(boolean importantOnly) {
        this.importantOnly = importantOnly;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public TLAbsMessagesFilter getFilter() {
        return filter;
    }

    public void setFilter(TLAbsMessagesFilter filter) {
        this.filter = filter;
    }

    public int getMinDate() {
        return minDate;
    }

    public void setMinDate(int minDate) {
        this.minDate = minDate;
    }

    public int getMaxDate() {
        return maxDate;
    }

    public void setMaxDate(int maxDate) {
        this.maxDate = maxDate;
    }

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    public int getMaxId() {
        return maxId;
    }

    public void setMaxId(int maxId) {
        this.maxId = maxId;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
