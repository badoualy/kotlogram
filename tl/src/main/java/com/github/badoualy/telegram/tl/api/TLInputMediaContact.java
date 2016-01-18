
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLInputMediaContact extends TLAbsInputMedia {
    public static final int CLASS_ID = 0xa6e45987;

    public TLInputMediaContact() {

    }


    public TLInputMediaContact(        String _phoneNumber,         String _firstName,         String _lastName) {
        this.phoneNumber = _phoneNumber;
        this.firstName = _firstName;
        this.lastName = _lastName;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String phoneNumber;

    protected String firstName;

    protected String lastName;


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


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.phoneNumber, stream);
        writeTLString(this.firstName, stream);
        writeTLString(this.lastName, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneNumber = readTLString(stream);
        this.firstName = readTLString(stream);
        this.lastName = readTLString(stream);
    }



    @Override
    public String toString() {
        return "inputMediaContact#a6e45987";
    }

}
