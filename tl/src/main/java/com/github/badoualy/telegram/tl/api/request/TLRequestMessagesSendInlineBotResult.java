package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

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
public class TLRequestMessagesSendInlineBotResult extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0xb16e06fe;

    protected int flags;

    protected boolean broadcast;

    protected TLAbsInputPeer peer;

    protected Integer replyToMsgId;

    protected long randomId;

    protected long queryId;

    protected String id;

    public TLRequestMessagesSendInlineBotResult() {
    }

    public TLRequestMessagesSendInlineBotResult(boolean broadcast, TLAbsInputPeer peer, Integer replyToMsgId, long randomId, long queryId, String id) {
        this.broadcast = broadcast;
        this.peer = peer;
        this.replyToMsgId = replyToMsgId;
        this.randomId = randomId;
        this.queryId = queryId;
        this.id = id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsUpdates deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsUpdates)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsUpdates) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = broadcast ? (flags | 16) : (flags &~ 16);
        flags = replyToMsgId != null ? (flags | 1) : (flags &~ 1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(peer, stream);
        if ((flags & 1) != 0) writeInt(replyToMsgId, stream);
        writeLong(randomId, stream);
        writeLong(queryId, stream);
        writeString(id, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        broadcast = (flags & 16) != 0;
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        replyToMsgId = (flags & 1) != 0 ? readInt(stream) : null;
        randomId = readLong(stream);
        queryId = readLong(stream);
        id = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += peer.computeSerializedSize();
        if ((flags & 1) != 0) size += SIZE_INT32;
        size += SIZE_INT64;
        size += SIZE_INT64;
        size += computeTLStringSerializedSize(id);
        return size;
    }

    @Override
    public String toString() {
        return "messages.sendInlineBotResult#b16e06fe";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestMessagesSendInlineBotResult)) return false;
        if (object == this) return true;

        TLRequestMessagesSendInlineBotResult o = (TLRequestMessagesSendInlineBotResult) object;

        return flags == o.flags
                && broadcast == o.broadcast
                && (peer == o.peer || (peer != null && o.peer != null && peer.equals(o.peer)))
                && (replyToMsgId == o.replyToMsgId || (replyToMsgId != null && o.replyToMsgId != null && replyToMsgId.equals(o.replyToMsgId)))
                && randomId == o.randomId
                && queryId == o.queryId
                && (id == o.id || (id != null && o.id != null && id.equals(o.id)));
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public Integer getReplyToMsgId() {
        return replyToMsgId;
    }

    public void setReplyToMsgId(Integer replyToMsgId) {
        this.replyToMsgId = replyToMsgId;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long randomId) {
        this.randomId = randomId;
    }

    public long getQueryId() {
        return queryId;
    }

    public void setQueryId(long queryId) {
        this.queryId = queryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
