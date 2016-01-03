
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLNotifyPeer extends TLAbsNotifyPeer {
    public static final int CLASS_ID = 0x9fd40bd8;

    public TLNotifyPeer() {

    }


    public TLNotifyPeer(        com.github.badoualy.telegram.tl.api.TLAbsPeer _peer) {
        this.peer = _peer;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsPeer peer;


    public com.github.badoualy.telegram.tl.api.TLAbsPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsPeer value) {
        this.peer = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsPeer)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "notifyPeer#9fd40bd8";
    }

}
