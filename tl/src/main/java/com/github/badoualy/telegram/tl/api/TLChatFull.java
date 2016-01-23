package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatFull extends TLAbsChatFull {
    public static final int CLASS_ID = 0x2e02a614;

    protected int id;

    protected TLAbsChatParticipants participants;

    protected TLAbsPhoto chatPhoto;

    protected TLAbsPeerNotifySettings notifySettings;

    protected TLAbsExportedChatInvite exportedInvite;

    protected TLVector<TLAbsBotInfo> botInfo;

    public TLChatFull() {
    }

    public TLChatFull(int id, TLAbsChatParticipants participants, TLAbsPhoto chatPhoto, TLAbsPeerNotifySettings notifySettings, TLAbsExportedChatInvite exportedInvite, TLVector<TLAbsBotInfo> botInfo) {
        this.id = id;
        this.participants = participants;
        this.chatPhoto = chatPhoto;
        this.notifySettings = notifySettings;
        this.exportedInvite = exportedInvite;
        this.botInfo = botInfo;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(id, stream);
        writeTLObject(participants, stream);
        writeTLObject(chatPhoto, stream);
        writeTLObject(notifySettings, stream);
        writeTLObject(exportedInvite, stream);
        writeTLVector(botInfo, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readInt(stream);
        participants = (com.github.badoualy.telegram.tl.api.TLAbsChatParticipants) readTLObject(stream, context);
        chatPhoto = (com.github.badoualy.telegram.tl.api.TLAbsPhoto) readTLObject(stream, context);
        notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings) readTLObject(stream, context);
        exportedInvite = (com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite) readTLObject(stream, context);
        botInfo = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "chatFull#2e02a614";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TLAbsChatParticipants getParticipants() {
        return participants;
    }

    public void setParticipants(TLAbsChatParticipants participants) {
        this.participants = participants;
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
}
