package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.auth.TLSentCode;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAccountSendChangePhoneCode extends TLMethod<TLSentCode> {

    public static final int CONSTRUCTOR_ID = 0x8e57deb;

    protected int flags;

    protected boolean allowFlashcall;

    protected String phoneNumber;

    protected boolean currentNumber;

    private final String _constructor = "account.sendChangePhoneCode#8e57deb";

    public TLRequestAccountSendChangePhoneCode() {
    }

    public TLRequestAccountSendChangePhoneCode(boolean allowFlashcall, String phoneNumber, boolean currentNumber) {
        this.allowFlashcall = allowFlashcall;
        this.phoneNumber = phoneNumber;
        this.currentNumber = currentNumber;
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public TLSentCode deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLSentCode)) {
            throw new IOException(
                    "Incorrect response type, expected " + getClass().getCanonicalName() + ", found " + response
                            .getClass().getCanonicalName());
        }
        return (TLSentCode) response;
    }

    private void computeFlags() {
        flags = 0;
        flags = allowFlashcall ? (flags | 1) : (flags & ~1);
        // If field is not serialized force it to false
        if (currentNumber && (flags & 1) == 0) currentNumber = false;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(phoneNumber, stream);
        if ((flags & 1) != 0) {
            writeBoolean(currentNumber, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        allowFlashcall = (flags & 1) != 0;
        phoneNumber = readTLString(stream);
        currentNumber = (flags & 1) != 0 ? readTLBool(stream) : false;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(phoneNumber);
        if ((flags & 1) != 0) {
            size += SIZE_BOOLEAN;
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

    public boolean getAllowFlashcall() {
        return allowFlashcall;
    }

    public void setAllowFlashcall(boolean allowFlashcall) {
        this.allowFlashcall = allowFlashcall;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public boolean getCurrentNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(boolean currentNumber) {
        this.currentNumber = currentNumber;
    }
}
