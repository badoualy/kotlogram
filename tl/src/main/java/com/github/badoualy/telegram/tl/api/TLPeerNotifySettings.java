
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLPeerNotifySettings extends TLAbsPeerNotifySettings {
    public static final int CLASS_ID = 0x8d5e11ee;

    public TLPeerNotifySettings() {

    }


    public TLPeerNotifySettings(        int _muteUntil,         String _sound,         boolean _showPreviews,         int _eventsMask) {
        this.muteUntil = _muteUntil;
        this.sound = _sound;
        this.showPreviews = _showPreviews;
        this.eventsMask = _eventsMask;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int muteUntil;

    protected String sound;

    protected boolean showPreviews;

    protected int eventsMask;


    public int getMuteUntil() {
        return muteUntil;
    }

    public void setMuteUntil(int value) {
        this.muteUntil = value;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String value) {
        this.sound = value;
    }

    public boolean getShowPreviews() {
        return showPreviews;
    }

    public void setShowPreviews(boolean value) {
        this.showPreviews = value;
    }

    public int getEventsMask() {
        return eventsMask;
    }

    public void setEventsMask(int value) {
        this.eventsMask = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.muteUntil, stream);
        writeTLString(this.sound, stream);
        writeTLBool(this.showPreviews, stream);
        writeInt(this.eventsMask, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.muteUntil = readInt(stream);
        this.sound = readTLString(stream);
        this.showPreviews = readTLBool(stream);
        this.eventsMask = readInt(stream);
    }



    @Override
    public String toString() {
        return "peerNotifySettings#8d5e11ee";
    }

}
