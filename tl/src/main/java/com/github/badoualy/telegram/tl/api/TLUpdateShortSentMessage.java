
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLUpdateShortSentMessage extends TLAbsUpdates {
    public static final int CLASS_ID = 0x11f1331c;

    public TLUpdateShortSentMessage() {

    }


    public TLUpdateShortSentMessage(        int _flags,         boolean _unread,         boolean _out,         int _id,         int _pts,         int _ptsCount,         int _date,         com.github.badoualy.telegram.tl.api.TLAbsMessageMedia _media,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> _entities) {
        this.flags = _flags;
        this.unread = _unread;
        this.out = _out;
        this.id = _id;
        this.pts = _pts;
        this.ptsCount = _ptsCount;
        this.date = _date;
        this.media = _media;
        this.entities = _entities;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected boolean unread;

    protected boolean out;

    protected int id;

    protected int pts;

    protected int ptsCount;

    protected int date;

    protected com.github.badoualy.telegram.tl.api.TLAbsMessageMedia media;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> entities;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getUnread() {
        return unread;
    }

    public void setUnread(boolean value) {
        this.unread = value;
    }

    public boolean getOut() {
        return out;
    }

    public void setOut(boolean value) {
        this.out = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }

    public int getPtsCount() {
        return ptsCount;
    }

    public void setPtsCount(int value) {
        this.ptsCount = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsMessageMedia getMedia() {
        return media;
    }

    public void setMedia(com.github.badoualy.telegram.tl.api.TLAbsMessageMedia value) {
        this.media = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> getEntities() {
        return entities;
    }

    public void setEntities(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> value) {
        this.entities = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = unread ? (flags | 1) : (flags &~ 1);
        flags = out ? (flags | 2) : (flags &~ 2);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.unread, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.out, stream);
        writeInt(this.id, stream);
        writeInt(this.pts, stream);
        writeInt(this.ptsCount, stream);
        writeInt(this.date, stream);
        if ((this.flags & 512) != 0)
            writeTLObject(this.media, stream);
        if ((this.flags & 128) != 0)
            writeTLVector(this.entities, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.unread = (this.flags & 1) != 0;
        this.out = (this.flags & 2) != 0;
        this.id = readInt(stream);
        this.pts = readInt(stream);
        this.ptsCount = readInt(stream);
        this.date = readInt(stream);
        if ((this.flags & 512) != 0)
            this.media = (com.github.badoualy.telegram.tl.api.TLAbsMessageMedia)readTLObject(stream, context);
        if ((this.flags & 128) != 0)
            this.entities = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "updateShortSentMessage#11f1331c";
    }

}
