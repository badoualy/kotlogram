
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUpdateUserName extends TLAbsUpdate {
    public static final int CLASS_ID = 0xa7332b73;

    public TLUpdateUserName() {

    }


    public TLUpdateUserName(        int _userId,         String _firstName,         String _lastName,         String _username) {
        this.userId = _userId;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.username = _username;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected String firstName;

    protected String lastName;

    protected String username;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeTLString(this.firstName, stream);
        writeTLString(this.lastName, stream);
        writeTLString(this.username, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.firstName = readTLString(stream);
        this.lastName = readTLString(stream);
        this.username = readTLString(stream);
    }



    @Override
    public String toString() {
        return "updateUserName#a7332b73";
    }

}
