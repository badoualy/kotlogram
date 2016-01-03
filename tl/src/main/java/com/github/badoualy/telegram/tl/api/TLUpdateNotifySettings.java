
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUpdateNotifySettings extends TLAbsUpdate {
    public static final int CLASS_ID = 0xbec268ef;

    public TLUpdateNotifySettings() {

    }


    public TLUpdateNotifySettings(        com.github.badoualy.telegram.tl.api.TLAbsNotifyPeer _peer,         com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings _notifySettings) {
        this.peer = _peer;
        this.notifySettings = _notifySettings;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsNotifyPeer peer;

    protected com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings notifySettings;


    public com.github.badoualy.telegram.tl.api.TLAbsNotifyPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsNotifyPeer value) {
        this.peer = value;
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
        writeTLObject(this.notifySettings, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsNotifyPeer)readTLObject(stream, context);
        this.notifySettings = (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "updateNotifySettings#bec268ef";
    }

}
