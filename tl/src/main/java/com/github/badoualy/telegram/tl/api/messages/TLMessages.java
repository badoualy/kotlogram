
package com.github.badoualy.telegram.tl.api.messages;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLMessages extends TLAbsMessages {
    public static final int CLASS_ID = 0x8c718e87;

    public TLMessages() {

    }


    public TLMessages(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> _messages,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> _chats,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users) {
        this.messages = _messages;
        this.chats = _chats;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }




    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.messages, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.messages = readTLVector(stream, context);
        this.chats = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }



    @Override
    public String toString() {
        return "messages.messages#8c718e87";
    }

}
