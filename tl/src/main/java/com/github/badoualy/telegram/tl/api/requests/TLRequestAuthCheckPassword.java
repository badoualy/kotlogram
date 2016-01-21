
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


public class TLRequestAuthCheckPassword extends TLMethod<com.github.badoualy.telegram.tl.api.auth.TLAuthorization> {

    public static final int CLASS_ID = 0xa63011e;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthCheckPassword(        TLBytes _passwordHash) {
        this.passwordHash = _passwordHash;

    }



    public com.github.badoualy.telegram.tl.api.auth.TLAuthorization deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.auth.TLAuthorization) {
            return (com.github.badoualy.telegram.tl.api.auth.TLAuthorization)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.auth.TLAuthorization, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected TLBytes passwordHash;


    public TLBytes getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(TLBytes value) {
        this.passwordHash = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBytes(this.passwordHash, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.passwordHash = readTLBytes(stream, context);
    }



    @Override
    public String toString() {
        return "auth.checkPassword#a63011e";
    }

}
