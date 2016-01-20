
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


public class TLRequestAccountSendChangePhoneCode extends TLMethod<com.github.badoualy.telegram.tl.api.account.TLSentChangePhoneCode> {

    public static final int CLASS_ID = 0xa407a8f4;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountSendChangePhoneCode(        String _phoneNumber) {
        this.phoneNumber = _phoneNumber;

    }



    public com.github.badoualy.telegram.tl.api.account.TLSentChangePhoneCode deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.account.TLSentChangePhoneCode) {
            return (com.github.badoualy.telegram.tl.api.account.TLSentChangePhoneCode)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.account.TLSentChangePhoneCode, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected String phoneNumber;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.phoneNumber, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneNumber = readTLString(stream);
    }



    @Override
    public String toString() {
        return "account.sendChangePhoneCode#a407a8f4";
    }

}
