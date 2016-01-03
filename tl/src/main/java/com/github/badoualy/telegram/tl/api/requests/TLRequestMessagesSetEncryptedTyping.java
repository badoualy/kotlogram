
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesSetEncryptedTyping extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0x791451ed;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSetEncryptedTyping(        com.github.badoualy.telegram.tl.api.TLInputEncryptedChat _peer,         boolean _typing) {
        this.peer = _peer;
        this.typing = _typing;

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
        


    protected com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer;

    protected boolean typing;


    public com.github.badoualy.telegram.tl.api.TLInputEncryptedChat getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat value) {
        this.peer = value;
    }

    public boolean getTyping() {
        return typing;
    }

    public void setTyping(boolean value) {
        this.typing = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLBool(this.typing, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLInputEncryptedChat)readTLObject(stream, context);
        this.typing = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "messages.setEncryptedTyping#791451ed";
    }

}
