package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLFoundGif extends TLAbsFoundGif {
    public static final int CONSTRUCTOR_ID = 0x162ecc1f;

    protected String thumbUrl;

    protected String contentUrl;

    protected String contentType;

    protected int w;

    protected int h;

    public TLFoundGif() {
    }

    public TLFoundGif(String url, String thumbUrl, String contentUrl, String contentType, int w, int h) {
        this.url = url;
        this.thumbUrl = thumbUrl;
        this.contentUrl = contentUrl;
        this.contentType = contentType;
        this.w = w;
        this.h = h;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLString(url, stream);
        writeTLString(thumbUrl, stream);
        writeTLString(contentUrl, stream);
        writeTLString(contentType, stream);
        writeInt(w, stream);
        writeInt(h, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        url = readTLString(stream);
        thumbUrl = readTLString(stream);
        contentUrl = readTLString(stream);
        contentType = readTLString(stream);
        w = readInt(stream);
        h = readInt(stream);
    }

    @Override
    public String toString() {
        return "foundGif#162ecc1f";
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

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String thumbUrl) {
        this.thumbUrl = thumbUrl;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String contentUrl) {
        this.contentUrl = contentUrl;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }
}
