
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;



public class TLUpdateChatAdmins extends TLAbsUpdate {
    public static final int CLASS_ID = 0x6e947941;

    public TLUpdateChatAdmins() {

    }


    public TLUpdateChatAdmins(        int _chatId,         boolean _enabled,         int _version) {
        this.chatId = _chatId;
        this.enabled = _enabled;
        this.version = _version;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int chatId;

    protected boolean enabled;

    protected int version;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(boolean value) {
        this.enabled = value;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int value) {
        this.version = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeTLBool(this.enabled, stream);
        writeInt(this.version, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.enabled = readTLBool(stream);
        this.version = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateChatAdmins#6e947941";
    }

}
