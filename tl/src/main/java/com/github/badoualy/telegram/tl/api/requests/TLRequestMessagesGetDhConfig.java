
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;


public class TLRequestMessagesGetDhConfig extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig> {

    public static final int CLASS_ID = 0x26cf8950;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesGetDhConfig(        int _version,         int _randomLength) {
        this.version = _version;
        this.randomLength = _randomLength;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsDhConfig, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int version;

    protected int randomLength;


    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }

    public int getRandomLength() {
        return randomLength;
    }

    public void setRandomLength(int value) {
        this.randomLength = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.version, stream);
        writeInt(this.randomLength, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.version = readInt(stream);
        this.randomLength = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.getDhConfig#26cf8950";
    }

}
