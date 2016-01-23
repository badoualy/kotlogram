package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLInputBotInlineResult extends TLObject {
    public static final int CLASS_ID = 0x2cbbe15a;

    protected int flags;

    protected String id;

    protected String type;

    protected String title;

    protected String description;

    protected String url;

    protected String thumbUrl;

    protected String contentUrl;

    protected String contentType;

    protected int w;

    protected int h;

    protected int duration;

    protected TLAbsInputBotInlineMessage sendMessage;

    public TLInputBotInlineResult() {
    }

    public TLInputBotInlineResult(int flags, String id, String type, String title, String description, String url, String thumbUrl, String contentUrl, String contentType, int w, int h, int duration, TLAbsInputBotInlineMessage sendMessage) {
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

        writeInt(flags, stream);
        writeTLString(id, stream);
        writeTLString(type, stream);
        if ((flags & 2) != 0) writeTLString(title, stream);
        if ((flags & 4) != 0) writeTLString(description, stream);
        if ((flags & 8) != 0) writeTLString(url, stream);
        if ((flags & 16) != 0) writeTLString(thumbUrl, stream);
        if ((flags & 32) != 0) writeTLString(contentUrl, stream);
        if ((flags & 32) != 0) writeTLString(contentType, stream);
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
        sendMessage = (com.github.badoualy.telegram.tl.api.TLAbsInputBotInlineMessage) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "inputBotInlineResult#2cbbe15a";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
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

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public TLAbsInputBotInlineMessage getSendMessage() {
        return sendMessage;
    }

    public void setSendMessage(TLAbsInputBotInlineMessage sendMessage) {
        this.sendMessage = sendMessage;
    }
}
