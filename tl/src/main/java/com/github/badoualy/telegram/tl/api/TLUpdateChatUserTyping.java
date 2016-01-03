
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
