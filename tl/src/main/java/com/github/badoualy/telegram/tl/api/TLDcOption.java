
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLDcOption extends TLObject {

    public static final int CLASS_ID = 0x2ec2a43c;

    public TLDcOption() {

    }


    public TLDcOption(        int _id,         String _hostname,         String _ipAddress,         int _port) {
        this.id = _id;
        this.hostname = _hostname;
        this.ipAddress = _ipAddress;
        this.port = _port;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int id;

    protected String hostname;

    protected String ipAddress;

    protected int port;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String value) {
        this.hostname = value;
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

        writeInt(this.id, stream);
        writeTLString(this.hostname, stream);
        writeTLString(this.ipAddress, stream);
        writeInt(this.port, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.hostname = readTLString(stream);
        this.ipAddress = readTLString(stream);
        this.port = readInt(stream);
    }


    @Override
    public String toString() {
        return "dcOption#2ec2a43c";
    }

}
