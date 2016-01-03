
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessageActionChatCreate extends TLAbsMessageAction {
    public static final int CLASS_ID = 0xa6638b9a;

    public TLMessageActionChatCreate() {

    }


    public TLMessageActionChatCreate(        String _title,         com.github.badoualy.telegram.tl.core.TLIntVector _users) {
        this.title = _title;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String title;

    protected com.github.badoualy.telegram.tl.core.TLIntVector users;


    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public com.github.badoualy.telegram.tl.core.TLIntVector getUsers() {
        return users;
    }

    public void setUsers(com.github.badoualy.telegram.tl.core.TLIntVector value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.title, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.title = readTLString(stream);
        this.users = readTLIntVector(stream, context);
    }



    @Override
    public String toString() {
        return "messageActionChatCreate#a6638b9a";
    }

}
