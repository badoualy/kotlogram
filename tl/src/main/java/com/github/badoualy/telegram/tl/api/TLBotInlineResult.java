package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotInlineResult extends TLAbsBotInlineResult {

    public static final int CONSTRUCTOR_ID = 0x9bebaeb9;

    protected String title;

    protected String description;

    protected String url;

    protected String thumbUrl;

    protected String contentUrl;

    protected String contentType;

    protected Integer w;

    protected Integer h;

    protected Integer duration;

    private final String _constructor = "botInlineResult#9bebaeb9";

    public TLBotInlineResult() {
    }

    public TLBotInlineResult(String id, String type, String title, String description, String url, String thumbUrl, String contentUrl, String contentType, Integer w, Integer h, Integer duration, TLAbsBotInlineMessage sendMessage) {
        this.id = id;
        this.type = type;
        this.title = title;
        this.description = description;
        this.url = url;
        this.thumbUrl = thumbUrl;
        this.contentUrl = contentUrl;
        this.contentType = contentType;
        this.w = w;
        this.h = h;
        this.duration = duration;
        this.sendMessage = sendMessage;
    }

    private void computeFlags() {
        flags = 0;
        flags = title != null ? (flags | 2) : (flags & ~2);
        flags = description != null ? (flags | 4) : (flags & ~4);
        flags = url != null ? (flags | 8) : (flags & ~8);
        flags = thumbUrl != null ? (flags | 16) : (flags & ~16);
        flags = contentUrl != null ? (flags | 32) : (flags & ~32);
        flags = contentType != null ? (flags | 32) : (flags & ~32);
        flags = w != null ? (flags | 64) : (flags & ~64);
        flags = h != null ? (flags | 64) : (flags & ~64);
        flags = duration != null ? (flags | 128) : (flags & ~128);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeString(id, stream);
        writeString(type, stream);
        if ((flags & 2) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            writeString(title, stream);
        }
        if ((flags & 4) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            writeString(description, stream);
        }
        if ((flags & 8) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            writeString(url, stream);
        }
        if ((flags & 16) != 0) {
            if (thumbUrl == null) throwNullFieldException("thumbUrl", flags);
            writeString(thumbUrl, stream);
        }
        if ((flags & 32) != 0) {
            if (contentUrl == null) throwNullFieldException("contentUrl", flags);
            writeString(contentUrl, stream);
        }
        if ((flags & 32) != 0) {
            if (contentType == null) throwNullFieldException("contentType", flags);
            writeString(contentType, stream);
        }
        if ((flags & 64) != 0) {
            if (w == null) throwNullFieldException("w", flags);
            writeInt(w, stream);
        }
        if ((flags & 64) != 0) {
            if (h == null) throwNullFieldException("h", flags);
            writeInt(h, stream);
        }
        if ((flags & 128) != 0) {
            if (duration == null) throwNullFieldException("duration", flags);
            writeInt(duration, stream);
        }
        writeTLObject(sendMessage, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        id = readTLString(stream);
        type = readTLString(stream);
        title = (flags & 2) != 0 ? readTLString(stream) : null;
        description = (flags & 4) != 0 ? readTLString(stream) : null;
        url = (flags & 8) != 0 ? readTLString(stream) : null;
        thumbUrl = (flags & 16) != 0 ? readTLString(stream) : null;
        contentUrl = (flags & 32) != 0 ? readTLString(stream) : null;
        contentType = (flags & 32) != 0 ? readTLString(stream) : null;
        w = (flags & 64) != 0 ? readInt(stream) : null;
        h = (flags & 64) != 0 ? readInt(stream) : null;
        duration = (flags & 128) != 0 ? readInt(stream) : null;
        sendMessage = readTLObject(stream, context, TLAbsBotInlineMessage.class, -1);
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(id);
        size += computeTLStringSerializedSize(type);
        if ((flags & 2) != 0) {
            if (title == null) throwNullFieldException("title", flags);
            size += computeTLStringSerializedSize(title);
        }
        if ((flags & 4) != 0) {
            if (description == null) throwNullFieldException("description", flags);
            size += computeTLStringSerializedSize(description);
        }
        if ((flags & 8) != 0) {
            if (url == null) throwNullFieldException("url", flags);
            size += computeTLStringSerializedSize(url);
        }
        if ((flags & 16) != 0) {
            if (thumbUrl == null) throwNullFieldException("thumbUrl", flags);
            size += computeTLStringSerializedSize(thumbUrl);
        }
        if ((flags & 32) != 0) {
            if (contentUrl == null) throwNullFieldException("contentUrl", flags);
            size += computeTLStringSerializedSize(contentUrl);
        }
        if ((flags & 32) != 0) {
            if (contentType == null) throwNullFieldException("contentType", flags);
            size += computeTLStringSerializedSize(contentType);
        }
        if ((flags & 64) != 0) {
            if (w == null) throwNullFieldException("w", flags);
            size += SIZE_INT32;
        }
        if ((flags & 64) != 0) {
            if (h == null) throwNullFieldException("h", flags);
            size += SIZE_INT32;
        }
        if ((flags & 128) != 0) {
            if (duration == null) throwNullFieldException("duration", flags);
            size += SIZE_INT32;
        }
        size += sendMessage.computeSerializedSize();
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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Integer getW() {
        return w;
    }

    public void setW(Integer w) {
        this.w = w;
    }

    public Integer getH() {
        return h;
    }

    public void setH(Integer h) {
        this.h = h;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public TLAbsBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }
}
