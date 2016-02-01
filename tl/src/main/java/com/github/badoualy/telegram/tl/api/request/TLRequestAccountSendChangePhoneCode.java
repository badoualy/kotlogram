package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.account.TLSentChangePhoneCode;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountSendChangePhoneCode extends TLMethod<TLSentChangePhoneCode> {
    public static final int CONSTRUCTOR_ID = 0xa407a8f4;

    protected String phoneNumber;

    public TLRequestAccountSendChangePhoneCode() {
    }

    public TLRequestAccountSendChangePhoneCode(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLSentChangePhoneCode deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLSentChangePhoneCode)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLSentChangePhoneCode) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(phoneNumber, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneNumber = readTLString(stream);
    }

    @Override
    public String toString() {
        return "account.sendChangePhoneCode#a407a8f4";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
