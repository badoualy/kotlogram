
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLString;



public class TLChat extends TLAbsChat {
    public static final int CLASS_ID = 0xd91cdd54;

    public TLChat() {

    }


    public TLChat(        int _flags,         boolean _creator,         boolean _kicked,         boolean _left,         boolean _adminsEnabled,         boolean _admin,         boolean _deactivated,         int _id,         String _title,         com.github.badoualy.telegram.tl.api.TLAbsChatPhoto _photo,         int _participantsCount,         int _date,         int _version,         com.github.badoualy.telegram.tl.api.TLAbsInputChannel _migratedTo) {
        this.flags = _flags;
        this.creator = _creator;
        this.kicked = _kicked;
        this.left = _left;
        this.adminsEnabled = _adminsEnabled;
        this.admin = _admin;
        this.deactivated = _deactivated;
        this.id = _id;
        this.title = _title;
        this.photo = _photo;
        this.participantsCount = _participantsCount;
        this.date = _date;
        this.version = _version;
        this.migratedTo = _migratedTo;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected boolean creator;

    protected boolean kicked;

    protected boolean left;

    protected boolean adminsEnabled;

    protected boolean admin;

    protected boolean deactivated;

    protected String title;

    protected com.github.badoualy.telegram.tl.api.TLAbsChatPhoto photo;

    protected int participantsCount;

    protected int date;

    protected int version;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputChannel migratedTo;


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

    public boolean getAdminsEnabled() {
        return adminsEnabled;
    }

    public void setAdminsEnabled(boolean value) {
        this.adminsEnabled = value;
    }

    public boolean getAdmin() {
        return admin;
    }

    public void setAdmin(boolean value) {
        this.admin = value;
    }

    public boolean getDeactivated() {
        return deactivated;
    }

    public void setDeactivated(boolean value) {
        this.deactivated = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String value) {
        this.title = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(com.github.badoualy.telegram.tl.api.TLAbsChatPhoto value) {
        this.photo = value;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int value) {
        this.participantsCount = value;
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

    public com.github.badoualy.telegram.tl.api.TLAbsInputChannel getMigratedTo() {
        return migratedTo;
    }

    public void setMigratedTo(com.github.badoualy.telegram.tl.api.TLAbsInputChannel value) {
        this.migratedTo = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = creator ? (flags | 1) : (flags &~ 1);
        flags = kicked ? (flags | 2) : (flags &~ 2);
        flags = left ? (flags | 4) : (flags &~ 4);
        flags = adminsEnabled ? (flags | 8) : (flags &~ 8);
        flags = admin ? (flags | 16) : (flags &~ 16);
        flags = deactivated ? (flags | 32) : (flags &~ 32);
        writeInt(this.flags, stream);
        if ((this.flags & 1) != 0)
            writeTLBool(this.creator, stream);
        if ((this.flags & 2) != 0)
            writeTLBool(this.kicked, stream);
        if ((this.flags & 4) != 0)
            writeTLBool(this.left, stream);
        if ((this.flags & 8) != 0)
            writeTLBool(this.adminsEnabled, stream);
        if ((this.flags & 16) != 0)
            writeTLBool(this.admin, stream);
        if ((this.flags & 32) != 0)
            writeTLBool(this.deactivated, stream);
        writeInt(this.id, stream);
        writeTLString(this.title, stream);
        writeTLObject(this.photo, stream);
        writeInt(this.participantsCount, stream);
        writeInt(this.date, stream);
        writeInt(this.version, stream);
        if ((this.flags & 64) != 0)
            writeTLObject(this.migratedTo, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.creator = (this.flags & 1) != 0;
        this.kicked = (this.flags & 2) != 0;
        this.left = (this.flags & 4) != 0;
        this.adminsEnabled = (this.flags & 8) != 0;
        this.admin = (this.flags & 16) != 0;
        this.deactivated = (this.flags & 32) != 0;
        this.id = readInt(stream);
        this.title = readTLString(stream);
        this.photo = (com.github.badoualy.telegram.tl.api.TLAbsChatPhoto)readTLObject(stream, context);
        this.participantsCount = readInt(stream);
        this.date = readInt(stream);
        this.version = readInt(stream);
        if ((this.flags & 64) != 0)
            this.migratedTo = (com.github.badoualy.telegram.tl.api.TLAbsInputChannel)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "chat#d91cdd54";
    }

}
