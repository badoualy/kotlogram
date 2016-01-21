
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLConfig extends TLObject {

    public static final int CLASS_ID = 0x6bbc5f8;

    public TLConfig() {

    }


    public TLConfig(        int _date,         int _expires,         boolean _testMode,         int _thisDc,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDcOption> _dcOptions,         int _chatSizeMax,         int _megagroupSizeMax,         int _forwardedCountMax,         int _onlineUpdatePeriodMs,         int _offlineBlurTimeoutMs,         int _offlineIdleTimeoutMs,         int _onlineCloudTimeoutMs,         int _notifyCloudDelayMs,         int _notifyDefaultDelayMs,         int _chatBigSize,         int _pushChatPeriodMs,         int _pushChatLimit,         int _savedGifsLimit,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDisabledFeature> _disabledFeatures) {
        this.date = _date;
        this.expires = _expires;
        this.testMode = _testMode;
        this.thisDc = _thisDc;
        this.dcOptions = _dcOptions;
        this.chatSizeMax = _chatSizeMax;
        this.megagroupSizeMax = _megagroupSizeMax;
        this.forwardedCountMax = _forwardedCountMax;
        this.onlineUpdatePeriodMs = _onlineUpdatePeriodMs;
        this.offlineBlurTimeoutMs = _offlineBlurTimeoutMs;
        this.offlineIdleTimeoutMs = _offlineIdleTimeoutMs;
        this.onlineCloudTimeoutMs = _onlineCloudTimeoutMs;
        this.notifyCloudDelayMs = _notifyCloudDelayMs;
        this.notifyDefaultDelayMs = _notifyDefaultDelayMs;
        this.chatBigSize = _chatBigSize;
        this.pushChatPeriodMs = _pushChatPeriodMs;
        this.pushChatLimit = _pushChatLimit;
        this.savedGifsLimit = _savedGifsLimit;
        this.disabledFeatures = _disabledFeatures;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int date;

    protected int expires;

    protected boolean testMode;

    protected int thisDc;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDcOption> dcOptions;

    protected int chatSizeMax;

    protected int megagroupSizeMax;

    protected int forwardedCountMax;

    protected int onlineUpdatePeriodMs;

    protected int offlineBlurTimeoutMs;

    protected int offlineIdleTimeoutMs;

    protected int onlineCloudTimeoutMs;

    protected int notifyCloudDelayMs;

    protected int notifyDefaultDelayMs;

    protected int chatBigSize;

    protected int pushChatPeriodMs;

    protected int pushChatLimit;

    protected int savedGifsLimit;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDisabledFeature> disabledFeatures;


    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int value) {
        this.expires = value;
    }

    public boolean getTestMode() {
        return testMode;
    }

    public void setTestMode(boolean value) {
        this.testMode = value;
    }

    public int getThisDc() {
        return thisDc;
    }

    public void setThisDc(int value) {
        this.thisDc = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDcOption> getDcOptions() {
        return dcOptions;
    }

    public void setDcOptions(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDcOption> value) {
        this.dcOptions = value;
    }

    public int getChatSizeMax() {
        return chatSizeMax;
    }

    public void setChatSizeMax(int value) {
        this.chatSizeMax = value;
    }

    public int getMegagroupSizeMax() {
        return megagroupSizeMax;
    }

    public void setMegagroupSizeMax(int value) {
        this.megagroupSizeMax = value;
    }

    public int getForwardedCountMax() {
        return forwardedCountMax;
    }

    public void setForwardedCountMax(int value) {
        this.forwardedCountMax = value;
    }

    public int getOnlineUpdatePeriodMs() {
        return onlineUpdatePeriodMs;
    }

    public void setOnlineUpdatePeriodMs(int value) {
        this.onlineUpdatePeriodMs = value;
    }

    public int getOfflineBlurTimeoutMs() {
        return offlineBlurTimeoutMs;
    }

    public void setOfflineBlurTimeoutMs(int value) {
        this.offlineBlurTimeoutMs = value;
    }

    public int getOfflineIdleTimeoutMs() {
        return offlineIdleTimeoutMs;
    }

    public void setOfflineIdleTimeoutMs(int value) {
        this.offlineIdleTimeoutMs = value;
    }

    public int getOnlineCloudTimeoutMs() {
        return onlineCloudTimeoutMs;
    }

    public void setOnlineCloudTimeoutMs(int value) {
        this.onlineCloudTimeoutMs = value;
    }

    public int getNotifyCloudDelayMs() {
        return notifyCloudDelayMs;
    }

    public void setNotifyCloudDelayMs(int value) {
        this.notifyCloudDelayMs = value;
    }

    public int getNotifyDefaultDelayMs() {
        return notifyDefaultDelayMs;
    }

    public void setNotifyDefaultDelayMs(int value) {
        this.notifyDefaultDelayMs = value;
    }

    public int getChatBigSize() {
        return chatBigSize;
    }

    public void setChatBigSize(int value) {
        this.chatBigSize = value;
    }

    public int getPushChatPeriodMs() {
        return pushChatPeriodMs;
    }

    public void setPushChatPeriodMs(int value) {
        this.pushChatPeriodMs = value;
    }

    public int getPushChatLimit() {
        return pushChatLimit;
    }

    public void setPushChatLimit(int value) {
        this.pushChatLimit = value;
    }

    public int getSavedGifsLimit() {
        return savedGifsLimit;
    }

    public void setSavedGifsLimit(int value) {
        this.savedGifsLimit = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDisabledFeature> getDisabledFeatures() {
        return disabledFeatures;
    }

    public void setDisabledFeatures(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDisabledFeature> value) {
        this.disabledFeatures = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.date, stream);
        writeInt(this.expires, stream);
        writeTLBool(this.testMode, stream);
        writeInt(this.thisDc, stream);
        writeTLVector(this.dcOptions, stream);
        writeInt(this.chatSizeMax, stream);
        writeInt(this.megagroupSizeMax, stream);
        writeInt(this.forwardedCountMax, stream);
        writeInt(this.onlineUpdatePeriodMs, stream);
        writeInt(this.offlineBlurTimeoutMs, stream);
        writeInt(this.offlineIdleTimeoutMs, stream);
        writeInt(this.onlineCloudTimeoutMs, stream);
        writeInt(this.notifyCloudDelayMs, stream);
        writeInt(this.notifyDefaultDelayMs, stream);
        writeInt(this.chatBigSize, stream);
        writeInt(this.pushChatPeriodMs, stream);
        writeInt(this.pushChatLimit, stream);
        writeInt(this.savedGifsLimit, stream);
        writeTLVector(this.disabledFeatures, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.date = readInt(stream);
        this.expires = readInt(stream);
        this.testMode = readTLBool(stream);
        this.thisDc = readInt(stream);
        this.dcOptions = readTLVector(stream, context);
        this.chatSizeMax = readInt(stream);
        this.megagroupSizeMax = readInt(stream);
        this.forwardedCountMax = readInt(stream);
        this.onlineUpdatePeriodMs = readInt(stream);
        this.offlineBlurTimeoutMs = readInt(stream);
        this.offlineIdleTimeoutMs = readInt(stream);
        this.onlineCloudTimeoutMs = readInt(stream);
        this.notifyCloudDelayMs = readInt(stream);
        this.notifyDefaultDelayMs = readInt(stream);
        this.chatBigSize = readInt(stream);
        this.pushChatPeriodMs = readInt(stream);
        this.pushChatLimit = readInt(stream);
        this.savedGifsLimit = readInt(stream);
        this.disabledFeatures = readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "config#6bbc5f8";
    }

}
