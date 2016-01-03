
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestAccountUnregisterDevice extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x65c55b40;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountUnregisterDevice(        int _tokenType,         String _token) {
        this.tokenType = _tokenType;
        this.token = _token;

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
        


    protected int tokenType;

    protected String token;


    public int getTokenType() {
        return tokenType;
    }

    public void setTokenType(int value) {
        this.tokenType = value;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String value) {
        this.token = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.tokenType, stream);
        writeTLString(this.token, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.tokenType = readInt(stream);
        this.token = readTLString(stream);
    }



    @Override
    public String toString() {
        return "account.unregisterDevice#65c55b40";
    }

}
