
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestAccountUpdateNotifySettings extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x84be5b93;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountUpdateNotifySettings(        com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer _peer,         com.github.badoualy.telegram.tl.api.TLInputPeerNotifySettings _settings) {
        this.peer = _peer;
        this.settings = _settings;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer peer;

    protected com.github.badoualy.telegram.tl.api.TLInputPeerNotifySettings settings;


    public com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer value) {
        this.peer = value;
    }

    public com.github.badoualy.telegram.tl.api.TLInputPeerNotifySettings getSettings() {
        return settings;
    }

    public void setSettings(com.github.badoualy.telegram.tl.api.TLInputPeerNotifySettings value) {
        this.settings = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLObject(this.settings, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer)readTLObject(stream, context);
        this.settings = (com.github.badoualy.telegram.tl.api.TLInputPeerNotifySettings)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "account.updateNotifySettings#84be5b93";
    }

}
