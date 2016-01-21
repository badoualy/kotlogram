
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;


public class TLAuthorization extends TLObject {

    public static final int CLASS_ID = 0x7bf2e6f6;

    public TLAuthorization() {

    }


    public TLAuthorization(        long _hash,         int _flags,         String _deviceModel,         String _platform,         String _systemVersion,         int _apiId,         String _appName,         String _appVersion,         int _dateCreated,         int _dateActive,         String _ip,         String _country,         String _region) {
        this.hash = _hash;
        this.flags = _flags;
        this.deviceModel = _deviceModel;
        this.platform = _platform;
        this.systemVersion = _systemVersion;
        this.apiId = _apiId;
        this.appName = _appName;
        this.appVersion = _appVersion;
        this.dateCreated = _dateCreated;
        this.dateActive = _dateActive;
        this.ip = _ip;
        this.country = _country;
        this.region = _region;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected long hash;

    protected int flags;

    protected String deviceModel;

    protected String platform;

    protected String systemVersion;

    protected int apiId;

    protected String appName;

    protected String appVersion;

    protected int dateCreated;

    protected int dateActive;

    protected String ip;

    protected String country;

    protected String region;


    public long getHash() {
        return hash;
    }

    public void setHash(long value) {
        this.hash = value;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String value) {
        this.deviceModel = value;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String value) {
        this.platform = value;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String value) {
        this.systemVersion = value;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int value) {
        this.apiId = value;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String value) {
        this.appName = value;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String value) {
        this.appVersion = value;
    }

    public int getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(int value) {
        this.dateCreated = value;
    }

    public int getDateActive() {
        return dateActive;
    }

    public void setDateActive(int value) {
        this.dateActive = value;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String value) {
        this.ip = value;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String value) {
        this.country = value;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String value) {
        this.region = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeLong(this.hash, stream);
        writeInt(this.flags, stream);
        writeTLString(this.deviceModel, stream);
        writeTLString(this.platform, stream);
        writeTLString(this.systemVersion, stream);
        writeInt(this.apiId, stream);
        writeTLString(this.appName, stream);
        writeTLString(this.appVersion, stream);
        writeInt(this.dateCreated, stream);
        writeInt(this.dateActive, stream);
        writeTLString(this.ip, stream);
        writeTLString(this.country, stream);
        writeTLString(this.region, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.hash = readLong(stream);
        this.flags = readInt(stream);
        this.deviceModel = readTLString(stream);
        this.platform = readTLString(stream);
        this.systemVersion = readTLString(stream);
        this.apiId = readInt(stream);
        this.appName = readTLString(stream);
        this.appVersion = readTLString(stream);
        this.dateCreated = readInt(stream);
        this.dateActive = readInt(stream);
        this.ip = readTLString(stream);
        this.country = readTLString(stream);
        this.region = readTLString(stream);
    }


    @Override
    public String toString() {
        return "authorization#7bf2e6f6";
    }

}
