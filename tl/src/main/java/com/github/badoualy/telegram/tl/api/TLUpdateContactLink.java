
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateContactLink extends TLAbsUpdate {
    public static final int CLASS_ID = 0x51a48a9a;

    public TLUpdateContactLink() {

    }


    public TLUpdateContactLink(        int _userId,         com.github.badoualy.telegram.tl.api.contacts.TLAbsMyLink _myLink,         com.github.badoualy.telegram.tl.api.contacts.TLAbsForeignLink _foreignLink) {
        this.userId = _userId;
        this.myLink = _myLink;
        this.foreignLink = _foreignLink;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected com.github.badoualy.telegram.tl.api.contacts.TLAbsMyLink myLink;

    protected com.github.badoualy.telegram.tl.api.contacts.TLAbsForeignLink foreignLink;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public com.github.badoualy.telegram.tl.api.contacts.TLAbsMyLink getMyLink() {
        return myLink;
    }

    public void setMyLink(com.github.badoualy.telegram.tl.api.contacts.TLAbsMyLink value) {
        this.myLink = value;
    }

    public com.github.badoualy.telegram.tl.api.contacts.TLAbsForeignLink getForeignLink() {
        return foreignLink;
    }

    public void setForeignLink(com.github.badoualy.telegram.tl.api.contacts.TLAbsForeignLink value) {
        this.foreignLink = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.userId, stream);
        writeTLObject(this.myLink, stream);
        writeTLObject(this.foreignLink, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.myLink = (com.github.badoualy.telegram.tl.api.contacts.TLAbsMyLink)readTLObject(stream, context);
        this.foreignLink = (com.github.badoualy.telegram.tl.api.contacts.TLAbsForeignLink)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "updateContactLink#51a48a9a";
    }

}
