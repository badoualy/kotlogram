package com.github.badoualy.telegram.tl.api.payments;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLPaymentRequestedInfo;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLSavedInfo extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xfb8fe43c;

    protected int flags;

    protected boolean hasSavedCredentials;

    protected TLPaymentRequestedInfo savedInfo;

    private final String _constructor = "payments.savedInfo#fb8fe43c";

    public TLSavedInfo() {
    }

    public TLSavedInfo(boolean hasSavedCredentials, TLPaymentRequestedInfo savedInfo) {
        this.hasSavedCredentials = hasSavedCredentials;
        this.savedInfo = savedInfo;
    }

    private void computeFlags() {
        flags = 0;
        flags = hasSavedCredentials ? (flags | 2) : (flags & ~2);
        flags = savedInfo != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 1) != 0) {
            if (savedInfo == null) throwNullFieldException("savedInfo", flags);
            writeTLObject(savedInfo, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        hasSavedCredentials = (flags & 2) != 0;
        savedInfo = (flags & 1) != 0 ? readTLObject(stream, context, TLPaymentRequestedInfo.class,
                                                    TLPaymentRequestedInfo.CONSTRUCTOR_ID) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (savedInfo == null) throwNullFieldException("savedInfo", flags);
            size += savedInfo.computeSerializedSize();
        }
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

    public boolean getHasSavedCredentials() {
        return hasSavedCredentials;
    }

    public void setHasSavedCredentials(boolean hasSavedCredentials) {
        this.hasSavedCredentials = hasSavedCredentials;
    }

    public TLPaymentRequestedInfo getSavedInfo() {
        return savedInfo;
    }

    public void setSavedInfo(TLPaymentRequestedInfo savedInfo) {
        this.savedInfo = savedInfo;
    }
}
