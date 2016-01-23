package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPasswordSettings extends TLObject {
    public static final int CLASS_ID = 0xb7b72ab3;

    protected String email;

    public TLPasswordSettings() {
    }

    public TLPasswordSettings(String email) {
        this.email = email;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(email, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        email = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.passwordSettings#b7b72ab3";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
