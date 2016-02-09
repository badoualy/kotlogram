package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestMessagesGetDhConfig extends TLMethod<TLAbsDhConfig> {
    public static final int CONSTRUCTOR_ID = 0x26cf8950;

    protected int version;

    protected int randomLength;

    public TLRequestMessagesGetDhConfig() {
    }

    public TLRequestMessagesGetDhConfig(int version, int randomLength) {
        this.version = version;
        this.randomLength = randomLength;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsDhConfig deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsDhConfig)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsDhConfig) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(version, stream);
        writeInt(randomLength, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        version = readInt(stream);
        randomLength = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return "messages.getDhConfig#26cf8950";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLRequestMessagesGetDhConfig)) return false;
        if (object == this) return true;

        TLRequestMessagesGetDhConfig o = (TLRequestMessagesGetDhConfig) object;

        return version == o.version
                && randomLength == o.randomLength;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getRandomLength() {
        return randomLength;
    }

    public void setRandomLength(int randomLength) {
        this.randomLength = randomLength;
    }
}
