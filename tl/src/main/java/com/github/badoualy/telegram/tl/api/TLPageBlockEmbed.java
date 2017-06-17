package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT64;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLPageBlockEmbed extends TLAbsPageBlock {

    public static final int CONSTRUCTOR_ID = 0xcde200d1;

    protected int flags;

    protected boolean fullWidth;

    protected boolean allowScrolling;

    protected String url;

    protected String html;

    protected Long posterPhotoId;

    protected int w;

    protected int h;

    protected TLAbsRichText caption;

    private final String _constructor = "pageBlockEmbed#cde200d1";

    public TLPageBlockEmbed() {
    }

    public TLPageBlockEmbed(boolean fullWidth, boolean allowScrolling, String url, String html, Long posterPhotoId, int w, int h, TLAbsRichText caption) {
        this.fullWidth = fullWidth;
        this.allowScrolling = allowScrolling;
        this.url = url;
        this.html = html;
        this.posterPhotoId = posterPhotoId;
        this.w = w;
        this.h = h;
        this.caption = caption;
    }

    private void computeFlags() {
        flags = 0;
        flags = fullWidth ? (flags | 1) : (flags & ~1);
        flags = allowScrolling ? (flags | 8) : (flags & ~8);
        flags = url != null ? (flags | 2) : (flags & ~2);
        flags = html != null ? (flags | 4) : (flags & ~4);
        flags = posterPhotoId != null ? (flags | 16) : (flags & ~16);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        if ((flags & 2) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            writeString(url, stream);
        }
        if ((flags & 4) != 0) {
            if (html == null) throwNullFieldException("html", flags);
            writeString(html, stream);
        }
        if ((flags & 16) != 0) {
            if (posterPhotoId == null) throwNullFieldException("posterPhotoId", flags);
            writeLong(posterPhotoId, stream);
        }
        writeInt(w, stream);
        writeInt(h, stream);
        writeTLObject(caption, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        fullWidth = (flags & 1) != 0;
        allowScrolling = (flags & 8) != 0;
        url = (flags & 2) != 0 ? readTLString(stream) : null;
        html = (flags & 4) != 0 ? readTLString(stream) : null;
        posterPhotoId = (flags & 16) != 0 ? readLong(stream) : null;
        w = readInt(stream);
        h = readInt(stream);
        caption = readTLObject(stream, context, TLAbsRichText.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        if ((flags & 2) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            size += computeTLStringSerializedSize(url);
        }
        if ((flags & 4) != 0) {
            if (html == null) throwNullFieldException("html", flags);
            size += computeTLStringSerializedSize(html);
        }
        if ((flags & 16) != 0) {
            if (posterPhotoId == null) throwNullFieldException("posterPhotoId", flags);
            size += SIZE_INT64;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += caption.computeSerializedSize();
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

    public boolean getFullWidth() {
        return fullWidth;
    }

    public void setFullWidth(boolean fullWidth) {
        this.fullWidth = fullWidth;
    }

    public boolean getAllowScrolling() {
        return allowScrolling;
    }

    public void setAllowScrolling(boolean allowScrolling) {
        this.allowScrolling = allowScrolling;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getHtml() {
        return html;
    }

    public void setHtml(String html) {
        this.html = html;
    }

    public Long getPosterPhotoId() {
        return posterPhotoId;
    }

    public void setPosterPhotoId(Long posterPhotoId) {
        this.posterPhotoId = posterPhotoId;
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

    public TLAbsRichText getCaption() {
        return caption;
    }

    public void setCaption(TLAbsRichText caption) {
        this.caption = caption;
    }
}
