
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


public class TLRequestAccountUpdateUsername extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUser> {

    public static final int CLASS_ID = 0x3e0bdd7c;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountUpdateUsername(        String _username) {
        this.username = _username;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsUser deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsUser) {
            return (com.github.badoualy.telegram.tl.api.TLAbsUser)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsUser, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected String username;


    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.username, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.username = readTLString(stream);
    }



    @Override
    public String toString() {
        return "account.updateUsername#3e0bdd7c";
    }

}
