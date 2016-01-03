
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLRequestMessagesDeleteChatUser extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> {

    public static final int CLASS_ID = 0xc3c5cd23;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesDeleteChatUser(        int _chatId,         com.github.badoualy.telegram.tl.api.TLAbsInputUser _userId) {
        this.chatId = _chatId;
        this.userId = _userId;

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


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeTLObject(this.userId, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.userId = (com.github.badoualy.telegram.tl.api.TLAbsInputUser)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messages.deleteChatUser#c3c5cd23";
    }

}
