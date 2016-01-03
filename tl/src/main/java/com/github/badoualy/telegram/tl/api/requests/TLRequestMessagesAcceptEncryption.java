
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesAcceptEncryption extends TLMethod<com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat> {

    public static final int CLASS_ID = 0x3dbc0415;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesAcceptEncryption(        com.github.badoualy.telegram.tl.api.TLInputEncryptedChat _peer,         TLBytes _gB,         long _keyFingerprint) {
        this.peer = _peer;
        this.gB = _gB;
        this.keyFingerprint = _keyFingerprint;

    }



    public com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat) {
            return (com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer;

    protected TLBytes gB;

    protected long keyFingerprint;


    public com.github.badoualy.telegram.tl.api.TLInputEncryptedChat getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat value) {
        this.peer = value;
    }

    public TLBytes getGB() {
        return gB;
    }

    public void setGB(TLBytes value) {
        this.gB = value;
    }

    public long getKeyFingerprint() {
        return keyFingerprint;
    }

    public void setKeyFingerprint(long value) {
        this.keyFingerprint = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeTLBytes(this.gB, stream);
        writeLong(this.keyFingerprint, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLInputEncryptedChat)readTLObject(stream, context);
        this.gB = readTLBytes(stream, context);
        this.keyFingerprint = readLong(stream);
    }



    @Override
    public String toString() {
        return "messages.acceptEncryption#3dbc0415";
    }

}
