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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLWebPage extends TLAbsWebPage {
    public static final int CONSTRUCTOR_ID = 0xca820ed7;

    protected int flags;

    protected String url;

    protected String displayUrl;

    protected String type;

    protected String siteName;

    protected String title;

    protected String description;

    protected TLAbsPhoto photo;

    protected String embedUrl;

    protected String embedType;

    protected int embedWidth;

    protected int embedHeight;

    protected int duration;

    protected String author;

    protected TLAbsDocument document;

    public TLWebPage() {
    }

    public TLWebPage(int flags, long id, String url, String displayUrl, String type, String siteName, String title, String description, TLAbsPhoto photo, String embedUrl, String embedType, int embedWidth, int embedHeight, int duration, String author, TLAbsDocument document) {
        this.flags = flags;
        this.id = id;
        this.url = url;
        this.displayUrl = displayUrl;
        this.type = type;
        this.siteName = siteName;
        this.title = title;
        this.description = description;
        this.photo = photo;
        this.embedUrl = embedUrl;
        this.embedType = embedType;
        this.embedWidth = embedWidth;
        this.embedHeight = embedHeight;
        this.duration = duration;
        this.author = author;
        this.document = document;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;

        writeInt(flags, stream);
        writeLong(id, stream);
        writeString(url, stream);
        writeString(displayUrl, stream);
        if ((flags & 1) != 0) writeString(type, stream);
        if ((flags & 2) != 0) writeString(siteName, stream);
        if ((flags & 4) != 0) writeString(title, stream);
        if ((flags & 8) != 0) writeString(description, stream);
        if ((flags & 16) != 0) writeTLObject(photo, stream);
        if ((flags & 32) != 0) writeString(embedUrl, stream);
        if ((flags & 32) != 0) writeString(embedType, stream);
        if ((flags & 64) != 0) writeInt(embedWidth, stream);
        if ((flags & 64) != 0) writeInt(embedHeight, stream);
        if ((flags & 128) != 0) writeInt(duration, stream);
        if ((flags & 256) != 0) writeString(author, stream);
        if ((flags & 512) != 0) writeTLObject(document, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        id = readLong(stream);
        url = readTLString(stream);
        displayUrl = readTLString(stream);
        if ((flags & 1) != 0) type = readTLString(stream);
        if ((flags & 2) != 0) siteName = readTLString(stream);
        if ((flags & 4) != 0) title = readTLString(stream);
        if ((flags & 8) != 0) description = readTLString(stream);
        if ((flags & 16) != 0) photo = (com.github.badoualy.telegram.tl.api.TLAbsPhoto) readTLObject(stream, context);
        if ((flags & 32) != 0) embedUrl = readTLString(stream);
        if ((flags & 32) != 0) embedType = readTLString(stream);
        if ((flags & 64) != 0) embedWidth = readInt(stream);
        if ((flags & 64) != 0) embedHeight = readInt(stream);
        if ((flags & 128) != 0) duration = readInt(stream);
        if ((flags & 256) != 0) author = readTLString(stream);
        if ((flags & 512) != 0) document = (com.github.badoualy.telegram.tl.api.TLAbsDocument) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "webPage#ca820ed7";
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String displayUrl) {
        this.displayUrl = displayUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName;
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

    public TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(TLAbsPhoto photo) {
        this.photo = photo;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String embedUrl) {
        this.embedUrl = embedUrl;
    }

    public String getEmbedType() {
        return embedType;
    }

    public void setEmbedType(String embedType) {
        this.embedType = embedType;
    }

    public int getEmbedWidth() {
        return embedWidth;
    }

    public void setEmbedWidth(int embedWidth) {
        this.embedWidth = embedWidth;
    }

    public int getEmbedHeight() {
        return embedHeight;
    }

    public void setEmbedHeight(int embedHeight) {
        this.embedHeight = embedHeight;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(TLAbsDocument document) {
        this.document = document;
    }
}
