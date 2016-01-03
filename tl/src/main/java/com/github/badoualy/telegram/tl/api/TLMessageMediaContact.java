
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageMediaContact extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0x5e7d2f39;

    public TLMessageMediaContact() {

    }


    public TLMessageMediaContact(        String _phoneNumber,         String _firstName,         String _lastName,         int _userId) {
        this.phoneNumber = _phoneNumber;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.userId = _userId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String phoneNumber;

    protected String firstName;

    protected String lastName;

    protected int userId;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

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

    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.phoneNumber, stream);
        writeTLString(this.firstName, stream);
        writeTLString(this.lastName, stream);
        writeInt(this.userId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneNumber = readTLString(stream);
        this.firstName = readTLString(stream);
        this.lastName = readTLString(stream);
        this.userId = readInt(stream);
    }



    @Override
    public String toString() {
        return "messageMediaContact#5e7d2f39";
    }

}
