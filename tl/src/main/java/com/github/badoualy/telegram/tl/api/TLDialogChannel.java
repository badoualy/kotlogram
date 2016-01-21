
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLDialogChannel extends TLAbsDialog {
    public static final int CLASS_ID = 0x5b8496b2;

    public TLDialogChannel() {

    }


    public TLDialogChannel(        com.github.badoualy.telegram.tl.api.TLAbsPeer _peer,         int _topMessage,         int _topImportantMessage,         int _readInboxMaxId,         int _unreadCount,         int _unreadImportantCount,         com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings _notifySettings,         int _pts) {
        this.peer = _peer;
        this.topMessage = _topMessage;
        this.topImportantMessage = _topImportantMessage;
        this.readInboxMaxId = _readInboxMaxId;
        this.unreadCount = _unreadCount;
        this.unreadImportantCount = _unreadImportantCount;
        this.notifySettings = _notifySettings;
        this.pts = _pts;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int topImportantMessage;

    protected int unreadImportantCount;

    protected int pts;


    public int getTopImportantMessage() {
        return topImportantMessage;
    }

    public void setTopImportantMessage(int value) {
        this.topImportantMessage = value;
    }

    public int getUnreadImportantCount() {
        return unreadImportantCount;
    }

    public void setUnreadImportantCount(int value) {
        this.unreadImportantCount = value;
    }

    public int getPts() {
        return pts;
    }

    public void setPts(int value) {
        this.pts = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeInt(this.topMessage, stream);
        writeInt(this.topImportantMessage, stream);
        writeInt(this.readInboxMaxId, stream);
        writeInt(this.unreadCount, stream);
        writeInt(this.unreadImportantCount, stream);
        writeTLObject(this.notifySettings, stream);
        writeInt(this.pts, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsPeer)readTLObject(stream, context);
        this.topMessage = readInt(stream);
        this.topImportantMessage = readInt(stream);
        this.readInboxMaxId = readInt(stream);
        this.unreadCount = readInt(stream);
        this.unreadImportantCount = readInt(stream);
        this.notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings)readTLObject(stream, context);
        this.pts = readInt(stream);
    }



    @Override
    public String toString() {
        return "dialogChannel#5b8496b2";
    }

}
