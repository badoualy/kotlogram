
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLConfig extends TLObject {

    public static final int CLASS_ID = 0x2e54dd74;

    public TLConfig() {

    }


    public TLConfig(        int _date,         boolean _testMode,         int _thisDc,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDcOption> _dcOptions,         int _chatSizeMax,         int _broadcastSizeMax) {
        this.date = _date;
        this.testMode = _testMode;
        this.thisDc = _thisDc;
        this.dcOptions = _dcOptions;
        this.chatSizeMax = _chatSizeMax;
        this.broadcastSizeMax = _broadcastSizeMax;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int date;

    protected boolean testMode;

    protected int thisDc;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLDcOption> dcOptions;

    protected int chatSizeMax;

    protected int broadcastSizeMax;


    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
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

    public int getBroadcastSizeMax() {
        return broadcastSizeMax;
    }

    public void setBroadcastSizeMax(int value) {
        this.broadcastSizeMax = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.date, stream);
        writeTLBool(this.testMode, stream);
        writeInt(this.thisDc, stream);
        writeTLVector(this.dcOptions, stream);
        writeInt(this.chatSizeMax, stream);
        writeInt(this.broadcastSizeMax, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.date = readInt(stream);
        this.testMode = readTLBool(stream);
        this.thisDc = readInt(stream);
        this.dcOptions = readTLVector(stream, context);
        this.chatSizeMax = readInt(stream);
        this.broadcastSizeMax = readInt(stream);
    }


    @Override
    public String toString() {
        return "config#2e54dd74";
    }

}
