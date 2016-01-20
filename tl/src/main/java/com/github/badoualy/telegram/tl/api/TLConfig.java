
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

    public static final int CLASS_ID = 0x7dae33e0;

    public TLConfig() {

    }


    public TLConfig(        int _date,         int _expires,         boolean _testMode,         int _thisDc,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDcOption> _dcOptions,         int _chatBigSize,         int _chatSizeMax,         int _broadcastSizeMax,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDisabledFeature> _disabledFeatures) {
        this.date = _date;
        this.expires = _expires;
        this.testMode = _testMode;
        this.thisDc = _thisDc;
        this.dcOptions = _dcOptions;
        this.chatBigSize = _chatBigSize;
        this.chatSizeMax = _chatSizeMax;
        this.broadcastSizeMax = _broadcastSizeMax;
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

    protected int chatBigSize;

    protected int chatSizeMax;

    protected int broadcastSizeMax;

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

    public int getChatBigSize() {
        return chatBigSize;
    }

    public void setChatBigSize(int value) {
        this.chatBigSize = value;
    }

    public int getChatSizeMax() {
        return chatSizeMax;
    }

    public void setChatSizeMax(int value) {
        this.chatSizeMax = value;
    }

    public int getBroadcastSizeMax() {
        return broadcastSizeMax;
    }

    public void setBroadcastSizeMax(int value) {
        this.broadcastSizeMax = value;
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
        writeInt(this.chatBigSize, stream);
        writeInt(this.chatSizeMax, stream);
        writeInt(this.broadcastSizeMax, stream);
        writeTLVector(this.disabledFeatures, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.date = readInt(stream);
        this.expires = readInt(stream);
        this.testMode = readTLBool(stream);
        this.thisDc = readInt(stream);
        this.dcOptions = readTLVector(stream, context);
        this.chatBigSize = readInt(stream);
        this.chatSizeMax = readInt(stream);
        this.broadcastSizeMax = readInt(stream);
        this.disabledFeatures = readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "config#7dae33e0";
    }

}
