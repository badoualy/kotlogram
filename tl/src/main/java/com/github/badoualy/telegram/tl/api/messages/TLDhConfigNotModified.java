package com.github.badoualy.telegram.tl.api.messages;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
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
public class TLDhConfigNotModified extends TLAbsDhConfig {
    public static final int CLASS_ID = 0xc0e24635;

    protected TLBytes random;

    public TLDhConfigNotModified() {
    }

    public TLDhConfigNotModified(TLBytes random) {
        this.random = random;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLBytes(random, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        random = readTLBytes(stream, context);
    }

    @Override
    public String toString() {
        return "messages.dhConfigNotModified#c0e24635";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLBytes getRandom() {
        return random;
    }

    public void setRandom(TLBytes random) {
        this.random = random;
    }
}
