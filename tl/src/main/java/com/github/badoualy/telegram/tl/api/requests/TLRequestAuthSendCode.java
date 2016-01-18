
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestAuthSendCode extends TLMethod<com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode> {

    public static final int CLASS_ID = 0x768d5f4d;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAuthSendCode(        String _phoneNumber,         int _smsType,         int _apiId,         String _apiHash,         String _langCode) {
        this.phoneNumber = _phoneNumber;
        this.smsType = _smsType;
        this.apiId = _apiId;
        this.apiHash = _apiHash;
        this.langCode = _langCode;

    }



    public com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode) {
            return (com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.auth.TLAbsSentCode, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected String phoneNumber;

    protected int smsType;

    protected int apiId;

    protected String apiHash;

    protected String langCode;


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String value) {
        this.phoneNumber = value;
    }

    public int getSmsType() {
        return smsType;
    }

    public void setSmsType(int value) {
        this.smsType = value;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int value) {
        this.apiId = value;
    }

    public String getApiHash() {
        return apiHash;
    }

    public void setApiHash(String value) {
        this.apiHash = value;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String value) {
        this.langCode = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.phoneNumber, stream);
        writeInt(this.smsType, stream);
        writeInt(this.apiId, stream);
        writeTLString(this.apiHash, stream);
        writeTLString(this.langCode, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.phoneNumber = readTLString(stream);
        this.smsType = readInt(stream);
        this.apiId = readInt(stream);
        this.apiHash = readTLString(stream);
        this.langCode = readTLString(stream);
    }



    @Override
    public String toString() {
        return "auth.sendCode#768d5f4d";
    }

}
