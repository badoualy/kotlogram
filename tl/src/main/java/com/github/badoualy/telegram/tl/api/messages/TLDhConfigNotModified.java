package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDhConfigNotModified extends TLAbsDhConfig {
    public static final int CONSTRUCTOR_ID = 0xc0e24635;

    private final String _constructor = "messages.dhConfigNotModified#c0e24635";

    public TLDhConfigNotModified() {
    }

    public TLDhConfigNotModified(TLBytes random) {
        this.random = random;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(random, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        random = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLBytesSerializedSize(random);
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
        if (!(object instanceof TLDhConfigNotModified)) return false;
        if (object == this) return true;

        TLDhConfigNotModified o = (TLDhConfigNotModified) object;

        return (random == o.random || (random != null && o.random != null && random.equals(o.random)));
    }

    public TLBytes getRandom() {
        return random;
    }

    public void setRandom(TLBytes random) {
        this.random = random;
    }
}
