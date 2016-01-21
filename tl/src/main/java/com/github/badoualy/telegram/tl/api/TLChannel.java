
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
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLChannel extends TLAbsChat {
    public static final int CLASS_ID = 0x4b1b7506;

    public TLChannel() {

    }


    public TLChannel(        int _flags,         boolean _creator,         boolean _kicked,         boolean _left,         boolean _editor,         boolean _moderator,         boolean _broadcast,         boolean _verified,         boolean _megagroup,         boolean _restricted,         int _id,         long _accessHash,         String _title,         String _username,         com.github.badoualy.telegram.tl.api.TLAbsChatPhoto _photo,         int _date,         int _version,         String _restrictionReason) {
        this.flags = _flags;
        this.creator = _creator;
        this.kicked = _kicked;
        this.left = _left;
        this.editor = _editor;
        this.moderator = _moderator;
        this.broadcast = _broadcast;
        this.verified = _verified;
        this.megagroup = _megagroup;
        this.restricted = _restricted;
        this.id = _id;
        this.accessHash = _accessHash;
        this.title = _title;
        this.username = _username;
        this.photo = _photo;
        this.date = _date;
        this.version = _version;
        this.restrictionReason = _restrictionReason;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected boolean creator;

    protected boolean kicked;

    protected boolean left;

    protected boolean editor;

    protected boolean moderator;

    protected boolean broadcast;

    protected boolean verified;

    protected boolean megagroup;

    protected boolean restricted;

    protected long accessHash;

    protected String title;

    protected String username;

    protected com.github.badoualy.telegram.tl.api.TLAbsChatPhoto photo;

    protected int date;

    protected int version;

    protected String restrictionReason;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getCreator() {
        return creator;
    }

    public void setCreator(boolean value) {
        this.creator = value;
    }

    public boolean getKicked() {
        return kicked;
    }

    public void setKicked(boolean value) {
        this.kicked = value;
    }

    public boolean getLeft() {
        return left;
    }

    public void setLeft(boolean value) {
        this.left = value;
    }

    public boolean getEditor() {
        return editor;
    }

    public void setEditor(boolean value) {
        this.editor = value;
    }

    public boolean getModerator() {
        return moderator;
    }

    public void setModerator(boolean value) {
        this.moderator = value;
    }

    public boolean getBroadcast() {
        return broadcast;
    }

    public void setBroadcast(boolean value) {
        this.broadcast = value;
    }

    public boolean getVerified() {
        return verified;
    }

    public void setVerified(boolean value) {
        this.verified = value;
    }

    public boolean getMegagroup() {
        return megagroup;
    }

    public void setMegagroup(boolean value) {
        this.megagroup = value;
    }

    public boolean getRestricted() {
        return restricted;
    }

    public void setRestricted(boolean value) {
        this.restricted = value;
    }

    public long getAccessHash() {
        return accessHash;
    }

    public void setAccessHash(long value) {
        this.accessHash = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String value) {
        this.username = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(com.github.badoualy.telegram.tl.api.TLAbsChatPhoto value) {
        this.photo = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }

    public String getRestrictionReason() {
        return restrictionReason;
    }

    public void setRestrictionReason(String value) {
        this.restrictionReason = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = creator ? (flags | 1) : (flags &~ 1);
        flags = kicked ? (flags | 2) : (flags &~ 2);
        flags = left ? (flags | 4) : (flags &~ 4);
        flags = editor ? (flags | 8) : (flags &~ 8);
        flags = moderator ? (flags | 16) : (flags &~ 16);
        flags = broadcast ? (flags | 32) : (flags &~ 32);
        flags = verified ? (flags | 128) : (flags &~ 128);
        flags = megagroup ? (flags | 256) : (flags &~ 256);
        flags = restricted ? (flags | 512) : (flags &~ 512);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.creator, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.kicked, stream);
        if ((this.flags & 4) != 0)
            writeTLBool(this.left, stream);
        if ((this.flags & 8) != 0)
            writeTLBool(this.editor, stream);
        if ((this.flags & 16) != 0)
            writeTLBool(this.moderator, stream);
        if ((this.flags & 32) != 0)
            writeTLBool(this.broadcast, stream);
        if ((this.flags & 128) != 0)
            writeTLBool(this.verified, stream);
        if ((this.flags & 256) != 0)
            writeTLBool(this.megagroup, stream);
        if ((this.flags & 512) != 0)
            writeTLBool(this.restricted, stream);
        writeInt(this.id, stream);
        writeLong(this.accessHash, stream);
        writeTLString(this.title, stream);
        if ((this.flags & 64) != 0)
            writeTLString(this.username, stream);
        writeTLObject(this.photo, stream);
        writeInt(this.date, stream);
        writeInt(this.version, stream);
        if ((this.flags & 512) != 0)
            writeTLString(this.restrictionReason, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.creator = (this.flags & 1) != 0;
        this.kicked = (this.flags & 2) != 0;
        this.left = (this.flags & 4) != 0;
        this.editor = (this.flags & 8) != 0;
        this.moderator = (this.flags & 16) != 0;
        this.broadcast = (this.flags & 32) != 0;
        this.verified = (this.flags & 128) != 0;
        this.megagroup = (this.flags & 256) != 0;
        this.restricted = (this.flags & 512) != 0;
        this.id = readInt(stream);
        this.accessHash = readLong(stream);
        this.title = readTLString(stream);
        if ((this.flags & 64) != 0)
            this.username = readTLString(stream);
        this.photo = (com.github.badoualy.telegram.tl.api.TLAbsChatPhoto)readTLObject(stream, context);
        this.date = readInt(stream);
        this.version = readInt(stream);
        if ((this.flags & 512) != 0)
            this.restrictionReason = readTLString(stream);
    }



    @Override
    public String toString() {
        return "channel#4b1b7506";
    }

}
