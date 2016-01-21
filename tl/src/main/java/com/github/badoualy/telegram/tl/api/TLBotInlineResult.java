
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLBotInlineResult extends TLAbsBotInlineResult {
    public static final int CLASS_ID = 0x9bebaeb9;

    public TLBotInlineResult() {

    }


    public TLBotInlineResult(        int _flags,         String _id,         String _type,         String _title,         String _description,         String _url,         String _thumbUrl,         String _contentUrl,         String _contentType,         int _w,         int _h,         int _duration,         com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage _sendMessage) {
        this.flags = _flags;
        this.id = _id;
        this.type = _type;
        this.title = _title;
        this.description = _description;
        this.url = _url;
        this.thumbUrl = _thumbUrl;
        this.contentUrl = _contentUrl;
        this.contentType = _contentType;
        this.w = _w;
        this.h = _h;
        this.duration = _duration;
        this.sendMessage = _sendMessage;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected String title;

    protected String description;

    protected String url;

    protected String thumbUrl;

    protected String contentUrl;

    protected String contentType;

    protected int w;

    protected int h;

    protected int duration;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String value) {
        this.url = value;
    }

    public String getThumbUrl() {
        return thumbUrl;
    }

    public void setThumbUrl(String value) {
        this.thumbUrl = value;
    }

    public String getContentUrl() {
        return contentUrl;
    }

    public void setContentUrl(String value) {
        this.contentUrl = value;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String value) {
        this.contentType = value;
    }

    public int getW() {
        return w;
    }

    public void setW(int value) {
        this.w = value;
    }

    public int getH() {
        return h;
    }

    public void setH(int value) {
        this.h = value;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int value) {
        this.duration = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.flags, stream);
        writeTLString(this.id, stream);
        writeTLString(this.type, stream);
        if ((this.flags & 2) != 0)
            writeTLString(this.title, stream);
        if ((this.flags & 4) != 0)
            writeTLString(this.description, stream);
        if ((this.flags & 8) != 0)
            writeTLString(this.url, stream);
        if ((this.flags & 16) != 0)
            writeTLString(this.thumbUrl, stream);
        if ((this.flags & 32) != 0)
            writeTLString(this.contentUrl, stream);
        if ((this.flags & 32) != 0)
            writeTLString(this.contentType, stream);
        if ((this.flags & 64) != 0)
            writeInt(this.w, stream);
        if ((this.flags & 64) != 0)
            writeInt(this.h, stream);
        if ((this.flags & 128) != 0)
            writeInt(this.duration, stream);
        writeTLObject(this.sendMessage, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.id = readTLString(stream);
        this.type = readTLString(stream);
        if ((this.flags & 2) != 0)
            this.title = readTLString(stream);
        if ((this.flags & 4) != 0)
            this.description = readTLString(stream);
        if ((this.flags & 8) != 0)
            this.url = readTLString(stream);
        if ((this.flags & 16) != 0)
            this.thumbUrl = readTLString(stream);
        if ((this.flags & 32) != 0)
            this.contentUrl = readTLString(stream);
        if ((this.flags & 32) != 0)
            this.contentType = readTLString(stream);
        if ((this.flags & 64) != 0)
            this.w = readInt(stream);
        if ((this.flags & 64) != 0)
            this.h = readInt(stream);
        if ((this.flags & 128) != 0)
            this.duration = readInt(stream);
        this.sendMessage = (com.github.badoualy.telegram.tl.api.TLAbsBotInlineMessage)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "botInlineResult#9bebaeb9";
    }

}
