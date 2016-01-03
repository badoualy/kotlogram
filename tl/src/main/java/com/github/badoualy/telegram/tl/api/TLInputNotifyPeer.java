
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLInputNotifyPeer extends TLAbsInputNotifyPeer {
    public static final int CLASS_ID = 0xb8bc5b0c;

    public TLInputNotifyPeer() {

    }


    public TLInputNotifyPeer(        com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer) {
        this.peer = _peer;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.peer = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "inputNotifyPeer#b8bc5b0c";
    }

}
