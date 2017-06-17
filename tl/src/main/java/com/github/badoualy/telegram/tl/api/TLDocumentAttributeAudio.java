package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLBytesSerializedSize;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDocumentAttributeAudio extends TLAbsDocumentAttribute {

    public static final int CONSTRUCTOR_ID = 0x9852f9c6;

    protected int flags;

    protected boolean voice;

    protected int duration;

    protected String title;

    protected String performer;

    protected TLBytes waveform;

    private final String _constructor = "documentAttributeAudio#9852f9c6";

    public TLDocumentAttributeAudio() {
    }

    public TLDocumentAttributeAudio(boolean voice, int duration, String title, String performer, TLBytes waveform) {
        this.voice = voice;
        this.duration = duration;
        this.title = title;
        this.performer = performer;
        this.waveform = waveform;
    }

    private void computeFlags() {
        flags = 0;
        flags = voice ? (flags | 1024) : (flags & ~1024);
        flags = title != null ? (flags | 1) : (flags & ~1);
        flags = performer != null ? (flags | 2) : (flags & ~2);
        flags = waveform != null ? (flags | 4) : (flags & ~4);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(duration, stream);
        if ((flags & 1) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 2) != 0) {
            if (performer == null) throwNullFieldException("performer", flags);
            writeString(performer, stream);
        }
        if ((flags & 4) != 0) {
            if (waveform == null) throwNullFieldException("waveform", flags);
            writeTLBytes(waveform, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        voice = (flags & 1024) != 0;
        duration = readInt(stream);
        title = (flags & 1) != 0 ? readTLString(stream) : null;
        performer = (flags & 2) != 0 ? readTLString(stream) : null;
        waveform = (flags & 4) != 0 ? readTLBytes(stream, context) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        if ((flags & 1) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 2) != 0) {
            if (performer == null) throwNullFieldException("performer", flags);
            size += computeTLStringSerializedSize(performer);
        }
        if ((flags & 4) != 0) {
            if (waveform == null) throwNullFieldException("waveform", flags);
            size += computeTLBytesSerializedSize(waveform);
        }
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

    public boolean getVoice() {
        return voice;
    }

    public void setVoice(boolean voice) {
        this.voice = voice;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public TLBytes getWaveform() {
        return waveform;
    }

    public void setWaveform(TLBytes waveform) {
        this.waveform = waveform;
    }
}
