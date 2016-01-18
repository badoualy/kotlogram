
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLInputContact extends TLObject {

    public static final int CLASS_ID = 0xf392b7f4;

    public TLInputContact() {

    }


    public TLInputContact(        long _clientId,         String _phone,         String _firstName,         String _lastName) {
        this.clientId = _clientId;
        this.phone = _phone;
        this.firstName = _firstName;
        this.lastName = _lastName;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long clientId;

    protected String phone;

    protected String firstName;

    protected String lastName;


    public long getClientId() {
        return clientId;
    }

    public void setClientId(long value) {
        this.clientId = value;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        this.phone = value;
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

        writeLong(this.clientId, stream);
        writeTLString(this.phone, stream);
        writeTLString(this.firstName, stream);
        writeTLString(this.lastName, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.clientId = readLong(stream);
        this.phone = readTLString(stream);
        this.firstName = readTLString(stream);
        this.lastName = readTLString(stream);
    }


    @Override
    public String toString() {
        return "inputPhoneContact#f392b7f4";
    }

}
