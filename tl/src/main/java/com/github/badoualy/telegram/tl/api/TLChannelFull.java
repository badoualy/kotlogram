package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLString;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeBoolean;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelFull extends TLAbsChatFull {
    public static final int CONSTRUCTOR_ID = 0x9e341ddf;

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

    public TLChannelFull() {
    }

    public TLChannelFull(int flags, boolean canViewParticipants, int id, String about, int participantsCount, int adminsCount, int kickedCount, int readInboxMaxId, int unreadCount, int unreadImportantCount, TLAbsPhoto chatPhoto, TLAbsPeerNotifySettings notifySettings, TLAbsExportedChatInvite exportedInvite, TLVector<TLAbsBotInfo> botInfo, int migratedFromChatId, int migratedFromMaxId) {
        this.flags = flags;
        this.canViewParticipants = canViewParticipants;
        this.id = id;
        this.about = about;
        this.participantsCount = participantsCount;
        this.adminsCount = adminsCount;
        this.kickedCount = kickedCount;
        this.readInboxMaxId = readInboxMaxId;
        this.unreadCount = unreadCount;
        this.unreadImportantCount = unreadImportantCount;
        this.chatPhoto = chatPhoto;
        this.notifySettings = notifySettings;
        this.exportedInvite = exportedInvite;
        this.botInfo = botInfo;
        this.migratedFromChatId = migratedFromChatId;
        this.migratedFromMaxId = migratedFromMaxId;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        flags = 0;
        flags = canViewParticipants ? (flags | 8) : (flags &~ 8);

        writeInt(flags, stream);
        if ((flags & 8) != 0) writeBoolean(canViewParticipants, stream);
        writeInt(id, stream);
        writeString(about, stream);
        if ((flags & 1) != 0) writeInt(participantsCount, stream);
        if ((flags & 2) != 0) writeInt(adminsCount, stream);
        if ((flags & 4) != 0) writeInt(kickedCount, stream);
        writeInt(readInboxMaxId, stream);
        writeInt(unreadCount, stream);
        writeInt(unreadImportantCount, stream);
        writeTLObject(chatPhoto, stream);
        writeTLObject(notifySettings, stream);
        writeTLObject(exportedInvite, stream);
        writeTLVector(botInfo, stream);
        if ((flags & 16) != 0) writeInt(migratedFromChatId, stream);
        if ((flags & 16) != 0) writeInt(migratedFromMaxId, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        canViewParticipants = (flags & 8) != 0;
        id = readInt(stream);
        about = readTLString(stream);
        if ((flags & 1) != 0) participantsCount = readInt(stream);
        if ((flags & 2) != 0) adminsCount = readInt(stream);
        if ((flags & 4) != 0) kickedCount = readInt(stream);
        readInboxMaxId = readInt(stream);
        unreadCount = readInt(stream);
        unreadImportantCount = readInt(stream);
        chatPhoto = (com.github.badoualy.telegram.tl.api.TLAbsPhoto) readTLObject(stream, context);
        notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings) readTLObject(stream, context);
        exportedInvite = (com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite) readTLObject(stream, context);
        botInfo = readTLVector(stream, context);
        if ((flags & 16) != 0) migratedFromChatId = readInt(stream);
        if ((flags & 16) != 0) migratedFromMaxId = readInt(stream);
    }

    @Override
    public String toString() {
        return "channelFull#9e341ddf";
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

    public boolean getCanViewParticipants() {
        return canViewParticipants;
    }

    public void setCanViewParticipants(boolean canViewParticipants) {
        this.canViewParticipants = canViewParticipants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public int getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(int participantsCount) {
        this.participantsCount = participantsCount;
    }

    public int getAdminsCount() {
        return adminsCount;
    }

    public void setAdminsCount(int adminsCount) {
        this.adminsCount = adminsCount;
    }

    public int getKickedCount() {
        return kickedCount;
    }

    public void setKickedCount(int kickedCount) {
        this.kickedCount = kickedCount;
    }

    public int getReadInboxMaxId() {
        return readInboxMaxId;
    }

    public void setReadInboxMaxId(int readInboxMaxId) {
        this.readInboxMaxId = readInboxMaxId;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
    }

    public int getUnreadImportantCount() {
        return unreadImportantCount;
    }

    public void setUnreadImportantCount(int unreadImportantCount) {
        this.unreadImportantCount = unreadImportantCount;
    }

    public TLAbsPhoto getChatPhoto() {
        return chatPhoto;
    }

    public void setChatPhoto(TLAbsPhoto chatPhoto) {
        this.chatPhoto = chatPhoto;
    }

    public TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(TLAbsPeerNotifySettings notifySettings) {
        this.notifySettings = notifySettings;
    }

    public TLAbsExportedChatInvite getExportedInvite() {
        return exportedInvite;
    }

    public void setExportedInvite(TLAbsExportedChatInvite exportedInvite) {
        this.exportedInvite = exportedInvite;
    }

    public TLVector<TLAbsBotInfo> getBotInfo() {
        return botInfo;
    }

    public void setBotInfo(TLVector<TLAbsBotInfo> botInfo) {
        this.botInfo = botInfo;
    }

    public int getMigratedFromChatId() {
        return migratedFromChatId;
    }

    public void setMigratedFromChatId(int migratedFromChatId) {
        this.migratedFromChatId = migratedFromChatId;
    }

    public int getMigratedFromMaxId() {
        return migratedFromMaxId;
    }

    public void setMigratedFromMaxId(int migratedFromMaxId) {
        this.migratedFromMaxId = migratedFromMaxId;
    }
}
