package com.github.badoualy.telegram.tl.api.account;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSentChangePhoneCode extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xa4f58c4c;

    protected String phoneCodeHash;

    protected int sendCallTimeout;

    private final String _constructor = "account.sentChangePhoneCode#a4f58c4c";

    public TLSentChangePhoneCode() {
    }

    public TLSentChangePhoneCode(String phoneCodeHash, int sendCallTimeout) {
        this.phoneCodeHash = phoneCodeHash;
        this.sendCallTimeout = sendCallTimeout;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(phoneCodeHash, stream);
        writeInt(sendCallTimeout, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneCodeHash = readTLString(stream);
        sendCallTimeout = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(phoneCodeHash);
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

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLSentChangePhoneCode)) return false;
        if (object == this) return true;

        TLSentChangePhoneCode o = (TLSentChangePhoneCode) object;

        return (phoneCodeHash == o.phoneCodeHash || (phoneCodeHash != null && o.phoneCodeHash != null && phoneCodeHash.equals(o.phoneCodeHash)))
                && sendCallTimeout == o.sendCallTimeout;
    }

    public String getPhoneCodeHash() {
        return phoneCodeHash;
    }

    public void setPhoneCodeHash(String phoneCodeHash) {
        this.phoneCodeHash = phoneCodeHash;
    }

    public int getSendCallTimeout() {
        return sendCallTimeout;
    }

    public void setSendCallTimeout(int sendCallTimeout) {
        this.sendCallTimeout = sendCallTimeout;
    }
}
