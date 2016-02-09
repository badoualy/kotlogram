package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDhConfig extends TLAbsDhConfig {
    public static final int CONSTRUCTOR_ID = 0x2c221edd;

    protected int g;

    protected TLBytes p;

    protected int version;

    public TLDhConfig() {
    }

    public TLDhConfig(int g, TLBytes p, int version, TLBytes random) {
        this.g = g;
        this.p = p;
        this.version = version;
        this.random = random;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(g, stream);
        writeTLBytes(p, stream);
        writeInt(version, stream);
        writeTLBytes(random, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        g = readInt(stream);
        p = readTLBytes(stream, context);
        version = readInt(stream);
        random = readTLBytes(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(p);
        size += SIZE_INT32;
        size += computeTLBytesSerializedSize(random);
        return size;
    }

    @Override
    public String toString() {
        return "messages.dhConfig#2c221edd";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLDhConfig)) return false;
        if (object == this) return true;

        TLDhConfig o = (TLDhConfig) object;

        return g == o.g
                && (p == o.p || (p != null && o.p != null && p.equals(o.p)))
                && version == o.version
                && (random == o.random || (random != null && o.random != null && random.equals(o.random)));
    }

    public int getG() {
        return g;
    }

    public void setG(int g) {
        this.g = g;
    }

    public TLBytes getP() {
        return p;
    }

    public void setP(TLBytes p) {
        this.p = p;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public TLBytes getRandom() {
        return random;
    }

    public void setRandom(TLBytes random) {
        this.random = random;
    }
}
