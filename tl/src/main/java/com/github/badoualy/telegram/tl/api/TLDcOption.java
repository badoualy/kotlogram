
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLDcOption extends TLObject {

    public static final int CLASS_ID = 0x5d8c6cc;

    public TLDcOption() {

    }


    public TLDcOption(        int _flags,         boolean _ipv6,         boolean _mediaOnly,         int _id,         String _ipAddress,         int _port) {
        this.flags = _flags;
        this.ipv6 = _ipv6;
        this.mediaOnly = _mediaOnly;
        this.id = _id;
        this.ipAddress = _ipAddress;
        this.port = _port;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected boolean ipv6;

    protected boolean mediaOnly;

    protected int id;

    protected String ipAddress;

    protected int port;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getIpv6() {
        return ipv6;
    }

    public void setIpv6(boolean value) {
        this.ipv6 = value;
    }

    public boolean getMediaOnly() {
        return mediaOnly;
    }

    public void setMediaOnly(boolean value) {
        this.mediaOnly = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String value) {
        this.ipAddress = value;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int value) {
        this.port = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = ipv6 ? (flags | 1) : (flags &~ 1);
        flags = mediaOnly ? (flags | 2) : (flags &~ 2);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.ipv6, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.mediaOnly, stream);
        writeInt(this.id, stream);
        writeTLString(this.ipAddress, stream);
        writeInt(this.port, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.ipv6 = (this.flags & 1) != 0;
        this.mediaOnly = (this.flags & 2) != 0;
        this.id = readInt(stream);
        this.ipAddress = readTLString(stream);
        this.port = readInt(stream);
    }


    @Override
    public String toString() {
        return "dcOption#5d8c6cc";
    }

}
