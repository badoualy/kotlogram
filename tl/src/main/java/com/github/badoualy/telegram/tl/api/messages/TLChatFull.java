
package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;


public class TLChatFull extends TLObject {

    public static final int CLASS_ID = 0xe5d7d19c;

    public TLChatFull() {

    }


    public TLChatFull(        com.github.badoualy.telegram.tl.api.TLChatFull _fullChat,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> _chats,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users) {
        this.fullChat = _fullChat;
        this.chats = _chats;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLChatFull fullChat;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> chats;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> users;


    public com.github.badoualy.telegram.tl.api.TLChatFull getFullChat() {
        return fullChat;
    }

    public void setFullChat(com.github.badoualy.telegram.tl.api.TLChatFull value) {
        this.fullChat = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> value) {
        this.chats = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.fullChat, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.fullChat = (com.github.badoualy.telegram.tl.api.TLChatFull)readTLObject(stream, context);
        this.chats = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "messages.chatFull#e5d7d19c";
    }

}
