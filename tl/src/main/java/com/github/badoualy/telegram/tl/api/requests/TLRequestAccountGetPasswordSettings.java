
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;


public class TLRequestAccountGetPasswordSettings extends TLMethod<com.github.badoualy.telegram.tl.api.account.TLPasswordSettings> {

    public static final int CLASS_ID = 0xbc8d11bb;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountGetPasswordSettings(        TLBytes _currentPasswordHash) {
        this.currentPasswordHash = _currentPasswordHash;

    }



    public com.github.badoualy.telegram.tl.api.account.TLPasswordSettings deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.account.TLPasswordSettings) {
            return (com.github.badoualy.telegram.tl.api.account.TLPasswordSettings)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.account.TLPasswordSettings, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected TLBytes currentPasswordHash;


    public TLBytes getCurrentPasswordHash() {
        return currentPasswordHash;
    }

    public void setCurrentPasswordHash(TLBytes value) {
        this.currentPasswordHash = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBytes(this.currentPasswordHash, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.currentPasswordHash = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "account.getPasswordSettings#bc8d11bb";
    }

}
