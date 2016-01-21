
package com.github.badoualy.telegram.tl.api.account;


import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLPassword extends TLAbsPassword {
    public static final int CLASS_ID = 0x7c18141c;

    public TLPassword() {

    }


    public TLPassword(        TLBytes _currentSalt,         TLBytes _newSalt,         String _hint,         boolean _hasRecovery,         String _emailUnconfirmedPattern) {
        this.currentSalt = _currentSalt;
        this.newSalt = _newSalt;
        this.hint = _hint;
        this.hasRecovery = _hasRecovery;
        this.emailUnconfirmedPattern = _emailUnconfirmedPattern;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected TLBytes currentSalt;

    protected String hint;

    protected boolean hasRecovery;


    public TLBytes getCurrentSalt() {
        return currentSalt;
    }

    public void setCurrentSalt(TLBytes value) {
        this.currentSalt = value;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String value) {
        this.hint = value;
    }

    public boolean getHasRecovery() {
        return hasRecovery;
    }

    public void setHasRecovery(boolean value) {
        this.hasRecovery = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLBytes(this.currentSalt, stream);
        writeTLBytes(this.newSalt, stream);
        writeTLString(this.hint, stream);
        writeTLBool(this.hasRecovery, stream);
        writeTLString(this.emailUnconfirmedPattern, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.currentSalt = readTLBytes(stream, context);
        this.newSalt = readTLBytes(stream, context);
        this.hint = readTLString(stream);
        this.hasRecovery = readTLBool(stream);
        this.emailUnconfirmedPattern = readTLString(stream);
    }



    @Override
    public String toString() {
        return "account.password#7c18141c";
    }

}
