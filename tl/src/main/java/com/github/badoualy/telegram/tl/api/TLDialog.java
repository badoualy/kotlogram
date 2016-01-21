
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLDialog extends TLAbsDialog {
    public static final int CLASS_ID = 0xc1dd804a;

    public TLDialog() {

    }


    public TLDialog(        com.github.badoualy.telegram.tl.api.TLAbsPeer _peer,         int _topMessage,         int _readInboxMaxId,         int _unreadCount,         com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings _notifySettings) {
        this.peer = _peer;
        this.topMessage = _topMessage;
        this.readInboxMaxId = _readInboxMaxId;
        this.unreadCount = _unreadCount;
        this.notifySettings = _notifySettings;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeInt(this.topMessage, stream);
        writeInt(this.readInboxMaxId, stream);
        writeInt(this.unreadCount, stream);
        writeTLObject(this.notifySettings, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsPeer)readTLObject(stream, context);
        this.topMessage = readInt(stream);
        this.readInboxMaxId = readInt(stream);
        this.unreadCount = readInt(stream);
        this.notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "dialog#c1dd804a";
    }

}
