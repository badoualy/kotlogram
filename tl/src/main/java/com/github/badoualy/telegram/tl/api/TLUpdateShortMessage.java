
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;



public class TLUpdateShortMessage extends TLAbsUpdates {
    public static final int CLASS_ID = 0x13e4deaa;

    public TLUpdateShortMessage() {

    }


    public TLUpdateShortMessage(        int _flags,         boolean _unread,         boolean _out,         boolean _mentioned,         boolean _mediaUnread,         int _id,         int _userId,         String _message,         int _pts,         int _ptsCount,         int _date,         com.github.badoualy.telegram.tl.api.TLAbsPeer _fwdFromId,         int _fwdDate,         int _viaBotId,         int _replyToMsgId,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessageEntity> _entities) {
        this.flags = _flags;
        this.unread = _unread;
        this.out = _out;
        this.mentioned = _mentioned;
        this.mediaUnread = _mediaUnread;
        this.id = _id;
        this.userId = _userId;
        this.message = _message;
        this.pts = _pts;
        this.ptsCount = _ptsCount;
        this.date = _date;
        this.fwdFromId = _fwdFromId;
        this.fwdDate = _fwdDate;
        this.viaBotId = _viaBotId;
        this.replyToMsgId = _replyToMsgId;
        this.entities = _entities;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected boolean unread;

    protected boolean out;

    protected boolean mentioned;

    protected boolean mediaUnread;

    protected int id;

    protected int userId;

    protected String message;

    protected int pts;

    protected int ptsCount;

    protected int date;

    protected com.github.badoualy.telegram.tl.api.TLAbsPeer fwdFromId;

    protected int fwdDate;

    protected int viaBotId;

    protected int replyToMsgId;

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

    public boolean getMentioned() {
        return mentioned;
    }

    public void setMentioned(boolean value) {
        this.mentioned = value;
    }

    public boolean getMediaUnread() {
        return mediaUnread;
    }

    public void setMediaUnread(boolean value) {
        this.mediaUnread = value;
    }

    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String value) {
        this.message = value;
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

    public com.github.badoualy.telegram.tl.api.TLAbsPeer getFwdFromId() {
        return fwdFromId;
    }

    public void setFwdFromId(com.github.badoualy.telegram.tl.api.TLAbsPeer value) {
        this.fwdFromId = value;
    }

    public int getFwdDate() {
        return fwdDate;
    }

    public void setFwdDate(int value) {
        this.fwdDate = value;
    }

    public int getViaBotId() {
        return viaBotId;
    }

    public void setViaBotId(int value) {
        this.viaBotId = value;
    }

    public int getReplyToMsgId() {
        return replyToMsgId;
    }

    public void setReplyToMsgId(int value) {
        this.replyToMsgId = value;
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
        flags = mentioned ? (flags | 16) : (flags &~ 16);
        flags = mediaUnread ? (flags | 32) : (flags &~ 32);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.unread, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.out, stream);
        if ((this.flags & 16) != 0)
            writeTLBool(this.mentioned, stream);
        if ((this.flags & 32) != 0)
            writeTLBool(this.mediaUnread, stream);
        writeInt(this.id, stream);
        writeInt(this.userId, stream);
        writeTLString(this.message, stream);
        writeInt(this.pts, stream);
        writeInt(this.ptsCount, stream);
        writeInt(this.date, stream);
        if ((this.flags & 4) != 0)
            writeTLObject(this.fwdFromId, stream);
        if ((this.flags & 4) != 0)
            writeInt(this.fwdDate, stream);
        if ((this.flags & 2048) != 0)
            writeInt(this.viaBotId, stream);
        if ((this.flags & 8) != 0)
            writeInt(this.replyToMsgId, stream);
        if ((this.flags & 128) != 0)
            writeTLVector(this.entities, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.unread = (this.flags & 1) != 0;
        this.out = (this.flags & 2) != 0;
        this.mentioned = (this.flags & 16) != 0;
        this.mediaUnread = (this.flags & 32) != 0;
        this.id = readInt(stream);
        this.userId = readInt(stream);
        this.message = readTLString(stream);
        this.pts = readInt(stream);
        this.ptsCount = readInt(stream);
        this.date = readInt(stream);
        if ((this.flags & 4) != 0)
            this.fwdFromId = (com.github.badoualy.telegram.tl.api.TLAbsPeer)readTLObject(stream, context);
        if ((this.flags & 4) != 0)
            this.fwdDate = readInt(stream);
        if ((this.flags & 2048) != 0)
            this.viaBotId = readInt(stream);
        if ((this.flags & 8) != 0)
            this.replyToMsgId = readInt(stream);
        if ((this.flags & 128) != 0)
            this.entities = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "updateShortMessage#13e4deaa";
    }

}
