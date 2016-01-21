
package com.github.badoualy.telegram.tl.api.requests;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLBool;
import com.github.badoualy.telegram.tl.core.TLMethod;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLBool;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;


public class TLRequestMessagesEditChatAdmin extends TLMethod<TLBool> {

    public static final int CLASS_ID = 0xa9e69f2e;

    public int getClassId() {
        return CLASS_ID;
    }


    public TLRequestMessagesEditChatAdmin(        int _chatId,         com.github.badoualy.telegram.tl.api.TLAbsInputUser _userId,         boolean _isAdmin) {
        this.chatId = _chatId;
        this.userId = _userId;
        this.isAdmin = _isAdmin;

    }



    public TLBool deserializeResponse(InputStream stream, TLContext context) throws IOException {

        TLObject res = readTLObject(stream, context);
        if (res == null) {
            throw new IOException("Unable to parse response");
        }
        if (res instanceof TLBool) {
            return (TLBool)res;
        }
        else {
            throw new IOException("Incorrect response type. Expected TLBool, got: " + res.getClass().getCanonicalName());
        }

    }
        


    protected int chatId;

    protected com.github.badoualy.telegram.tl.api.TLAbsInputUser userId;

    protected boolean isAdmin;


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

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean value) {
        this.isAdmin = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.chatId, stream);
        writeTLObject(this.userId, stream);
        writeTLBool(this.isAdmin, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.chatId = readInt(stream);
        this.userId = (com.github.badoualy.telegram.tl.api.TLAbsInputUser)readTLObject(stream, context);
        this.isAdmin = readTLBool(stream);
    }



    @Override
    public String toString() {
        return "messages.editChatAdmin#a9e69f2e";
    }

}
