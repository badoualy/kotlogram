
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestAuthRecoverPassword extends TLMethod<com.github.badoualy.telegram.tl.api.auth.TLAuthorization> {

    public static final int CLASS_ID = 0x4ea56e92;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthRecoverPassword(        String _code) {
        this.code = _code;

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
        


    protected String code;


    public String getCode() {
        return code;
    }

    public void setCode(String value) {
        this.code = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.code, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.code = readTLString(stream);
    }



    @Override
    public String toString() {
        return "auth.recoverPassword#4ea56e92";
    }

}
