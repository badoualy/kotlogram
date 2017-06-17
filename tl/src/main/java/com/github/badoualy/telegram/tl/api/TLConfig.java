package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLConfig extends TLObject {

    public static final int CONSTRUCTOR_ID = 0xcb601684;

    protected int flags;

    protected boolean phonecallsEnabled;

    protected int date;

    protected int expires;

    protected boolean testMode;

    protected int thisDc;

    protected TLVector<TLDcOption> dcOptions;

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

    protected int editTimeLimit;

    protected int ratingEDecay;

    protected int stickersRecentLimit;

    protected Integer tmpSessions;

    protected int pinnedDialogsCountMax;

    protected int callReceiveTimeoutMs;

    protected int callRingTimeoutMs;

    protected int callConnectTimeoutMs;

    protected int callPacketTimeoutMs;

    protected String meUrlPrefix;

    protected TLVector<TLDisabledFeature> disabledFeatures;

    private final String _constructor = "config#cb601684";

    public TLConfig() {
    }

    public TLConfig(boolean phonecallsEnabled, int date, int expires, boolean testMode, int thisDc, TLVector<TLDcOption> dcOptions, int chatSizeMax, int megagroupSizeMax, int forwardedCountMax, int onlineUpdatePeriodMs, int offlineBlurTimeoutMs, int offlineIdleTimeoutMs, int onlineCloudTimeoutMs, int notifyCloudDelayMs, int notifyDefaultDelayMs, int chatBigSize, int pushChatPeriodMs, int pushChatLimit, int savedGifsLimit, int editTimeLimit, int ratingEDecay, int stickersRecentLimit, Integer tmpSessions, int pinnedDialogsCountMax, int callReceiveTimeoutMs, int callRingTimeoutMs, int callConnectTimeoutMs, int callPacketTimeoutMs, String meUrlPrefix, TLVector<TLDisabledFeature> disabledFeatures) {
        this.phonecallsEnabled = phonecallsEnabled;
        this.date = date;
        this.expires = expires;
        this.testMode = testMode;
        this.thisDc = thisDc;
        this.dcOptions = dcOptions;
        this.chatSizeMax = chatSizeMax;
        this.megagroupSizeMax = megagroupSizeMax;
        this.forwardedCountMax = forwardedCountMax;
        this.onlineUpdatePeriodMs = onlineUpdatePeriodMs;
        this.offlineBlurTimeoutMs = offlineBlurTimeoutMs;
        this.offlineIdleTimeoutMs = offlineIdleTimeoutMs;
        this.onlineCloudTimeoutMs = onlineCloudTimeoutMs;
        this.notifyCloudDelayMs = notifyCloudDelayMs;
        this.notifyDefaultDelayMs = notifyDefaultDelayMs;
        this.chatBigSize = chatBigSize;
        this.pushChatPeriodMs = pushChatPeriodMs;
        this.pushChatLimit = pushChatLimit;
        this.savedGifsLimit = savedGifsLimit;
        this.editTimeLimit = editTimeLimit;
        this.ratingEDecay = ratingEDecay;
        this.stickersRecentLimit = stickersRecentLimit;
        this.tmpSessions = tmpSessions;
        this.pinnedDialogsCountMax = pinnedDialogsCountMax;
        this.callReceiveTimeoutMs = callReceiveTimeoutMs;
        this.callRingTimeoutMs = callRingTimeoutMs;
        this.callConnectTimeoutMs = callConnectTimeoutMs;
        this.callPacketTimeoutMs = callPacketTimeoutMs;
        this.meUrlPrefix = meUrlPrefix;
        this.disabledFeatures = disabledFeatures;
    }

    private void computeFlags() {
        flags = 0;
        flags = phonecallsEnabled ? (flags | 2) : (flags & ~2);
        flags = tmpSessions != null ? (flags | 1) : (flags & ~1);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(date, stream);
        writeInt(expires, stream);
        writeBoolean(testMode, stream);
        writeInt(thisDc, stream);
        writeTLVector(dcOptions, stream);
        writeInt(chatSizeMax, stream);
        writeInt(megagroupSizeMax, stream);
        writeInt(forwardedCountMax, stream);
        writeInt(onlineUpdatePeriodMs, stream);
        writeInt(offlineBlurTimeoutMs, stream);
        writeInt(offlineIdleTimeoutMs, stream);
        writeInt(onlineCloudTimeoutMs, stream);
        writeInt(notifyCloudDelayMs, stream);
        writeInt(notifyDefaultDelayMs, stream);
        writeInt(chatBigSize, stream);
        writeInt(pushChatPeriodMs, stream);
        writeInt(pushChatLimit, stream);
        writeInt(savedGifsLimit, stream);
        writeInt(editTimeLimit, stream);
        writeInt(ratingEDecay, stream);
        writeInt(stickersRecentLimit, stream);
        if ((flags & 1) != 0) {
            if (tmpSessions == null) throwNullFieldException("tmpSessions", flags);
            writeInt(tmpSessions, stream);
        }
        writeInt(pinnedDialogsCountMax, stream);
        writeInt(callReceiveTimeoutMs, stream);
        writeInt(callRingTimeoutMs, stream);
        writeInt(callConnectTimeoutMs, stream);
        writeInt(callPacketTimeoutMs, stream);
        writeString(meUrlPrefix, stream);
        writeTLVector(disabledFeatures, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        phonecallsEnabled = (flags & 2) != 0;
        date = readInt(stream);
        expires = readInt(stream);
        testMode = readTLBool(stream);
        thisDc = readInt(stream);
        dcOptions = readTLVector(stream, context);
        chatSizeMax = readInt(stream);
        megagroupSizeMax = readInt(stream);
        forwardedCountMax = readInt(stream);
        onlineUpdatePeriodMs = readInt(stream);
        offlineBlurTimeoutMs = readInt(stream);
        offlineIdleTimeoutMs = readInt(stream);
        onlineCloudTimeoutMs = readInt(stream);
        notifyCloudDelayMs = readInt(stream);
        notifyDefaultDelayMs = readInt(stream);
        chatBigSize = readInt(stream);
        pushChatPeriodMs = readInt(stream);
        pushChatLimit = readInt(stream);
        savedGifsLimit = readInt(stream);
        editTimeLimit = readInt(stream);
        ratingEDecay = readInt(stream);
        stickersRecentLimit = readInt(stream);
        tmpSessions = (flags & 1) != 0 ? readInt(stream) : null;
        pinnedDialogsCountMax = readInt(stream);
        callReceiveTimeoutMs = readInt(stream);
        callRingTimeoutMs = readInt(stream);
        callConnectTimeoutMs = readInt(stream);
        callPacketTimeoutMs = readInt(stream);
        meUrlPrefix = readTLString(stream);
        disabledFeatures = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_BOOLEAN;
        size += SIZE_INT32;
        size += dcOptions.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (tmpSessions == null) throwNullFieldException("tmpSessions", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(meUrlPrefix);
        size += disabledFeatures.computeSerializedSize();
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

    public boolean getPhonecallsEnabled() {
        return phonecallsEnabled;
    }

    public void setPhonecallsEnabled(boolean phonecallsEnabled) {
        this.phonecallsEnabled = phonecallsEnabled;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getExpires() {
        return expires;
    }

    public void setExpires(int expires) {
        this.expires = expires;
    }

    public boolean getTestMode() {
        return testMode;
    }

    public void setTestMode(boolean testMode) {
        this.testMode = testMode;
    }

    public int getThisDc() {
        return thisDc;
    }

    public void setThisDc(int thisDc) {
        this.thisDc = thisDc;
    }

    public TLVector<TLDcOption> getDcOptions() {
        return dcOptions;
    }

    public void setDcOptions(TLVector<TLDcOption> dcOptions) {
        this.dcOptions = dcOptions;
    }

    public int getChatSizeMax() {
        return chatSizeMax;
    }

    public void setChatSizeMax(int chatSizeMax) {
        this.chatSizeMax = chatSizeMax;
    }

    public int getMegagroupSizeMax() {
        return megagroupSizeMax;
    }

    public void setMegagroupSizeMax(int megagroupSizeMax) {
        this.megagroupSizeMax = megagroupSizeMax;
    }

    public int getForwardedCountMax() {
        return forwardedCountMax;
    }

    public void setForwardedCountMax(int forwardedCountMax) {
        this.forwardedCountMax = forwardedCountMax;
    }

    public int getOnlineUpdatePeriodMs() {
        return onlineUpdatePeriodMs;
    }

    public void setOnlineUpdatePeriodMs(int onlineUpdatePeriodMs) {
        this.onlineUpdatePeriodMs = onlineUpdatePeriodMs;
    }

    public int getOfflineBlurTimeoutMs() {
        return offlineBlurTimeoutMs;
    }

    public void setOfflineBlurTimeoutMs(int offlineBlurTimeoutMs) {
        this.offlineBlurTimeoutMs = offlineBlurTimeoutMs;
    }

    public int getOfflineIdleTimeoutMs() {
        return offlineIdleTimeoutMs;
    }

    public void setOfflineIdleTimeoutMs(int offlineIdleTimeoutMs) {
        this.offlineIdleTimeoutMs = offlineIdleTimeoutMs;
    }

    public int getOnlineCloudTimeoutMs() {
        return onlineCloudTimeoutMs;
    }

    public void setOnlineCloudTimeoutMs(int onlineCloudTimeoutMs) {
        this.onlineCloudTimeoutMs = onlineCloudTimeoutMs;
    }

    public int getNotifyCloudDelayMs() {
        return notifyCloudDelayMs;
    }

    public void setNotifyCloudDelayMs(int notifyCloudDelayMs) {
        this.notifyCloudDelayMs = notifyCloudDelayMs;
    }

    public int getNotifyDefaultDelayMs() {
        return notifyDefaultDelayMs;
    }

    public void setNotifyDefaultDelayMs(int notifyDefaultDelayMs) {
        this.notifyDefaultDelayMs = notifyDefaultDelayMs;
    }

    public int getChatBigSize() {
        return chatBigSize;
    }

    public void setChatBigSize(int chatBigSize) {
        this.chatBigSize = chatBigSize;
    }

    public int getPushChatPeriodMs() {
        return pushChatPeriodMs;
    }

    public void setPushChatPeriodMs(int pushChatPeriodMs) {
        this.pushChatPeriodMs = pushChatPeriodMs;
    }

    public int getPushChatLimit() {
        return pushChatLimit;
    }

    public void setPushChatLimit(int pushChatLimit) {
        this.pushChatLimit = pushChatLimit;
    }

    public int getSavedGifsLimit() {
        return savedGifsLimit;
    }

    public void setSavedGifsLimit(int savedGifsLimit) {
        this.savedGifsLimit = savedGifsLimit;
    }

    public int getEditTimeLimit() {
        return editTimeLimit;
    }

    public void setEditTimeLimit(int editTimeLimit) {
        this.editTimeLimit = editTimeLimit;
    }

    public int getRatingEDecay() {
        return ratingEDecay;
    }

    public void setRatingEDecay(int ratingEDecay) {
        this.ratingEDecay = ratingEDecay;
    }

    public int getStickersRecentLimit() {
        return stickersRecentLimit;
    }

    public void setStickersRecentLimit(int stickersRecentLimit) {
        this.stickersRecentLimit = stickersRecentLimit;
    }

    public Integer getTmpSessions() {
        return tmpSessions;
    }

    public void setTmpSessions(Integer tmpSessions) {
        this.tmpSessions = tmpSessions;
    }

    public int getPinnedDialogsCountMax() {
        return pinnedDialogsCountMax;
    }

    public void setPinnedDialogsCountMax(int pinnedDialogsCountMax) {
        this.pinnedDialogsCountMax = pinnedDialogsCountMax;
    }

    public int getCallReceiveTimeoutMs() {
        return callReceiveTimeoutMs;
    }

    public void setCallReceiveTimeoutMs(int callReceiveTimeoutMs) {
        this.callReceiveTimeoutMs = callReceiveTimeoutMs;
    }

    public int getCallRingTimeoutMs() {
        return callRingTimeoutMs;
    }

    public void setCallRingTimeoutMs(int callRingTimeoutMs) {
        this.callRingTimeoutMs = callRingTimeoutMs;
    }

    public int getCallConnectTimeoutMs() {
        return callConnectTimeoutMs;
    }

    public void setCallConnectTimeoutMs(int callConnectTimeoutMs) {
        this.callConnectTimeoutMs = callConnectTimeoutMs;
    }

    public int getCallPacketTimeoutMs() {
        return callPacketTimeoutMs;
    }

    public void setCallPacketTimeoutMs(int callPacketTimeoutMs) {
        this.callPacketTimeoutMs = callPacketTimeoutMs;
    }

    public String getMeUrlPrefix() {
        return meUrlPrefix;
    }

    public void setMeUrlPrefix(String meUrlPrefix) {
        this.meUrlPrefix = meUrlPrefix;
    }

    public TLVector<TLDisabledFeature> getDisabledFeatures() {
        return disabledFeatures;
    }

    public void setDisabledFeatures(TLVector<TLDisabledFeature> disabledFeatures) {
        this.disabledFeatures = disabledFeatures;
    }
}
