package com.github.badoualy.telegram.tl.api;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageMediaAudio extends TLAbsMessageMedia {
    public static final int CLASS_ID = 0xc6b68300;

    protected TLAbsAudio audio;

    public TLMessageMediaAudio() {
    }

    public TLMessageMediaAudio(TLAbsAudio audio) {
        this.audio = audio;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(audio, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        audio = (com.github.badoualy.telegram.tl.api.TLAbsAudio) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "messageMediaAudio#c6b68300";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsAudio getAudio() {
        return audio;
    }

    public void setAudio(TLAbsAudio audio) {
        this.audio = audio;
    }
}
