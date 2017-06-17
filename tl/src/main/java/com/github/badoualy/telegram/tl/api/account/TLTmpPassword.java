package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLTmpPassword extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xdb64fd34;

    protected TLBytes tmpPassword;

    protected int validUntil;

    private final String _constructor = "account.tmpPassword#db64fd34";

    public TLTmpPassword() {
    }

    public TLTmpPassword(TLBytes tmpPassword, int validUntil) {
        this.tmpPassword = tmpPassword;
        this.validUntil = validUntil;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(tmpPassword, stream);
        writeInt(validUntil, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        tmpPassword = readTLBytes(stream, context);
        validUntil = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLBytesSerializedSize(tmpPassword);
        size += SIZE_INT32;
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

    public TLBytes getTmpPassword() {
        return tmpPassword;
    }

    public void setTmpPassword(TLBytes tmpPassword) {
        this.tmpPassword = tmpPassword;
    }

    public int getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(int validUntil) {
        this.validUntil = validUntil;
    }
}
