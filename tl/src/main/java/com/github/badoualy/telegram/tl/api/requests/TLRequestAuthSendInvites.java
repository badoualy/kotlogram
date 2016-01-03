
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestAuthSendInvites extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x771c1d97;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthSendInvites(        com.github.badoualy.telegram.tl.core.TLStringVector _phoneNumbers,         String _message) {
        this.phoneNumbers = _phoneNumbers;
        this.message = _message;

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
        


    protected com.github.badoualy.telegram.tl.core.TLStringVector phoneNumbers;

    protected String message;


    public com.github.badoualy.telegram.tl.core.TLStringVector getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(com.github.badoualy.telegram.tl.core.TLStringVector value) {
        this.phoneNumbers = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.phoneNumbers, stream);
        writeTLString(this.message, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneNumbers = readTLStringVector(stream, context);
        this.message = readTLString(stream);
    }



    @Override
    public String toString() {
        return "auth.sendInvites#771c1d97";
    }

}
