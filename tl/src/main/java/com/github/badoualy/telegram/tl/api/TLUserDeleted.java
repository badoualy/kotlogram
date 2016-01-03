
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUserDeleted extends TLAbsUser {
    public static final int CLASS_ID = 0xd6016d7a;

    public TLUserDeleted() {

    }


    public TLUserDeleted(        int _id,         String _firstName,         String _lastName,         String _username) {
        this.id = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.username = _username;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String firstName;

    protected String lastName;

    protected String username;


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.firstName, stream);
        writeTLString(this.lastName, stream);
        writeTLString(this.username, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.firstName = readTLString(stream);
        this.lastName = readTLString(stream);
        this.username = readTLString(stream);
    }



    @Override
    public String toString() {
        return "userDeleted#d6016d7a";
    }

}
