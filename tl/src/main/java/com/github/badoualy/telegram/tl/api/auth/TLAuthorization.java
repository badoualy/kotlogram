
package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLAuthorization extends TLObject {

    public static final int CLASS_ID = 0xf6b673a4;

    public TLAuthorization() {

    }


    public TLAuthorization(        int _expires,         com.github.badoualy.telegram.tl.api.TLAbsUser _user) {
        this.expires = _expires;
        this.user = _user;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int expires;

    protected com.github.badoualy.telegram.tl.api.TLAbsUser user;


    public int getExpires() {
        return expires;
    }

    public void setExpires(int value) {
        this.expires = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsUser getUser() {
        return user;
    }

    public void setUser(com.github.badoualy.telegram.tl.api.TLAbsUser value) {
        this.user = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.expires, stream);
        writeTLObject(this.user, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.expires = readInt(stream);
        this.user = (com.github.badoualy.telegram.tl.api.TLAbsUser)readTLObject(stream, context);
    }


    @Override
    public String toString() {
        return "auth.authorization#f6b673a4";
    }

}
