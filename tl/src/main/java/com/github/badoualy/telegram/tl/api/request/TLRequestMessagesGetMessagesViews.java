package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPeer;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesGetMessagesViews extends TLMethod<TLVector<Integer>> {
    public static final int CLASS_ID = 0xc4c8a55d;

    protected TLAbsInputPeer peer;

    protected TLVector<Integer> id;

    protected boolean increment;

    public TLRequestMessagesGetMessagesViews() {
    }

    public TLRequestMessagesGetMessagesViews(TLAbsInputPeer peer, TLVector<Integer> id, boolean increment) {
        this.peer = peer;
        this.id = id;
        this.increment = increment;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLVector<Integer> deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLVector)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLVector<Integer>) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(peer, stream);
        writeTLVector(id, stream);
        writeTLBool(increment, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer) readTLObject(stream, context);
        id = readTLVector(stream, context);
        increment = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "messages.getMessagesViews#c4c8a55d";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(TLAbsInputPeer peer) {
        this.peer = peer;
    }

    public TLVector<Integer> getId() {
        return id;
    }

    public void setId(TLVector<Integer> id) {
        this.id = id;
    }

    public boolean getIncrement() {
        return increment;
    }

    public void setIncrement(boolean increment) {
        this.increment = increment;
    }
}
