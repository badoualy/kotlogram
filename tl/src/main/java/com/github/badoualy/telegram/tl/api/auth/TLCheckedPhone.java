package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLCheckedPhone extends TLObject {
    public static final int CLASS_ID = 0x811ea28e;

    protected boolean phoneRegistered;

    public TLCheckedPhone() {
    }

    public TLCheckedPhone(boolean phoneRegistered) {
        this.phoneRegistered = phoneRegistered;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBool(phoneRegistered, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneRegistered = readTLBool(stream);
    }

    @Override
    public String toString() {
        return "auth.checkedPhone#811ea28e";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public boolean getPhoneRegistered() {
        return phoneRegistered;
    }

    public void setPhoneRegistered(boolean phoneRegistered) {
        this.phoneRegistered = phoneRegistered;
    }
}
