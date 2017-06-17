package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDcOption extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x5d8c6cc;

    protected int flags;

    protected boolean ipv6;

    protected boolean mediaOnly;

    protected boolean tcpoOnly;

    protected boolean cdn;

    protected int id;

    protected String ipAddress;

    protected int port;

    private final String _constructor = "dcOption#5d8c6cc";

    public TLDcOption() {
    }

    public TLDcOption(boolean ipv6, boolean mediaOnly, boolean tcpoOnly, boolean cdn, int id, String ipAddress, int port) {
        this.ipv6 = ipv6;
        this.mediaOnly = mediaOnly;
        this.tcpoOnly = tcpoOnly;
        this.cdn = cdn;
        this.id = id;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    private void computeFlags() {
        flags = 0;
        flags = ipv6 ? (flags | 1) : (flags & ~1);
        flags = mediaOnly ? (flags | 2) : (flags & ~2);
        flags = tcpoOnly ? (flags | 4) : (flags & ~4);
        flags = cdn ? (flags | 8) : (flags & ~8);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeString(ipAddress, stream);
        writeInt(port, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        ipv6 = (flags & 1) != 0;
        mediaOnly = (flags & 2) != 0;
        tcpoOnly = (flags & 4) != 0;
        cdn = (flags & 8) != 0;
        id = readInt(stream);
        ipAddress = readTLString(stream);
        port = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(ipAddress);
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

    public boolean getIpv6() {
        return ipv6;
    }

    public void setIpv6(boolean ipv6) {
        this.ipv6 = ipv6;
    }

    public boolean getMediaOnly() {
        return mediaOnly;
    }

    public void setMediaOnly(boolean mediaOnly) {
        this.mediaOnly = mediaOnly;
    }

    public boolean getTcpoOnly() {
        return tcpoOnly;
    }

    public void setTcpoOnly(boolean tcpoOnly) {
        this.tcpoOnly = tcpoOnly;
    }

    public boolean getCdn() {
        return cdn;
    }

    public void setCdn(boolean cdn) {
        this.cdn = cdn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }
}
