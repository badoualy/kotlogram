package com.github.badoualy.telegram.tl.api;

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
public class TLInputMediaGifExternal extends TLAbsInputMedia {
    public static final int CONSTRUCTOR_ID = 0x4843b0fd;

    protected String url;

    protected String q;

    public TLInputMediaGifExternal() {
    }

    public TLInputMediaGifExternal(String url, String q) {
        this.url = url;
        this.q = q;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(url, stream);
        writeTLString(q, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        url = readTLString(stream);
        q = readTLString(stream);
    }

    @Override
    public String toString() {
        return "inputMediaGifExternal#4843b0fd";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }
}
