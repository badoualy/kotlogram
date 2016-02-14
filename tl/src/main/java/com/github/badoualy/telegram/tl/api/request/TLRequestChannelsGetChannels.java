package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputChannel;
import com.github.badoualy.telegram.tl.api.messages.TLChats;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestChannelsGetChannels extends TLMethod<TLChats> {
    public static final int CONSTRUCTOR_ID = 0xa7f6bbb;

    protected TLVector<TLAbsInputChannel> id;

    private final String _constructor = "channels.getChannels#a7f6bbb";

    public TLRequestChannelsGetChannels() {
    }

    public TLRequestChannelsGetChannels(TLVector<TLAbsInputChannel> id) {
        this.id = id;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLChats deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLChats)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLChats) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(id, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += id.computeSerializedSize();
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
        if (!(object instanceof TLRequestChannelsGetChannels)) return false;
        if (object == this) return true;

        TLRequestChannelsGetChannels o = (TLRequestChannelsGetChannels) object;

        return (id == o.id || (id != null && o.id != null && id.equals(o.id)));
    }

    public TLVector<TLAbsInputChannel> getId() {
        return id;
    }

    public void setId(TLVector<TLAbsInputChannel> id) {
        this.id = id;
    }
}
