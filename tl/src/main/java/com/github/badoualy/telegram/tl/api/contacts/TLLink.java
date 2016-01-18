
package com.github.badoualy.telegram.tl.api.contacts;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLLink extends TLObject {

    public static final int CLASS_ID = 0xeccea3f5;

    public TLLink() {

    }


    public TLLink(        com.github.badoualy.telegram.tl.api.contacts.TLAbsMyLink _myLink,         com.github.badoualy.telegram.tl.api.contacts.TLAbsForeignLink _foreignLink,         com.github.badoualy.telegram.tl.api.TLAbsUser _user) {
        this.myLink = _myLink;
        this.foreignLink = _foreignLink;
        this.user = _user;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.contacts.TLAbsMyLink myLink;

    protected com.github.badoualy.telegram.tl.api.contacts.TLAbsForeignLink foreignLink;

    protected com.github.badoualy.telegram.tl.api.TLAbsUser user;


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

    public com.github.badoualy.telegram.tl.api.TLAbsUser getUser() {
        return user;
    }

    public void setUser(com.github.badoualy.telegram.tl.api.TLAbsUser value) {
        this.user = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.myLink, stream);
        writeTLObject(this.foreignLink, stream);
        writeTLObject(this.user, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.myLink = (com.github.badoualy.telegram.tl.api.contacts.TLAbsMyLink)readTLObject(stream, context);
        this.foreignLink = (com.github.badoualy.telegram.tl.api.contacts.TLAbsForeignLink)readTLObject(stream, context);
        this.user = (com.github.badoualy.telegram.tl.api.TLAbsUser)readTLObject(stream, context);
    }


    @Override
    public String toString() {
        return "contacts.link#eccea3f5";
    }

}
