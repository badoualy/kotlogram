
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



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
