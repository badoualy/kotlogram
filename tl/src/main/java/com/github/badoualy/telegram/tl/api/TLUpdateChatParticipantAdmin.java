
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;



public class TLUpdateChatParticipantAdmin extends TLAbsUpdate {
    public static final int CLASS_ID = 0xb6901959;

    public TLUpdateChatParticipantAdmin() {

    }


    public TLUpdateChatParticipantAdmin(        int _chatId,         int _userId,         boolean _isAdmin,         int _version) {
        this.chatId = _chatId;
        this.userId = _userId;
        this.isAdmin = _isAdmin;
        this.version = _version;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int chatId;

    protected int userId;

    protected boolean isAdmin;

    protected int version;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int value) {
        this.userId = value;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean value) {
        this.isAdmin = value;
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
        writeInt(this.userId, stream);
        writeTLBool(this.isAdmin, stream);
        writeInt(this.version, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.userId = readInt(stream);
        this.isAdmin = readTLBool(stream);
        this.version = readInt(stream);
    }



    @Override
    public String toString() {
        return "updateChatParticipantAdmin#b6901959";
    }

}
