
package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLPasswordRecovery extends TLObject {

    public static final int CLASS_ID = 0x137948a5;

    public TLPasswordRecovery() {

    }


    public TLPasswordRecovery(        String _emailPattern) {
        this.emailPattern = _emailPattern;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected String emailPattern;


    public String getEmailPattern() {
        return emailPattern;
    }

    public void setEmailPattern(String value) {
        this.emailPattern = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.emailPattern, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.emailPattern = readTLString(stream);
    }


    @Override
    public String toString() {
        return "auth.passwordRecovery#137948a5";
    }

}
