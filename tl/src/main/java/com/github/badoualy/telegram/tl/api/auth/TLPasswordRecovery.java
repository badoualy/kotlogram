package com.github.badoualy.telegram.tl.api.auth;

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
public class TLPasswordRecovery extends TLObject {
    public static final int CONSTRUCTOR_ID = 0x137948a5;

    protected String emailPattern;

    public TLPasswordRecovery() {
    }

    public TLPasswordRecovery(String emailPattern) {
        this.emailPattern = emailPattern;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(emailPattern, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        emailPattern = readTLString(stream);
    }

    @Override
    public String toString() {
        return "auth.passwordRecovery#137948a5";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public String getEmailPattern() {
        return emailPattern;
    }

    public void setEmailPattern(String emailPattern) {
        this.emailPattern = emailPattern;
    }
}
