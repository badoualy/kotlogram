package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public abstract class TLAbsChatFull extends TLObject {
    protected int id;

    protected TLAbsPhoto chatPhoto;

    protected TLAbsPeerNotifySettings notifySettings;

    protected TLAbsExportedChatInvite exportedInvite;

    protected TLVector<TLAbsBotInfo> botInfo;

    public TLAbsChatFull() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
