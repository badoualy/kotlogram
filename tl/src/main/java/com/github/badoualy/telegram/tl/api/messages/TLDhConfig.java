
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



public class TLDhConfig extends TLAbsDhConfig {
    public static final int CLASS_ID = 0x2c221edd;

    public TLDhConfig() {

    }


    public TLDhConfig(        int _g,         TLBytes _p,         int _version,         TLBytes _random) {
        this.g = _g;
        this.p = _p;
        this.version = _version;
        this.random = _random;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int g;

    protected TLBytes p;

    protected int version;


    public int getG() {
        return g;
    }

    public void setG(int value) {
        this.g = value;
    }

    public TLBytes getP() {
        return p;
    }

    public void setP(TLBytes value) {
        this.p = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.g, stream);
        writeTLBytes(this.p, stream);
        writeInt(this.version, stream);
        writeTLBytes(this.random, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.g = readInt(stream);
        this.p = readTLBytes(stream, context);
        this.version = readInt(stream);
        this.random = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "messages.dhConfig#2c221edd";
    }

}
