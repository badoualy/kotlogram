package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.api.TLAbsUpdates;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLLongVector;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLLongVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesForwardMessages extends TLMethod<TLAbsUpdates> {
    public static final int CONSTRUCTOR_ID = 0x708e0195;

    protected int flags;

    protected boolean broadcast;

    protected TLAbsInputPeer fromPeer;

    protected TLIntVector id;

    protected TLLongVector randomId;

    protected TLAbsInputPeer toPeer;

    private final String _constructor = "messages.forwardMessages#708e0195";

    public TLRequestMessagesForwardMessages() {
    }

    public TLRequestMessagesForwardMessages(boolean broadcast, TLAbsInputPeer fromPeer, TLIntVector id, TLLongVector randomId, TLAbsInputPeer toPeer) {
        this.broadcast = broadcast;
        this.fromPeer = fromPeer;
        this.id = id;
        this.randomId = randomId;
        this.toPeer = toPeer;
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
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeTLObject(fromPeer, stream);
        writeTLVector(id, stream);
        writeTLVector(randomId, stream);
        writeTLObject(toPeer, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        broadcast = (flags & 16) != 0;
        fromPeer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        id = readTLIntVector(stream, context);
        randomId = readTLLongVector(stream, context);
        toPeer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += fromPeer.computeSerializedSize();
        size += id.computeSerializedSize();
        size += randomId.computeSerializedSize();
        size += toPeer.computeSerializedSize();
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

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestMessagesForwardMessages)) return false;
        if (object == this) return true;

        TLRequestMessagesForwardMessages o = (TLRequestMessagesForwardMessages) object;

        return flags == o.flags
                && broadcast == o.broadcast
                && (fromPeer == o.fromPeer || (fromPeer != null && o.fromPeer != null && fromPeer.equals(o.fromPeer)))
                && (id == o.id || (id != null && o.id != null && id.equals(o.id)))
                && (randomId == o.randomId || (randomId != null && o.randomId != null && randomId.equals(o.randomId)))
                && (toPeer == o.toPeer || (toPeer != null && o.toPeer != null && toPeer.equals(o.toPeer)));
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean broadcast) {
        this.broadcast = broadcast;
    }

    public TLAbsInputPeer getFromPeer() {
        return fromPeer;
    }

    public void setFromPeer(TLAbsInputPeer fromPeer) {
        this.fromPeer = fromPeer;
    }

    public TLIntVector getId() {
        return id;
    }

    public void setId(TLIntVector id) {
        this.id = id;
    }

    public TLLongVector getRandomId() {
        return randomId;
    }

    public void setRandomId(TLLongVector randomId) {
        this.randomId = randomId;
    }

    public TLAbsInputPeer getToPeer() {
        return toPeer;
    }

    public void setToPeer(TLAbsInputPeer toPeer) {
        this.toPeer = toPeer;
    }
}
