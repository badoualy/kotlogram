package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsInputPaymentCredentials;
import com.github.badoualy.telegram.tl.api.payments.TLAbsPaymentResult;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestPaymentsSendPaymentForm extends TLMethod<TLAbsPaymentResult> {

    public static final int CONSTRUCTOR_ID = 0x2b8879b3;

    protected int flags;

    protected int msgId;

    protected String requestedInfoId;

    protected String shippingOptionId;

    protected TLAbsInputPaymentCredentials credentials;

    private final String _constructor = "payments.sendPaymentForm#2b8879b3";

    public TLRequestPaymentsSendPaymentForm() {
    }

    public TLRequestPaymentsSendPaymentForm(int msgId, String requestedInfoId, String shippingOptionId, TLAbsInputPaymentCredentials credentials) {
        this.msgId = msgId;
        this.requestedInfoId = requestedInfoId;
        this.shippingOptionId = shippingOptionId;
        this.credentials = credentials;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLAbsPaymentResult deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsPaymentResult)) {
            throw new IOException(
                    "Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response
                            .getClass().getCanonicalName());
        }
        return (TLAbsPaymentResult) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = requestedInfoId != null ? (flags | 1) : (flags & ~1);
        flags = shippingOptionId != null ? (flags | 2) : (flags & ~2);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(msgId, stream);
        if ((flags & 1) != 0) {
            if (requestedInfoId == null) throwNullFieldException("requestedInfoId", flags);
            writeString(requestedInfoId, stream);
        }
        if ((flags & 2) != 0) {
            if (shippingOptionId == null) throwNullFieldException("shippingOptionId", flags);
            writeString(shippingOptionId, stream);
        }
        writeTLObject(credentials, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        msgId = readInt(stream);
        requestedInfoId = (flags & 1) != 0 ? readTLString(stream) : null;
        shippingOptionId = (flags & 2) != 0 ? readTLString(stream) : null;
        credentials = readTLObject(stream, context, TLAbsInputPaymentCredentials.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (requestedInfoId == null) throwNullFieldException("requestedInfoId", flags);
            size += computeTLStringSerializedSize(requestedInfoId);
        }
        if ((flags & 2) != 0) {
            if (shippingOptionId == null) throwNullFieldException("shippingOptionId", flags);
            size += computeTLStringSerializedSize(shippingOptionId);
        }
        size += credentials.computeSerializedSize();
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

    public int getMsgId() {
        return msgId;
    }

    public void setMsgId(int msgId) {
        this.msgId = msgId;
    }

    public String getRequestedInfoId() {
        return requestedInfoId;
    }

    public void setRequestedInfoId(String requestedInfoId) {
        this.requestedInfoId = requestedInfoId;
    }

    public String getShippingOptionId() {
        return shippingOptionId;
    }

    public void setShippingOptionId(String shippingOptionId) {
        this.shippingOptionId = shippingOptionId;
    }

    public TLAbsInputPaymentCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(TLAbsInputPaymentCredentials credentials) {
        this.credentials = credentials;
    }
}
