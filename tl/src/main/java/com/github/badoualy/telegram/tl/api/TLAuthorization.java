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
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLAuthorization extends TLObject {

    public static final int CONSTRUCTOR_ID = 0x7bf2e6f6;

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

    private final String _constructor = "authorization#7bf2e6f6";

    public TLAuthorization() {
    }

    public TLAuthorization(long hash, int flags, String deviceModel, String platform, String systemVersion, int apiId, String appName, String appVersion, int dateCreated, int dateActive, String ip, String country, String region) {
        this.hash = hash;
        this.flags = flags;
        this.deviceModel = deviceModel;
        this.platform = platform;
        this.systemVersion = systemVersion;
        this.apiId = apiId;
        this.appName = appName;
        this.appVersion = appVersion;
        this.dateCreated = dateCreated;
        this.dateActive = dateActive;
        this.ip = ip;
        this.country = country;
        this.region = region;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeLong(hash, stream);
        writeInt(flags, stream);
        writeString(deviceModel, stream);
        writeString(platform, stream);
        writeString(systemVersion, stream);
        writeInt(apiId, stream);
        writeString(appName, stream);
        writeString(appVersion, stream);
        writeInt(dateCreated, stream);
        writeInt(dateActive, stream);
        writeString(ip, stream);
        writeString(country, stream);
        writeString(region, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        hash = readLong(stream);
        flags = readInt(stream);
        deviceModel = readTLString(stream);
        platform = readTLString(stream);
        systemVersion = readTLString(stream);
        apiId = readInt(stream);
        appName = readTLString(stream);
        appVersion = readTLString(stream);
        dateCreated = readInt(stream);
        dateActive = readInt(stream);
        ip = readTLString(stream);
        country = readTLString(stream);
        region = readTLString(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT64;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(deviceModel);
        size += computeTLStringSerializedSize(platform);
        size += computeTLStringSerializedSize(systemVersion);
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(appName);
        size += computeTLStringSerializedSize(appVersion);
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(ip);
        size += computeTLStringSerializedSize(country);
        size += computeTLStringSerializedSize(region);
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

    public long getHash() {
        return hash;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
    }

    public String getDeviceModel() {
        return deviceModel;
    }

    public void setDeviceModel(String deviceModel) {
        this.deviceModel = deviceModel;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getSystemVersion() {
        return systemVersion;
    }

    public void setSystemVersion(String systemVersion) {
        this.systemVersion = systemVersion;
    }

    public int getApiId() {
        return apiId;
    }

    public void setApiId(int apiId) {
        this.apiId = apiId;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public int getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(int dateCreated) {
        this.dateCreated = dateCreated;
    }

    public int getDateActive() {
        return dateActive;
    }

    public void setDateActive(int dateActive) {
        this.dateActive = dateActive;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}
