package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdatePhoneCall extends TLAbsUpdate {

    public static final int CONSTRUCTOR_ID = 0xab0f6b1e;

    protected TLAbsPhoneCall phoneCall;

    private final String _constructor = "updatePhoneCall#ab0f6b1e";

    public TLUpdatePhoneCall() {
    }

    public TLUpdatePhoneCall(TLAbsPhoneCall phoneCall) {
        this.phoneCall = phoneCall;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(phoneCall, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneCall = readTLObject(stream, context, TLAbsPhoneCall.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += phoneCall.computeSerializedSize();
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

    public TLAbsPhoneCall getPhoneCall() {
        return phoneCall;
    }

    public void setPhoneCall(TLAbsPhoneCall phoneCall) {
        this.phoneCall = phoneCall;
    }
}
