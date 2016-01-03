
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestAccountCheckUsername extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x2714d86c;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountCheckUsername(        String _username) {
        this.username = _username;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
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
        return "account.checkUsername#2714d86c";
    }

}
