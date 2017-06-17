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
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeString;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;
import static com.github.badoualy.telegram.tl.TLObjectUtils.computeTLStringSerializedSize;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelFull extends TLAbsChatFull {

    public static final int CONSTRUCTOR_ID = 0xc3d5512f;

    protected int flags;

    protected boolean canViewParticipants;

    protected boolean canSetUsername;

    protected String about;

    protected Integer participantsCount;

    protected Integer adminsCount;

    protected Integer kickedCount;

    protected int readInboxMaxId;

    protected int readOutboxMaxId;

    protected int unreadCount;

    protected Integer migratedFromChatId;

    protected Integer migratedFromMaxId;

    protected Integer pinnedMsgId;

    private final String _constructor = "channelFull#c3d5512f";

    public TLChannelFull() {
    }

    public TLChannelFull(boolean canViewParticipants, boolean canSetUsername, int id, String about, Integer participantsCount, Integer adminsCount, Integer kickedCount, int readInboxMaxId, int readOutboxMaxId, int unreadCount, TLAbsPhoto chatPhoto, TLAbsPeerNotifySettings notifySettings, TLAbsExportedChatInvite exportedInvite, TLVector<TLBotInfo> botInfo, Integer migratedFromChatId, Integer migratedFromMaxId, Integer pinnedMsgId) {
        this.canViewParticipants = canViewParticipants;
        this.canSetUsername = canSetUsername;
        this.id = id;
        this.about = about;
        this.participantsCount = participantsCount;
        this.adminsCount = adminsCount;
        this.kickedCount = kickedCount;
        this.readInboxMaxId = readInboxMaxId;
        this.readOutboxMaxId = readOutboxMaxId;
        this.unreadCount = unreadCount;
        this.chatPhoto = chatPhoto;
        this.notifySettings = notifySettings;
        this.exportedInvite = exportedInvite;
        this.botInfo = botInfo;
        this.migratedFromChatId = migratedFromChatId;
        this.migratedFromMaxId = migratedFromMaxId;
        this.pinnedMsgId = pinnedMsgId;
    }

    private void computeFlags() {
        flags = 0;
        flags = canViewParticipants ? (flags | 8) : (flags & ~8);
        flags = canSetUsername ? (flags | 64) : (flags & ~64);
        flags = participantsCount != null ? (flags | 1) : (flags & ~1);
        flags = adminsCount != null ? (flags | 2) : (flags & ~2);
        flags = kickedCount != null ? (flags | 4) : (flags & ~4);
        flags = migratedFromChatId != null ? (flags | 16) : (flags & ~16);
        flags = migratedFromMaxId != null ? (flags | 16) : (flags & ~16);
        flags = pinnedMsgId != null ? (flags | 32) : (flags & ~32);
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        computeFlags();

        writeInt(flags, stream);
        writeInt(id, stream);
        writeString(about, stream);
        if ((flags & 1) != 0) {
            if (participantsCount == null) throwNullFieldException("participantsCount", flags);
            writeInt(participantsCount, stream);
        }
        if ((flags & 2) != 0) {
            if (adminsCount == null) throwNullFieldException("adminsCount", flags);
            writeInt(adminsCount, stream);
        }
        if ((flags & 4) != 0) {
            if (kickedCount == null) throwNullFieldException("kickedCount", flags);
            writeInt(kickedCount, stream);
        }
        writeInt(readInboxMaxId, stream);
        writeInt(readOutboxMaxId, stream);
        writeInt(unreadCount, stream);
        writeTLObject(chatPhoto, stream);
        writeTLObject(notifySettings, stream);
        writeTLObject(exportedInvite, stream);
        writeTLVector(botInfo, stream);
        if ((flags & 16) != 0) {
            if (migratedFromChatId == null) throwNullFieldException("migratedFromChatId", flags);
            writeInt(migratedFromChatId, stream);
        }
        if ((flags & 16) != 0) {
            if (migratedFromMaxId == null) throwNullFieldException("migratedFromMaxId", flags);
            writeInt(migratedFromMaxId, stream);
        }
        if ((flags & 32) != 0) {
            if (pinnedMsgId == null) throwNullFieldException("pinnedMsgId", flags);
            writeInt(pinnedMsgId, stream);
        }
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        flags = readInt(stream);
        canViewParticipants = (flags & 8) != 0;
        canSetUsername = (flags & 64) != 0;
        id = readInt(stream);
        about = readTLString(stream);
        participantsCount = (flags & 1) != 0 ? readInt(stream) : null;
        adminsCount = (flags & 2) != 0 ? readInt(stream) : null;
        kickedCount = (flags & 4) != 0 ? readInt(stream) : null;
        readInboxMaxId = readInt(stream);
        readOutboxMaxId = readInt(stream);
        unreadCount = readInt(stream);
        chatPhoto = readTLObject(stream, context, TLAbsPhoto.class, -1);
        notifySettings = readTLObject(stream, context, TLAbsPeerNotifySettings.class, -1);
        exportedInvite = readTLObject(stream, context, TLAbsExportedChatInvite.class, -1);
        botInfo = readTLVector(stream, context);
        migratedFromChatId = (flags & 16) != 0 ? readInt(stream) : null;
        migratedFromMaxId = (flags & 16) != 0 ? readInt(stream) : null;
        pinnedMsgId = (flags & 32) != 0 ? readInt(stream) : null;
    }

    @Override
    public int computeSerializedSize() {
        computeFlags();

        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += computeTLStringSerializedSize(about);
        if ((flags & 1) != 0) {
            if (participantsCount == null) throwNullFieldException("participantsCount", flags);
            size += SIZE_INT32;
        }
        if ((flags & 2) != 0) {
            if (adminsCount == null) throwNullFieldException("adminsCount", flags);
            size += SIZE_INT32;
        }
        if ((flags & 4) != 0) {
            if (kickedCount == null) throwNullFieldException("kickedCount", flags);
            size += SIZE_INT32;
        }
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += SIZE_INT32;
        size += chatPhoto.computeSerializedSize();
        size += notifySettings.computeSerializedSize();
        size += exportedInvite.computeSerializedSize();
        size += botInfo.computeSerializedSize();
        if ((flags & 16) != 0) {
            if (migratedFromChatId == null) throwNullFieldException("migratedFromChatId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 16) != 0) {
            if (migratedFromMaxId == null) throwNullFieldException("migratedFromMaxId", flags);
            size += SIZE_INT32;
        }
        if ((flags & 32) != 0) {
            if (pinnedMsgId == null) throwNullFieldException("pinnedMsgId", flags);
            size += SIZE_INT32;
        }
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public boolean getCanViewParticipants() {
        return canViewParticipants;
    }

    public void setCanViewParticipants(boolean canViewParticipants) {
        this.canViewParticipants = canViewParticipants;
    }

    public boolean getCanSetUsername() {
        return canSetUsername;
    }

    public void setCanSetUsername(boolean canSetUsername) {
        this.canSetUsername = canSetUsername;
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

    public Integer getParticipantsCount() {
        return participantsCount;
    }

    public void setParticipantsCount(Integer participantsCount) {
        this.participantsCount = participantsCount;
    }

    public Integer getAdminsCount() {
        return adminsCount;
    }

    public void setAdminsCount(Integer adminsCount) {
        this.adminsCount = adminsCount;
    }

    public Integer getKickedCount() {
        return kickedCount;
    }

    public void setKickedCount(Integer kickedCount) {
        this.kickedCount = kickedCount;
    }

    public int getReadInboxMaxId() {
        return readInboxMaxId;
    }

    public void setReadInboxMaxId(int readInboxMaxId) {
        this.readInboxMaxId = readInboxMaxId;
    }

    public int getReadOutboxMaxId() {
        return readOutboxMaxId;
    }

    public void setReadOutboxMaxId(int readOutboxMaxId) {
        this.readOutboxMaxId = readOutboxMaxId;
    }

    public int getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(int unreadCount) {
        this.unreadCount = unreadCount;
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

    public TLVector<TLBotInfo> getBotInfo() {
        return botInfo;
    }

    public void setBotInfo(TLVector<TLBotInfo> botInfo) {
        this.botInfo = botInfo;
    }

    public Integer getMigratedFromChatId() {
        return migratedFromChatId;
    }

    public void setMigratedFromChatId(Integer migratedFromChatId) {
        this.migratedFromChatId = migratedFromChatId;
    }

    public Integer getMigratedFromMaxId() {
        return migratedFromMaxId;
    }

    public void setMigratedFromMaxId(Integer migratedFromMaxId) {
        this.migratedFromMaxId = migratedFromMaxId;
    }

    public Integer getPinnedMsgId() {
        return pinnedMsgId;
    }

    public void setPinnedMsgId(Integer pinnedMsgId) {
        this.pinnedMsgId = pinnedMsgId;
    }
}
