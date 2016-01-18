
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateUserPhoto extends TLAbsUpdate {
    public static final int CLASS_ID = 0x95313b0c;

    public TLUpdateUserPhoto() {

    }


    public TLUpdateUserPhoto(        int _userId,         int _date,         com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto _photo,         boolean _previous) {
        this.userId = _userId;
        this.date = _date;
        this.photo = _photo;
        this.previous = _previous;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected int date;

    protected com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto photo;

    protected boolean previous;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto getPhoto() {
        return photo;
    }

    public void setPhoto(com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto value) {
        this.photo = value;
    }

    public boolean getPrevious() {
        return previous;
    }

    public void setPrevious(boolean value) {
        this.previous = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeInt(this.date, stream);
        writeTLObject(this.photo, stream);
        writeTLBool(this.previous, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.date = readInt(stream);
        this.photo = (com.github.badoualy.telegram.tl.api.TLAbsUserProfilePhoto)readTLObject(stream, context);
        this.previous = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "updateUserPhoto#95313b0c";
    }

}
