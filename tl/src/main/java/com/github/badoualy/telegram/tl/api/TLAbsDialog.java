
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.TLObject;



public abstract class TLAbsDialog extends TLObject {

    protected com.github.badoualy.telegram.tl.api.TLAbsPeer peer;

    protected int topMessage;

    protected int readInboxMaxId;

    protected int unreadCount;

    protected com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings notifySettings;


    public com.github.badoualy.telegram.tl.api.TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsPeer value) {
        this.peer = value;
    }

    public int getTopMessage() {
        return topMessage;
    }

    public void setTopMessage(int value) {
        this.topMessage = value;
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

    public com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings getNotifySettings() {
        return notifySettings;
    }

    public void setNotifySettings(com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings value) {
        this.notifySettings = value;
    }

}
