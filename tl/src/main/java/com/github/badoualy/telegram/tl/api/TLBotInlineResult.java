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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBotInlineResult extends TLAbsBotInlineResult {
    public static final int CONSTRUCTOR_ID = 0x9bebaeb9;

    protected int flags;

    protected String title;

    protected String description;

    protected String url;

    protected String thumbUrl;

    protected String contentUrl;

    protected String contentType;

    protected Integer w;

    protected Integer h;

    protected Integer duration;

    public TLBotInlineResult() {
    }

    public TLBotInlineResult(int flags, String id, String type, String title, String description, String url, String thumbUrl, String contentUrl, String contentType, Integer w, Integer h, Integer duration, TLAbsBotInlineMessage sendMessage) {
        this.flags = flags;
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

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = title != null ? (flags | 2) : (flags &~ 2);
        flags = description != null ? (flags | 4) : (flags &~ 4);
        flags = url != null ? (flags | 8) : (flags &~ 8);
        flags = thumbUrl != null ? (flags | 16) : (flags &~ 16);
        flags = contentUrl != null ? (flags | 32) : (flags &~ 32);
        flags = contentType != null ? (flags | 32) : (flags &~ 32);
        flags = w != null ? (flags | 64) : (flags &~ 64);
        flags = h != null ? (flags | 64) : (flags &~ 64);
        flags = duration != null ? (flags | 128) : (flags &~ 128);

        writeInt(flags, stream);
        writeString(id, stream);
        writeString(type, stream);
        if ((flags & 2) != 0) writeString(title, stream);
        if ((flags & 4) != 0) writeString(description, stream);
        if ((flags & 8) != 0) writeString(url, stream);
        if ((flags & 16) != 0) writeString(thumbUrl, stream);
        if ((flags & 32) != 0) writeString(contentUrl, stream);
        if ((flags & 32) != 0) writeString(contentType, stream);
        if ((flags & 64) != 0) writeInt(w, stream);
        if ((flags & 64) != 0) writeInt(h, stream);
        if ((flags & 128) != 0) writeInt(duration, stream);
        writeTLObject(sendMessage, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        id = readTLString(stream);
        type = readTLString(stream);
        if ((flags & 2) != 0) title = readTLString(stream);
        if ((flags & 4) != 0) description = readTLString(stream);
        if ((flags & 8) != 0) url = readTLString(stream);
        if ((flags & 16) != 0) thumbUrl = readTLString(stream);
        if ((flags & 32) != 0) contentUrl = readTLString(stream);
        if ((flags & 32) != 0) contentType = readTLString(stream);
        if ((flags & 64) != 0) w = readInt(stream);
        if ((flags & 64) != 0) h = readInt(stream);
        if ((flags & 128) != 0) duration = readInt(stream);
        sendMessage = (com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "botInlineResult#9bebaeb9";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getFlags() {
        return flags;
    }

    public void setFlags(int flags) {
        this.flags = flags;
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
