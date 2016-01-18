
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestAccountRegisterDevice extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x446c712c;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountRegisterDevice(        int _tokenType,         String _token,         String _deviceModel,         String _systemVersion,         String _appVersion,         boolean _appSandbox,         String _langCode) {
        this.tokenType = _tokenType;
        this.token = _token;
        this.deviceModel = _deviceModel;
        this.systemVersion = _systemVersion;
        this.appVersion = _appVersion;
        this.appSandbox = _appSandbox;
        this.langCode = _langCode;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int tokenType;

    protected String token;

    protected String deviceModel;

    protected String systemVersion;

    protected String appVersion;

    protected boolean appSandbox;

    protected String langCode;


    public int getTokenType() {
        return tokenType;
    }

    public void setTokenType(int value) {
        this.tokenType = value;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String value) {
        this.token = value;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String value) {
        this.deviceModel = value;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String value) {
        this.systemVersion = value;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String value) {
        this.appVersion = value;
    }

    public boolean getAppSandbox() {
        return appSandbox;
    }

    public void setAppSandbox(boolean value) {
        this.appSandbox = value;
    }

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String value) {
        this.langCode = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.tokenType, stream);
        writeTLString(this.token, stream);
        writeTLString(this.deviceModel, stream);
        writeTLString(this.systemVersion, stream);
        writeTLString(this.appVersion, stream);
        writeTLBool(this.appSandbox, stream);
        writeTLString(this.langCode, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.tokenType = readInt(stream);
        this.token = readTLString(stream);
        this.deviceModel = readTLString(stream);
        this.systemVersion = readTLString(stream);
        this.appVersion = readTLString(stream);
        this.appSandbox = readTLBool(stream);
        this.langCode = readTLString(stream);
    }



    @Override
    public String toString() {
        return "account.registerDevice#446c712c";
    }

}
