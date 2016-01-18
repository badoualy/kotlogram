
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


public class TLRequestMessagesEditChatPhoto extends TLMethod<com.github.badoualy.telegram.tl.api.messages.TLAbsStatedMessage> {

    public static final int CLASS_ID = 0xd881821d;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesEditChatPhoto(        int _chatId,         com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto _photo) {
        this.chatId = _chatId;
        this.photo = _photo;

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

    protected com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto photo;


    public int getChatId() {
        return chatId;
    }

    public void setChatId(int value) {
        this.chatId = value;
    }

    public com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto getPhoto() {
        return photo;
    }

    public void setPhoto(com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto value) {
        this.photo = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeTLObject(this.photo, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.photo = (com.github.badoualy.telegram.tl.api.TLAbsInputChatPhoto)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "messages.editChatPhoto#d881821d";
    }

}
