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
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChatFull extends TLAbsChatFull {

    public static final int CONSTRUCTOR_ID = 0x2e02a614;

    protected TLAbsChatParticipants participants;

    private final String _constructor = "chatFull#2e02a614";

    public TLChatFull() {
    }

    public TLChatFull(int id, TLAbsChatParticipants participants, TLAbsPhoto chatPhoto, TLAbsPeerNotifySettings notifySettings, TLAbsExportedChatInvite exportedInvite, TLVector<TLBotInfo> botInfo) {
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
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        id = readInt(stream);
        participants = readTLObject(stream, context, TLAbsChatParticipants.class, -1);
        chatPhoto = readTLObject(stream, context, TLAbsPhoto.class, -1);
        notifySettings = readTLObject(stream, context, TLAbsPeerNotifySettings.class, -1);
        exportedInvite = readTLObject(stream, context, TLAbsExportedChatInvite.class, -1);
        botInfo = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += SIZE_INT32;
        size += participants.computeSerializedSize();
        size += chatPhoto.computeSerializedSize();
        size += notifySettings.computeSerializedSize();
        size += exportedInvite.computeSerializedSize();
        size += botInfo.computeSerializedSize();
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

    public TLVector<TLBotInfo> getBotInfo() {
        return botInfo;
    }

    public void setBotInfo(TLVector<TLBotInfo> botInfo) {
        this.botInfo = botInfo;
    }
}
