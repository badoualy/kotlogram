
package com.github.badoualy.telegram.tl.api.help;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLSupport extends TLObject {

    public static final int CLASS_ID = 0x17c6b5f6;

    public TLSupport() {

    }


    public TLSupport(        String _phoneNumber,         com.github.badoualy.telegram.tl.api.TLAbsUser _user) {
        this.phoneNumber = _phoneNumber;
        this.user = _user;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String phoneNumber;

    protected com.github.badoualy.telegram.tl.api.TLAbsUser user;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsUser getUser() {
        return user;
    }

    public void setUser(com.github.badoualy.telegram.tl.api.TLAbsUser value) {
        this.user = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.phoneNumber, stream);
        writeTLObject(this.user, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneNumber = readTLString(stream);
        this.user = (com.github.badoualy.telegram.tl.api.TLAbsUser)readTLObject(stream, context);
    }


    @Override
    public String toString() {
        return "help.support#17c6b5f6";
    }

}
