
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



public class TLChannelFull extends TLAbsChatFull {
    public static final int CLASS_ID = 0x9e341ddf;

    public TLChannelFull() {

    }


    public TLChannelFull(        int _flags,         boolean _canViewParticipants,         int _id,         String _about,         int _participantsCount,         int _adminsCount,         int _kickedCount,         int _readInboxMaxId,         int _unreadCount,         int _unreadImportantCount,         com.github.badoualy.telegram.tl.api.TLAbsPhoto _chatPhoto,         com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings _notifySettings,         com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite _exportedInvite,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsBotInfo> _botInfo,         int _migratedFromChatId,         int _migratedFromMaxId) {
        this.flags = _flags;
        this.canViewParticipants = _canViewParticipants;
        this.id = _id;
        this.about = _about;
        this.participantsCount = _participantsCount;
        this.adminsCount = _adminsCount;
        this.kickedCount = _kickedCount;
        this.readInboxMaxId = _readInboxMaxId;
        this.unreadCount = _unreadCount;
        this.unreadImportantCount = _unreadImportantCount;
        this.chatPhoto = _chatPhoto;
        this.notifySettings = _notifySettings;
        this.exportedInvite = _exportedInvite;
        this.botInfo = _botInfo;
        this.migratedFromChatId = _migratedFromChatId;
        this.migratedFromMaxId = _migratedFromMaxId;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int flags;

    protected boolean canViewParticipants;

    protected String about;

    protected int participantsCount;

    protected int adminsCount;

    protected int kickedCount;

    protected int readInboxMaxId;

    protected int unreadCount;

    protected int unreadImportantCount;

    protected int migratedFromChatId;

    protected int migratedFromMaxId;


    public int getFlags() {
        return flags;
    }

    public void setFlags(int value) {
        this.flags = value;
    }

    public boolean getCanViewParticipants() {
        return canViewParticipants;
    }

    public void setCanViewParticipants(boolean value) {
        this.canViewParticipants = value;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String value) {
        this.about = value;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int value) {
        this.participantsCount = value;
    }

    public int getAdminsCount() {
        return adminsCount;
    }

    public void setAdminsCount(int value) {
        this.adminsCount = value;
    }

    public int getKickedCount() {
        return kickedCount;
    }

    public void setKickedCount(int value) {
        this.kickedCount = value;
    }

    public int getReadInboxMaxId() {
        return readInboxMaxId;
    }

    public void setReadInboxMaxId(int value) {
        this.readInboxMaxId = value;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int value) {
        this.unreadCount = value;
    }

    public int getUnreadImportantCount() {
        return unreadImportantCount;
    }

    public void setUnreadImportantCount(int value) {
        this.unreadImportantCount = value;
    }

    public int getMigratedFromChatId() {
        return migratedFromChatId;
    }

    public void setMigratedFromChatId(int value) {
        this.migratedFromChatId = value;
    }

    public int getMigratedFromMaxId() {
        return migratedFromMaxId;
    }

    public void setMigratedFromMaxId(int value) {
        this.migratedFromMaxId = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        flags = canViewParticipants ? (flags | 8) : (flags &~ 8);
        writeInt(this.flags, stream);
        if ((this.flags & 8) != 0)
            writeTLBool(this.canViewParticipants, stream);
        writeInt(this.id, stream);
        writeTLString(this.about, stream);
        if ((this.flags & 1) != 0)
            writeInt(this.participantsCount, stream);
        if ((this.flags & 2) != 0)
            writeInt(this.adminsCount, stream);
        if ((this.flags & 4) != 0)
            writeInt(this.kickedCount, stream);
        writeInt(this.readInboxMaxId, stream);
        writeInt(this.unreadCount, stream);
        writeInt(this.unreadImportantCount, stream);
        writeTLObject(this.chatPhoto, stream);
        writeTLObject(this.notifySettings, stream);
        writeTLObject(this.exportedInvite, stream);
        writeTLVector(this.botInfo, stream);
        if ((this.flags & 16) != 0)
            writeInt(this.migratedFromChatId, stream);
        if ((this.flags & 16) != 0)
            writeInt(this.migratedFromMaxId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.flags = readInt(stream);
        this.canViewParticipants = (this.flags & 8) != 0;
        this.id = readInt(stream);
        this.about = readTLString(stream);
        if ((this.flags & 1) != 0)
            this.participantsCount = readInt(stream);
        if ((this.flags & 2) != 0)
            this.adminsCount = readInt(stream);
        if ((this.flags & 4) != 0)
            this.kickedCount = readInt(stream);
        this.readInboxMaxId = readInt(stream);
        this.unreadCount = readInt(stream);
        this.unreadImportantCount = readInt(stream);
        this.chatPhoto = (com.github.badoualy.telegram.tl.api.TLAbsPhoto)readTLObject(stream, context);
        this.notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings)readTLObject(stream, context);
        this.exportedInvite = (com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite)readTLObject(stream, context);
        this.botInfo = readTLVector(stream, context);
        if ((this.flags & 16) != 0)
            this.migratedFromChatId = readInt(stream);
        if ((this.flags & 16) != 0)
            this.migratedFromMaxId = readInt(stream);
    }



    @Override
    public String toString() {
        return "channelFull#9e341ddf";
    }

}
