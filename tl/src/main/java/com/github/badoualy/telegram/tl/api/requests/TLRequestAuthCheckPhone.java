
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestAuthCheckPhone extends TLMethod<com.github.badoualy.telegram.tl.api.auth.TLCheckedPhone> {

    public static final int CLASS_ID = 0x6fe51dfb;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthCheckPhone(        String _phoneNumber) {
        this.phoneNumber = _phoneNumber;

    }



    public com.github.badoualy.telegram.tl.api.auth.TLCheckedPhone deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.auth.TLCheckedPhone) {
            return (com.github.badoualy.telegram.tl.api.auth.TLCheckedPhone)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.auth.TLCheckedPhone, got: " + res.getClass().getCanonicalName());
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
        return "auth.checkPhone#6fe51dfb";
    }

}
