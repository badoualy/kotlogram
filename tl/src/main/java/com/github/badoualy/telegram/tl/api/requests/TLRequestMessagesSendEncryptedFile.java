
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBytes;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readLong;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeLong;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBytes;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestMessagesSendEncryptedFile extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage> {

    public static final int CLASS_ID = 0x9a901b66;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesSendEncryptedFile(        com.github.badoualy.telegram.tl.api.TLInputEncryptedChat _peer,         long _randomId,         TLBytes _data,         com.github.badoualy.telegram.tl.api.TLAbsInputEncryptedFile _file) {
        this.peer = _peer;
        this.randomId = _randomId;
        this.data = _data;
        this.file = _file;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsSentEncryptedMessage, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected com.github.badoualy.telegram.tl.api.TLInputEncryptedChat peer;

    protected long randomId;

    protected TLBytes data;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputEncryptedFile file;


    public com.github.badoualy.telegram.tl.api.TLInputEncryptedChat getPeer() {
        return peer;
    }

    public void setPeer(com.github.badoualy.telegram.tl.api.TLInputEncryptedChat value) {
        this.peer = value;
    }

    public long getRandomId() {
        return randomId;
    }

    public void setRandomId(long value) {
        this.randomId = value;
    }

    public TLBytes getData() {
        return data;
    }

    public void setData(TLBytes value) {
        this.data = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputEncryptedFile getFile() {
        return file;
    }

    public void setFile(com.github.badoualy.telegram.tl.api.TLAbsInputEncryptedFile value) {
        this.file = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.peer, stream);
        writeLong(this.randomId, stream);
        writeTLBytes(this.data, stream);
        writeTLObject(this.file, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.peer = (com.github.badoualy.telegram.tl.api.TLInputEncryptedChat)readTLObject(stream, context);
        this.randomId = readLong(stream);
        this.data = readTLBytes(stream, context);
        this.file = (com.github.badoualy.telegram.tl.api.TLAbsInputEncryptedFile)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messages.sendEncryptedFile#9a901b66";
    }

}
