
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
    public static final int CLASS_ID = 0x9d2e67c5;

    public TLUpdateContactLink() {

    }


    public TLUpdateContactLink(        int _userId,         com.github.badoualy.telegram.tl.api.TLAbsContactLink _myLink,         com.github.badoualy.telegram.tl.api.TLAbsContactLink _foreignLink) {
        this.userId = _userId;
        this.myLink = _myLink;
        this.foreignLink = _foreignLink;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected com.github.badoualy.telegram.tl.api.TLAbsContactLink myLink;

    protected com.github.badoualy.telegram.tl.api.TLAbsContactLink foreignLink;


    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsContactLink getMyLink() {
        return myLink;
    }

    public void setMyLink(com.github.badoualy.telegram.tl.api.TLAbsContactLink value) {
        this.myLink = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsContactLink getForeignLink() {
        return foreignLink;
    }

    public void setForeignLink(com.github.badoualy.telegram.tl.api.TLAbsContactLink value) {
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
        this.myLink = (com.github.badoualy.telegram.tl.api.TLAbsContactLink)readTLObject(stream, context);
        this.foreignLink = (com.github.badoualy.telegram.tl.api.TLAbsContactLink)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "updateContactLink#9d2e67c5";
    }

}
