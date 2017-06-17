package com.github.badoualy.telegram.tl.api.auth;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLCheckedPhone extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x811ea28e;

    protected boolean phoneRegistered;

    private final String _constructor = "auth.checkedPhone#811ea28e";

    public TLCheckedPhone() {
    }

    public TLCheckedPhone(boolean phoneRegistered) {
        this.phoneRegistered = phoneRegistered;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeBoolean(phoneRegistered, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneRegistered = readTLBool(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_BOOLEAN;
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public boolean getPhoneRegistered() {
        return phoneRegistered;
    }

    public void setPhoneRegistered(boolean phoneRegistered) {
        this.phoneRegistered = phoneRegistered;
    }
}
