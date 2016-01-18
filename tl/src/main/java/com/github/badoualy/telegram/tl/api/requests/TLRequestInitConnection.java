
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLMethod;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLMethod;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLRequestInitConnection<T extends TLObject> extends TLMethod<T> {

    public static final int CLASS_ID = 0x69796de9;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestInitConnection(        int _apiId,         String _deviceModel,         String _systemVersion,         String _appVersion,         String _langCode,         TLMethod<T> _query) {
        this.apiId = _apiId;
        this.deviceModel = _deviceModel;
        this.systemVersion = _systemVersion;
        this.appVersion = _appVersion;
        this.langCode = _langCode;
        this.query = _query;

    }



    public T deserializeResponse(InputStream stream, TLContext context) throws IOException {

        return (T) query.deserializeResponse(stream, context);

    }
        


    protected int apiId;

    protected String deviceModel;

    protected String systemVersion;

    protected String appVersion;

    protected String langCode;

    protected TLMethod<T> query;


    public int getApiId() {
        return apiId;
    }

    public void setApiId(int value) {
        this.apiId = value;
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

    public String getLangCode() {
        return langCode;
    }

    public void setLangCode(String value) {
        this.langCode = value;
    }

    public TLMethod<T> getQuery() {
        return query;
    }

    public void setQuery(TLMethod<T> value) {
        this.query = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.apiId, stream);
        writeTLString(this.deviceModel, stream);
        writeTLString(this.systemVersion, stream);
        writeTLString(this.appVersion, stream);
        writeTLString(this.langCode, stream);
        writeTLMethod(this.query, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.apiId = readInt(stream);
        this.deviceModel = readTLString(stream);
        this.systemVersion = readTLString(stream);
        this.appVersion = readTLString(stream);
        this.langCode = readTLString(stream);
        this.query = readTLMethod(stream, context);
    }



    @Override
    public String toString() {
        return "initConnection#69796de9";
    }

}
