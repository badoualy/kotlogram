
package com.github.badoualy.telegram.tl.api.contacts;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLBlocked extends TLAbsBlocked {
    public static final int CLASS_ID = 0x1c138d15;

    public TLBlocked() {

    }


    public TLBlocked(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLContactBlocked> _blocked,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users) {
        this.blocked = _blocked;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.blocked, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.blocked = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "contacts.blocked#1c138d15";
    }

}
