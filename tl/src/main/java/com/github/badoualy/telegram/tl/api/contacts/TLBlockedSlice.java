
package com.github.badoualy.telegram.tl.api.contacts;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLBlockedSlice extends TLAbsBlocked {
    public static final int CLASS_ID = 0x900802a1;

    public TLBlockedSlice() {

    }


    public TLBlockedSlice(        int _count,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLContactBlocked> _blocked,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users) {
        this.count = _count;
        this.blocked = _blocked;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int count;


    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.count, stream);
        writeTLVector(this.blocked, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.count = readInt(stream);
        this.blocked = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "contacts.blockedSlice#900802a1";
    }

}
