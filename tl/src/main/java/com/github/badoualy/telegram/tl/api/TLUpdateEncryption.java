
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateEncryption extends TLAbsUpdate {
    public static final int CLASS_ID = 0xb4a2e88d;

    public TLUpdateEncryption() {

    }


    public TLUpdateEncryption(        com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat _chat,         int _date) {
        this.chat = _chat;
        this.date = _date;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat chat;

    protected int date;


    public com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat getChat() {
        return chat;
    }

    public void setChat(com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat value) {
        this.chat = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.chat, stream);
        writeInt(this.date, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chat = (com.github.badoualy.telegram.tl.api.TLAbsEncryptedChat)readTLObject(stream, context);
        this.date = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateEncryption#b4a2e88d";
    }

}
