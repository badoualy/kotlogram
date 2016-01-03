
package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLCheckedPhone extends TLObject {

    public static final int CLASS_ID = 0xe300cc3b;

    public TLCheckedPhone() {

    }


    public TLCheckedPhone(        boolean _phoneRegistered,         boolean _phoneInvited) {
        this.phoneRegistered = _phoneRegistered;
        this.phoneInvited = _phoneInvited;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected boolean phoneRegistered;

    protected boolean phoneInvited;


    public boolean getPhoneRegistered() {
        return phoneRegistered;
    }

    public void setPhoneRegistered(boolean value) {
        this.phoneRegistered = value;
    }

    public boolean getPhoneInvited() {
        return phoneInvited;
    }

    public void setPhoneInvited(boolean value) {
        this.phoneInvited = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBool(this.phoneRegistered, stream);
        writeTLBool(this.phoneInvited, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneRegistered = readTLBool(stream);
        this.phoneInvited = readTLBool(stream);
    }


    @Override
    public String toString() {
        return "auth.checkedPhone#e300cc3b";
    }

}
