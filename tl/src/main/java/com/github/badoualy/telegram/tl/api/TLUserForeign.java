
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLUserForeign extends TLAbsUser {
    public static final int CLASS_ID = 0x75cf7a8;

    public TLUserForeign() {

    }


    public TLUserForeign(        int _id,         String _firstName,         String _lastName,         String _username,         long _accessHash,         com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto _photo,         com.github.badoualy.telegram.tl.api.TLAbsUserStatus _status) {
        this.id = _id;
        this.firstName = _firstName;
        this.lastName = _lastName;
        this.username = _username;
        this.accessHash = _accessHash;
        this.photo = _photo;
        this.status = _status;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String firstName;

    protected String lastName;

    protected String username;

    protected long accessHash;

    protected com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto photo;

    protected com.github.badoualy.telegram.tl.api.TLAbsUserStatus status;


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

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
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


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.id, stream);
        writeTLString(this.firstName, stream);
        writeTLString(this.lastName, stream);
        writeTLString(this.username, stream);
        writeLong(this.accessHash, stream);
        writeTLObject(this.photo, stream);
        writeTLObject(this.status, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.id = readInt(stream);
        this.firstName = readTLString(stream);
        this.lastName = readTLString(stream);
        this.username = readTLString(stream);
        this.accessHash = readLong(stream);
        this.photo = (com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto)readTLObject(stream, context);
        this.status = (com.github.badoualy.telegram.tl.api.TLAbsUserStatus)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "userForeign#75cf7a8";
    }

}
