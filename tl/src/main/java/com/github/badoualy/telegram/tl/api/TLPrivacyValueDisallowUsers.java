
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLPrivacyValueDisallowUsers extends TLAbsPrivacyRule {
    public static final int CLASS_ID = 0xc7f49b7;

    public TLPrivacyValueDisallowUsers() {

    }


    public TLPrivacyValueDisallowUsers(        com.github.badoualy.telegram.tl.core.TLIntVector _users) {
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.core.TLIntVector users;


    public com.github.badoualy.telegram.tl.core.TLIntVector getUsers() {
        return users;
    }

    public void setUsers(com.github.badoualy.telegram.tl.core.TLIntVector value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.users = readTLIntVector(stream, context);
    }



    @Override
    public String toString() {
        return "privacyValueDisallowUsers#c7f49b7";
    }

}
