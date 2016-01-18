
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateChatUserTyping extends TLAbsUpdate {
    public static final int CLASS_ID = 0x9a65ea1f;

    public TLUpdateChatUserTyping() {

    }


    public TLUpdateChatUserTyping(        int _chatId,         int _userId,         com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction _action) {
        this.chatId = _chatId;
        this.userId = _userId;
        this.action = _action;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int chatId;

    protected int userId;

    protected com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction action;


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

    public com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction getAction() {
        return action;
    }

    public void setAction(com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction value) {
        this.action = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeInt(this.userId, stream);
        writeTLObject(this.action, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.userId = readInt(stream);
        this.action = (com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "updateChatUserTyping#9a65ea1f";
    }

}
