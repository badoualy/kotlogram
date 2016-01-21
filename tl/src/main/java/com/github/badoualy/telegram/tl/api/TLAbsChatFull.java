
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsChatFull extends TLObject {

    protected int id;

    protected com.github.badoualy.telegram.tl.api.TLAbsPhoto chatPhoto;

    protected com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings notifySettings;

    protected com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite exportedInvite;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsBotInfo> botInfo;


    public int getId() {
        return id;
    }

    public void setId(int value) {
        this.id = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsPhoto getChatPhoto() {
        return chatPhoto;
    }

    public void setChatPhoto(com.github.badoualy.telegram.tl.api.TLAbsPhoto value) {
        this.chatPhoto = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings value) {
        this.notifySettings = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite getExportedInvite() {
        return exportedInvite;
    }

    public void setExportedInvite(com.github.badoualy.telegram.tl.api.TLAbsExportedChatInvite value) {
        this.exportedInvite = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsBotInfo> getBotInfo() {
        return botInfo;
    }

    public void setBotInfo(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsBotInfo> value) {
        this.botInfo = value;
    }

}
