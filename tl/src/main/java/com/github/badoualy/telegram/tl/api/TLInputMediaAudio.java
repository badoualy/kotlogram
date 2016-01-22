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
public class TLInputMediaAudio extends TLAbsInputMedia {
    public static final int CLASS_ID = 0x89938781;

    protected TLAbsInputAudio id;

    public TLInputMediaAudio() {
    }

    public TLInputMediaAudio(TLAbsInputAudio id) {
        this.id = id;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(id, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = (com.github.badoualy.telegram.tl.api.TLAbsInputAudio) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "inputMediaAudio#89938781";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsInputAudio getId() {
        return id;
    }

    public void setId(TLAbsInputAudio id) {
        this.id = id;
    }
}
