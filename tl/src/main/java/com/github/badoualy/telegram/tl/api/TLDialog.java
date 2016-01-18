
package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLDialog extends TLObject {

    public static final int CLASS_ID = 0xab3a99ac;

    public TLDialog() {

    }


    public TLDialog(        com.github.badoualy.telegram.tl.api.TLAbsPeer _peer,         int _topMessage,         int _unreadCount,         com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings _notifySettings) {
        this.peer = _peer;
        this.topMessage = _topMessage;
        this.unreadCount = _unreadCount;
        this.notifySettings = _notifySettings;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsPeer peer;

    protected int topMessage;

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


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeInt(this.topMessage, stream);
        writeInt(this.unreadCount, stream);
        writeTLObject(this.notifySettings, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsPeer)readTLObject(stream, context);
        this.topMessage = readInt(stream);
        this.unreadCount = readInt(stream);
        this.notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings)readTLObject(stream, context);
    }


    @Override
    public String toString() {
        return "dialog#ab3a99ac";
    }

}
