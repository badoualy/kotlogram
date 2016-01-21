
package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;


public class TLCheckedPhone extends TLObject {

    public static final int CLASS_ID = 0x811ea28e;

    public TLCheckedPhone() {

    }


    public TLCheckedPhone(        boolean _phoneRegistered) {
        this.phoneRegistered = _phoneRegistered;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected boolean phoneRegistered;


    public boolean getPhoneRegistered() {
        return phoneRegistered;
    }

    public void setPhoneRegistered(boolean value) {
        this.phoneRegistered = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBool(this.phoneRegistered, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneRegistered = readTLBool(stream);
    }


    @Override
    public String toString() {
        return "auth.checkedPhone#811ea28e";
    }

}
