
package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLPasswordSettings extends TLObject {

    public static final int CLASS_ID = 0xb7b72ab3;

    public TLPasswordSettings() {

    }


    public TLPasswordSettings(        String _email) {
        this.email = _email;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String email;


    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.email, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.email = readTLString(stream);
    }


    @Override
    public String toString() {
        return "account.passwordSettings#b7b72ab3";
    }

}
