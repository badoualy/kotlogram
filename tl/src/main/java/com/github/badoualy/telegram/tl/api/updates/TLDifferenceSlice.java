
package com.github.badoualy.telegram.tl.api.updates;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLDifferenceSlice extends TLAbsDifference {
    public static final int CLASS_ID = 0xa8fb1981;

    public TLDifferenceSlice() {

    }


    public TLDifferenceSlice(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> _newMessages,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage> _newEncryptedMessages,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> _otherUpdates,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> _chats,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users,         com.github.badoualy.telegram.tl.api.updates.TLState _intermediateState) {
        this.newMessages = _newMessages;
        this.newEncryptedMessages = _newEncryptedMessages;
        this.otherUpdates = _otherUpdates;
        this.chats = _chats;
        this.users = _users;
        this.intermediateState = _intermediateState;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> newMessages;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage> newEncryptedMessages;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> otherUpdates;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> chats;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> users;

    protected com.github.badoualy.telegram.tl.api.updates.TLState intermediateState;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> getNewMessages() {
        return newMessages;
    }

    public void setNewMessages(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsMessage> value) {
        this.newMessages = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage> getNewEncryptedMessages() {
        return newEncryptedMessages;
    }

    public void setNewEncryptedMessages(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage> value) {
        this.newEncryptedMessages = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> getOtherUpdates() {
        return otherUpdates;
    }

    public void setOtherUpdates(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> value) {
        this.otherUpdates = value;
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

    public com.github.badoualy.telegram.tl.api.updates.TLState getIntermediateState() {
        return intermediateState;
    }

    public void setIntermediateState(com.github.badoualy.telegram.tl.api.updates.TLState value) {
        this.intermediateState = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.newMessages, stream);
        writeTLVector(this.newEncryptedMessages, stream);
        writeTLVector(this.otherUpdates, stream);
        writeTLVector(this.chats, stream);
        writeTLVector(this.users, stream);
        writeTLObject(this.intermediateState, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.newMessages = readTLVector(stream, context);
        this.newEncryptedMessages = readTLVector(stream, context);
        this.otherUpdates = readTLVector(stream, context);
        this.chats = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
        this.intermediateState = (com.github.badoualy.telegram.tl.api.updates.TLState)readTLObject(stream, context);
    }



    @Override
    public String toString() {
        return "updates.differenceSlice#a8fb1981";
    }

}
