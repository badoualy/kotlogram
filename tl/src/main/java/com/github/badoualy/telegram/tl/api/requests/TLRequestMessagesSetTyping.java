
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesSetTyping extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0xa3825e50;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSetTyping(        com.github.badoualy.telegram.tl.api.TLAbsInputPeer _peer,         com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction _action) {
        this.peer = _peer;
        this.action = _action;

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
        


    protected com.github.badoualy.telegram.tl.api.TLAbsInputPeer peer;

    protected com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction action;


    public com.github.badoualy.telegram.tl.api.TLAbsInputPeer getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLAbsInputPeer value) {
        this.peer = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction getAction() {
        return action;
    }

    public void setAction(com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction value) {
        this.action = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLObject(this.action, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLAbsInputPeer)readTLObject(stream, context);
        this.action = (com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messages.setTyping#a3825e50";
    }

}
