
package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLPasswordInputSettings extends TLObject {

    public static final int CLASS_ID = 0xbcfc532c;

    public TLPasswordInputSettings() {

    }


    public TLPasswordInputSettings(        int _flags,         TLBytes _newSalt,         TLBytes _newPasswordHash,         String _hint,         String _email) {
        this.flags = _flags;
        this.newSalt = _newSalt;
        this.newPasswordHash = _newPasswordHash;
        this.hint = _hint;
        this.email = _email;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected TLBytes newSalt;

    protected TLBytes newPasswordHash;

    protected String hint;

    protected String email;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public TLBytes getNewSalt() {
        return newSalt;
    }

    public void setNewSalt(TLBytes value) {
        this.newSalt = value;
    }

    public TLBytes getNewPasswordHash() {
        return newPasswordHash;
    }

    public void setNewPasswordHash(TLBytes value) {
        this.newPasswordHash = value;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String value) {
        this.hint = value;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String value) {
        this.email = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBytes(this.newSalt, stream);
        if ((this.flags & 1) != 0)
            writeTLBytes(this.newPasswordHash, stream);
        if ((this.flags & 1) != 0)
            writeTLString(this.hint, stream);
        if ((this.flags & 2) != 0)
            writeTLString(this.email, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        if ((this.flags & 1) != 0)
            this.newSalt = readTLBytes(stream, context);
        if ((this.flags & 1) != 0)
            this.newPasswordHash = readTLBytes(stream, context);
        if ((this.flags & 1) != 0)
            this.hint = readTLString(stream);
        if ((this.flags & 2) != 0)
            this.email = readTLString(stream);
    }


    @Override
    public String toString() {
        return "account.passwordInputSettings#bcfc532c";
    }

}
