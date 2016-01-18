
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.TLContext;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;



public class TLUpdateUserTyping extends TLAbsUpdate {
    public static final int CLASS_ID = 0x5c486927;

    public TLUpdateUserTyping() {

    }


    public TLUpdateUserTyping(        int _userId,         com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction _action) {
        this.userId = _userId;
        this.action = _action;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int userId;

    protected com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction action;


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

        writeInt(this.userId, stream);
        writeTLObject(this.action, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.userId = readInt(stream);
        this.action = (com.github.badoualy.telegram.tl.api.TLAbsSendMessageAction)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "updateUserTyping#5c486927";
    }

}
