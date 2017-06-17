package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPhoneCallProtocol extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xa2bb35cb;

    protected int flags;

    protected boolean udpP2p;

    protected boolean udpReflector;

    protected int minLayer;

    protected int maxLayer;

    private final String _constructor = "phoneCallProtocol#a2bb35cb";

    public TLPhoneCallProtocol() {
    }

    public TLPhoneCallProtocol(boolean udpP2p, boolean udpReflector, int minLayer, int maxLayer) {
        this.udpP2p = udpP2p;
        this.udpReflector = udpReflector;
        this.minLayer = minLayer;
        this.maxLayer = maxLayer;
    }

    private void computeFlags() {
        flags = 0;
        flags = udpP2p ? (flags | 1) : (flags & ~1);
        flags = udpReflector ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(minLayer, stream);
        writeInt(maxLayer, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        udpP2p = (flags & 1) != 0;
        udpReflector = (flags & 2) != 0;
        minLayer = readInt(stream);
        maxLayer = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
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

    public boolean getUdpP2p() {
        return udpP2p;
    }

    public void setUdpP2p(boolean udpP2p) {
        this.udpP2p = udpP2p;
    }

    public boolean getUdpReflector() {
        return udpReflector;
    }

    public void setUdpReflector(boolean udpReflector) {
        this.udpReflector = udpReflector;
    }

    public int getMinLayer() {
        return minLayer;
    }

    public void setMinLayer(int minLayer) {
        this.minLayer = minLayer;
    }

    public int getMaxLayer() {
        return maxLayer;
    }

    public void setMaxLayer(int maxLayer) {
        this.maxLayer = maxLayer;
    }
}
