
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestAccountGetNotifySettings extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings> {

    public static final int CLASS_ID = 0x12b3ad31;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestAccountGetNotifySettings(        com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer _peer) {
        this.peer = _peer;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings) {
            return (com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsPeerNotifySettings, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer peer;


    public com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer value) {
        this.peer = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputNotifyPeer)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "account.getNotifySettings#12b3ad31";
    }

}
