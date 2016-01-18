
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


public class TLRequestAuthSignIn extends TLMethod<com.github.badoualy.telegram.tl.api.auth.TLAuthorization> {

    public static final int CLASS_ID = 0xbcd51581;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthSignIn(        String _phoneNumber,         String _phoneCodeHash,         String _phoneCode) {
        this.phoneNumber = _phoneNumber;
        this.phoneCodeHash = _phoneCodeHash;
        this.phoneCode = _phoneCode;

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
        


    protected String phoneNumber;

    protected String phoneCodeHash;

    protected String phoneCode;


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

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String value) {
        this.phoneCode = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.phoneNumber, stream);
        writeTLString(this.phoneCodeHash, stream);
        writeTLString(this.phoneCode, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneNumber = readTLString(stream);
        this.phoneCodeHash = readTLString(stream);
        this.phoneCode = readTLString(stream);
    }



    @Override
    public String toString() {
        return "auth.signIn#bcd51581";
    }

}
