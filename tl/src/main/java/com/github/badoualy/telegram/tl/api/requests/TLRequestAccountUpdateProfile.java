
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestAccountUpdateProfile extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsUser> {

    public static final int CLASS_ID = 0xf0888d68;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountUpdateProfile(        String _firstName,         String _lastName) {
        this.firstName = _firstName;
        this.lastName = _lastName;

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
        


    protected String firstName;

    protected String lastName;


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String value) {
        this.firstName = value;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String value) {
        this.lastName = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.firstName, stream);
        writeTLString(this.lastName, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.firstName = readTLString(stream);
        this.lastName = readTLString(stream);
    }



    @Override
    public String toString() {
        return "account.updateProfile#f0888d68";
    }

}
