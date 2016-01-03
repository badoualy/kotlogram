
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUserSelf extends TLAbsUser {
    public static final int CLASS_ID = 0x7007b451;

    public TLUserSelf() {

    }


    public TLUserSelf(        int _id,         String _firstName,         String _lastName,         String _username,         String _phone,         com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto _photo,         com.github.badoualy.telegram.tl.api.TLAbsUserStatus _status,         boolean _inactive) {
        this.id = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.username = _username;
        this.phone = _phone;
        this.photo = _photo;
        this.status = _status;
        this.inactive = _inactive;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String firstName;

    protected String lastName;

    protected String username;

    protected String phone;

    protected com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto photo;

    protected com.github.badoualy.telegram.tl.api.TLAbsUserStatus status;

    protected boolean inactive;


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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String value) {
        this.phone = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto getPhoto() {
        return photo;
    }

    public void setPhoto(com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto value) {
        this.photo = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsUserStatus getStatus() {
        return status;
    }

    public void setStatus(com.github.badoualy.telegram.tl.api.TLAbsUserStatus value) {
        this.status = value;
    }

    public boolean getInactive() {
        return inactive;
    }

    public void setInactive(boolean value) {
        this.inactive = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.firstName, stream);
        writeTLString(this.lastName, stream);
        writeTLString(this.username, stream);
        writeTLString(this.phone, stream);
        writeTLObject(this.photo, stream);
        writeTLObject(this.status, stream);
        writeTLBool(this.inactive, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.firstName = readTLString(stream);
        this.lastName = readTLString(stream);
        this.username = readTLString(stream);
        this.phone = readTLString(stream);
        this.photo = (com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto)readTLObject(stream, context);
        this.status = (com.github.badoualy.telegram.tl.api.TLAbsUserStatus)readTLObject(stream, context);
        this.inactive = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "userSelf#7007b451";
    }

}
