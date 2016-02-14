package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.core.TLIntVector;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesGetMessagesViews extends TLMethod<TLIntVector> {
    public static final int CONSTRUCTOR_ID = 0xc4c8a55d;

    protected TLAbsInputPeer peer;

    protected TLIntVector id;

    protected boolean increment;

    private final String _constructor = "messages.getMessagesViews#c4c8a55d";

    public TLRequestMessagesGetMessagesViews() {
    }

    public TLRequestMessagesGetMessagesViews(TLAbsInputPeer peer, TLIntVector id, boolean increment) {
        this.peer = peer;
        this.id = id;
        this.increment = increment;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLIntVector deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLIntVector)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLIntVector) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLVector(id, stream);
        writeBoolean(increment, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = readTLObject(stream, context, TLAbsInputPeer.class, -1);
        id = readTLIntVector(stream, context);
        increment = readTLBool(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += peer.computeSerializedSize();
        size += id.computeSerializedSize();
        size += SIZE_BOOLEAN;
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
        if (!(object instanceof TLRequestMessagesGetMessagesViews)) return false;
        if (object == this) return true;

        TLRequestMessagesGetMessagesViews o = (TLRequestMessagesGetMessagesViews) object;

        return (peer == o.peer || (peer != null && o.peer != null && peer.equals(o.peer)))
                && (id == o.id || (id != null && o.id != null && id.equals(o.id)))
                && increment == o.increment;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLIntVector getId() {
        return id;
    }

    public void setId(TLIntVector id) {
        this.id = id;
    }

    public boolean getIncrement() {
        return increment;
    }

    public void setIncrement(boolean increment) {
        this.increment = increment;
    }
}
