package com.github.badoualy.telegram.tl.api.help;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLAppChangelog extends TLAbsAppChangelog {
    public static final int CLASS_ID = 0x4668e6bd;

    protected String text;

    public TLAppChangelog() {
    }

    public TLAppChangelog(String text) {
        this.text = text;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(text, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        text = readTLString(stream);
    }

    @Override
    public String toString() {
        return "help.appChangelog#4668e6bd";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
