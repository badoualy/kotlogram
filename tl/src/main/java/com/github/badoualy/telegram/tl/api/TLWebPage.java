
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
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLWebPage extends TLAbsWebPage {
    public static final int CLASS_ID = 0xca820ed7;

    public TLWebPage() {

    }


    public TLWebPage(        int _flags,         long _id,         String _url,         String _displayUrl,         String _type,         String _siteName,         String _title,         String _description,         com.github.badoualy.telegram.tl.api.TLAbsPhoto _photo,         String _embedUrl,         String _embedType,         int _embedWidth,         int _embedHeight,         int _duration,         String _author,         com.github.badoualy.telegram.tl.api.TLAbsDocument _document) {
        this.flags = _flags;
        this.id = _id;
        this.url = _url;
        this.displayUrl = _displayUrl;
        this.type = _type;
        this.siteName = _siteName;
        this.title = _title;
        this.description = _description;
        this.photo = _photo;
        this.embedUrl = _embedUrl;
        this.embedType = _embedType;
        this.embedWidth = _embedWidth;
        this.embedHeight = _embedHeight;
        this.duration = _duration;
        this.author = _author;
        this.document = _document;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected String url;

    protected String displayUrl;

    protected String type;

    protected String siteName;

    protected String title;

    protected String description;

    protected com.github.badoualy.telegram.tl.api.TLAbsPhoto photo;

    protected String embedUrl;

    protected String embedType;

    protected int embedWidth;

    protected int embedHeight;

    protected int duration;

    protected String author;

    protected com.github.badoualy.telegram.tl.api.TLAbsDocument document;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public String getDisplayUrl() {
        return displayUrl;
    }

    public void setDisplayUrl(String value) {
        this.displayUrl = value;
    }

    public String getType() {
        return type;
    }

    public void setType(String value) {
        this.type = value;
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String value) {
        this.siteName = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String value) {
        this.description = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(com.github.badoualy.telegram.tl.api.TLAbsPhoto value) {
        this.photo = value;
    }

    public String getEmbedUrl() {
        return embedUrl;
    }

    public void setEmbedUrl(String value) {
        this.embedUrl = value;
    }

    public String getEmbedType() {
        return embedType;
    }

    public void setEmbedType(String value) {
        this.embedType = value;
    }

    public int getEmbedWidth() {
        return embedWidth;
    }

    public void setEmbedWidth(int value) {
        this.embedWidth = value;
    }

    public int getEmbedHeight() {
        return embedHeight;
    }

    public void setEmbedHeight(int value) {
        this.embedHeight = value;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int value) {
        this.duration = value;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String value) {
        this.author = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsDocument getDocument() {
        return document;
    }

    public void setDocument(com.github.badoualy.telegram.tl.api.TLAbsDocument value) {
        this.document = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.flags, stream);
        writeLong(this.id, stream);
        writeTLString(this.url, stream);
        writeTLString(this.displayUrl, stream);
        if ((this.flags & 1) != 0)
            writeTLString(this.type, stream);
        if ((this.flags & 2) != 0)
            writeTLString(this.siteName, stream);
        if ((this.flags & 4) != 0)
            writeTLString(this.title, stream);
        if ((this.flags & 8) != 0)
            writeTLString(this.description, stream);
        if ((this.flags & 16) != 0)
            writeTLObject(this.photo, stream);
        if ((this.flags & 32) != 0)
            writeTLString(this.embedUrl, stream);
        if ((this.flags & 32) != 0)
            writeTLString(this.embedType, stream);
        if ((this.flags & 64) != 0)
            writeInt(this.embedWidth, stream);
        if ((this.flags & 64) != 0)
            writeInt(this.embedHeight, stream);
        if ((this.flags & 128) != 0)
            writeInt(this.duration, stream);
        if ((this.flags & 256) != 0)
            writeTLString(this.author, stream);
        if ((this.flags & 512) != 0)
            writeTLObject(this.document, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.id = readLong(stream);
        this.url = readTLString(stream);
        this.displayUrl = readTLString(stream);
        if ((this.flags & 1) != 0)
            this.type = readTLString(stream);
        if ((this.flags & 2) != 0)
            this.siteName = readTLString(stream);
        if ((this.flags & 4) != 0)
            this.title = readTLString(stream);
        if ((this.flags & 8) != 0)
            this.description = readTLString(stream);
        if ((this.flags & 16) != 0)
            this.photo = (com.github.badoualy.telegram.tl.api.TLAbsPhoto)readTLObject(stream, context);
        if ((this.flags & 32) != 0)
            this.embedUrl = readTLString(stream);
        if ((this.flags & 32) != 0)
            this.embedType = readTLString(stream);
        if ((this.flags & 64) != 0)
            this.embedWidth = readInt(stream);
        if ((this.flags & 64) != 0)
            this.embedHeight = readInt(stream);
        if ((this.flags & 128) != 0)
            this.duration = readInt(stream);
        if ((this.flags & 256) != 0)
            this.author = readTLString(stream);
        if ((this.flags & 512) != 0)
            this.document = (com.github.badoualy.telegram.tl.api.TLAbsDocument)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "webPage#ca820ed7";
    }

}
