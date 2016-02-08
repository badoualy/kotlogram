package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_BOOLEAN;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPeerNotifySettings extends TLAbsPeerNotifySettings {
    public static final int CONSTRUCTOR_ID = 0x8d5e11ee;

    protected int muteUntil;

    protected String sound;

    protected boolean showPreviews;

    protected int eventsMask;

    public TLPeerNotifySettings() {
    }

    public TLPeerNotifySettings(int muteUntil, String sound, boolean showPreviews, int eventsMask) {
        this.muteUntil = muteUntil;
        this.sound = sound;
        this.showPreviews = showPreviews;
        this.eventsMask = eventsMask;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(muteUntil, stream);
        writeString(sound, stream);
        writeBoolean(showPreviews, stream);
        writeInt(eventsMask, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        muteUntil = readInt(stream);
        sound = readTLString(stream);
        showPreviews = readTLBool(stream);
        eventsMask = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(sound);
        size += SIZE_BOOLEAN;
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return "peerNotifySettings#8d5e11ee";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getMuteUntil() {
        return muteUntil;
    }

    public void setMuteUntil(int muteUntil) {
        this.muteUntil = muteUntil;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public boolean getShowPreviews() {
        return showPreviews;
    }

    public void setShowPreviews(boolean showPreviews) {
        this.showPreviews = showPreviews;
    }

    public int getEventsMask() {
        return eventsMask;
    }

    public void setEventsMask(int eventsMask) {
        this.eventsMask = eventsMask;
    }

    @Override
    public final boolean isEmpty() {
        return false;
    }

    @Override
    public final boolean isNotEmpty() {
        return true;
    }

    @Override
    public final TLPeerNotifySettings getAsPeerNotifySettings() {
        return this;
    }
}
