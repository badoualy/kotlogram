
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateUserStatus extends TLAbsUpdate {
    public static final int CLASS_ID = 0x1bfbd823;

    public TLUpdateUserStatus() {

    }


    public TLUpdateUserStatus(        int _userId,         com.github.badoualy.telegram.tl.api.TLAbsUserStatus _status) {
        this.userId = _userId;
        this.status = _status;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected com.github.badoualy.telegram.tl.api.TLAbsUserStatus status;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsUserStatus getStatus() {
        return status;
    }

    public void setStatus(com.github.badoualy.telegram.tl.api.TLAbsUserStatus value) {
        this.status = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeTLObject(this.status, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.status = (com.github.badoualy.telegram.tl.api.TLAbsUserStatus)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "updateUserStatus#1bfbd823";
    }

}
