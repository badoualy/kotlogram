
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestHelpGetAppUpdate extends TLMethod<com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate> {

    public static final int CLASS_ID = 0xc812ac7e;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestHelpGetAppUpdate(        String _deviceModel,         String _systemVersion,         String _appVersion,         String _langCode) {
        this.deviceModel = _deviceModel;
        this.systemVersion = _systemVersion;
        this.appVersion = _appVersion;
        this.langCode = _langCode;

    }



    public com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate) {
            return (com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.help.TLAbsAppUpdate, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected String deviceModel;

    protected String systemVersion;

    protected String appVersion;

    protected String langCode;


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

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String value) {
        this.langCode = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLString(this.deviceModel, stream);
        writeTLString(this.systemVersion, stream);
        writeTLString(this.appVersion, stream);
        writeTLString(this.langCode, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.deviceModel = readTLString(stream);
        this.systemVersion = readTLString(stream);
        this.appVersion = readTLString(stream);
        this.langCode = readTLString(stream);
    }



    @Override
    public String toString() {
        return "help.getAppUpdate#c812ac7e";
    }

}
