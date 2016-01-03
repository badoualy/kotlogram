
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestAuthSendCall extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x3c51564;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthSendCall(        String _phoneNumber,         String _phoneCodeHash) {
        this.phoneNumber = _phoneNumber;
        this.phoneCodeHash = _phoneCodeHash;

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
        


    protected String phoneNumber;

    protected String phoneCodeHash;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    public String getPhoneCodeHash() {
        return phoneCodeHash;
    }

    public void setPhoneCodeHash(String value) {
        this.phoneCodeHash = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.phoneNumber, stream);
        writeTLString(this.phoneCodeHash, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneNumber = readTLString(stream);
        this.phoneCodeHash = readTLString(stream);
    }



    @Override
    public String toString() {
        return "auth.sendCall#3c51564";
    }

}
