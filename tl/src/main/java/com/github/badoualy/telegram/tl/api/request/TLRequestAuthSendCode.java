package com.github.badoualy.telegram.tl.api.request;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode;
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
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLRequestAuthSendCode extends TLMethod<TLAbsSentCode> {
    public static final int CONSTRUCTOR_ID = 0x768d5f4d;

    protected String phoneNumber;

    protected int smsType;

    protected int apiId;

    protected String apiHash;

    protected String langCode;

    private final String _constructor = "auth.sendCode#768d5f4d";

    public TLRequestAuthSendCode() {
    }

    public TLRequestAuthSendCode(String phoneNumber, int smsType, int apiId, String apiHash, String langCode) {
        this.phoneNumber = phoneNumber;
        this.smsType = smsType;
        this.apiId = apiId;
        this.apiHash = apiHash;
        this.langCode = langCode;
    }

    @Override
    @SuppressWarnings("unchecked")
    public TLAbsSentCode deserializeResponse(InputStream stream, TLContext context) throws IOException {
        final TLObject response = readTLObject(stream, context);
        if (response == null) {
            throw new IOException("Unable to parse response");
        }
        if (!(response instanceof TLAbsSentCode)) {
            throw new IOException("Incorrect response type, expected getClass().getCanonicalName(), found response.getClass().getCanonicalName()");
        }
        return (TLAbsSentCode) response;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeString(phoneNumber, stream);
        writeInt(smsType, stream);
        writeInt(apiId, stream);
        writeString(apiHash, stream);
        writeString(langCode, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        phoneNumber = readTLString(stream);
        smsType = readInt(stream);
        apiId = readInt(stream);
        apiHash = readTLString(stream);
        langCode = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += computeTLStringSerializedSize(phoneNumber);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(apiHash);
        size += computeTLStringSerializedSize(langCode);
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
        if (!(object instanceof TLRequestAuthSendCode)) return false;
        if (object == this) return true;

        TLRequestAuthSendCode o = (TLRequestAuthSendCode) object;

        return (phoneNumber == o.phoneNumber || (phoneNumber != null && o.phoneNumber != null && phoneNumber.equals(o.phoneNumber)))
                && smsType == o.smsType
                && apiId == o.apiId
                && (apiHash == o.apiHash || (apiHash != null && o.apiHash != null && apiHash.equals(o.apiHash)))
                && (langCode == o.langCode || (langCode != null && o.langCode != null && langCode.equals(o.langCode)));
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getSmsType() {
        return smsType;
    }

    public void setSmsType(int smsType) {
        this.smsType = smsType;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getApiHash() {
        return apiHash;
    }

    public void setApiHash(String apiHash) {
        this.apiHash = apiHash;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String langCode) {
        this.langCode = langCode;
    }
}
