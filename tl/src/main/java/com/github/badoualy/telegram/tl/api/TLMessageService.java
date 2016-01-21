
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLMessageService extends TLAbsMessage {
    public static final int CLASS_ID = 0xc06b9607;

    public TLMessageService() {

    }


    public TLMessageService(        int _flags,         boolean _unread,         boolean _out,         boolean _mentioned,         boolean _mediaUnread,         int _id,         int _fromId,         com.github.badoualy.telegram.tl.api.TLAbsPeer _toId,         int _date,         com.github.badoualy.telegram.tl.api.TLAbsMessageAction _action) {
        this.flags = _flags;
        this.unread = _unread;
        this.out = _out;
        this.mentioned = _mentioned;
        this.mediaUnread = _mediaUnread;
        this.id = _id;
        this.fromId = _fromId;
        this.toId = _toId;
        this.date = _date;
        this.action = _action;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected boolean unread;

    protected boolean out;

    protected boolean mentioned;

    protected boolean mediaUnread;

    protected int fromId;

    protected com.github.badoualy.telegram.tl.api.TLAbsPeer toId;

    protected int date;

    protected com.github.badoualy.telegram.tl.api.TLAbsMessageAction action;


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

    public int getFromId() {
        return fromId;
    }

    public void setFromId(int value) {
        this.fromId = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsPeer getToId() {
        return toId;
    }

    public void setToId(com.github.badoualy.telegram.tl.api.TLAbsPeer value) {
        this.toId = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsMessageAction getAction() {
        return action;
    }

    public void setAction(com.github.badoualy.telegram.tl.api.TLAbsMessageAction value) {
        this.action = value;
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
        if ((this.flags & 256) != 0)
            writeInt(this.fromId, stream);
        writeTLObject(this.toId, stream);
        writeInt(this.date, stream);
        writeTLObject(this.action, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.unread = (this.flags & 1) != 0;
        this.out = (this.flags & 2) != 0;
        this.mentioned = (this.flags & 16) != 0;
        this.mediaUnread = (this.flags & 32) != 0;
        this.id = readInt(stream);
        if ((this.flags & 256) != 0)
            this.fromId = readInt(stream);
        this.toId = (com.github.badoualy.telegram.tl.api.TLAbsPeer)readTLObject(stream, context);
        this.date = readInt(stream);
        this.action = (com.github.badoualy.telegram.tl.api.TLAbsMessageAction)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messageService#c06b9607";
    }

}
