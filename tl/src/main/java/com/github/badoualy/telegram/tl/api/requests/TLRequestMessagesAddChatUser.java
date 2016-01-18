
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestMessagesAddChatUser extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> {

    public static final int CLASS_ID = 0x2ee9ee9e;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesAddChatUser(        int _chatId,         com.github.badoualy.telegram.tl.api.TLAbsInputUser _userId,         int _fwdLimit) {
        this.chatId = _chatId;
        this.userId = _userId;
        this.fwdLimit = _fwdLimit;

    }



    public com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage) {
            return (com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int chatId;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputUser userId;

    protected int fwdLimit;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputUser getUserId() {
        return userId;
    }

    public void setUserId(com.github.badoualy.telegram.tl.api.TLAbsInputUser value) {
        this.userId = value;
    }

    public int getFwdLimit() {
        return fwdLimit;
    }

    public void setFwdLimit(int value) {
        this.fwdLimit = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeTLObject(this.userId, stream);
        writeInt(this.fwdLimit, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.userId = (com.github.badoualy.telegram.tl.api.TLAbsInputUser)readTLObject(stream, context);
        this.fwdLimit = readInt(stream);
    }



    @Override
    public String toString() {
        return "messages.addChatUser#2ee9ee9e";
    }

}
