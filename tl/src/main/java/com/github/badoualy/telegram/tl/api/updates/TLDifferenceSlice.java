package com.github.badoualy.telegram.tl.api.updates;

import static com.github.badoualy.telegram.tl.StreamUtils.*;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsEncryptedMessage;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsUpdate;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLVector;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDifferenceSlice extends TLAbsDifference {
    public static final int CLASS_ID = 0xa8fb1981;

    protected TLVector<TLAbsMessage> newMessages;

    protected TLVector<TLAbsEncryptedMessage> newEncryptedMessages;

    protected TLVector<TLAbsUpdate> otherUpdates;

    protected TLVector<TLAbsChat> chats;

    protected TLVector<TLAbsUser> users;

    protected TLState intermediateState;

    public TLDifferenceSlice() {
    }

    public TLDifferenceSlice(TLVector<TLAbsMessage> newMessages, TLVector<TLAbsEncryptedMessage> newEncryptedMessages, TLVector<TLAbsUpdate> otherUpdates, TLVector<TLAbsChat> chats, TLVector<TLAbsUser> users, TLState intermediateState) {
        this.newMessages = newMessages;
        this.newEncryptedMessages = newEncryptedMessages;
        this.otherUpdates = otherUpdates;
        this.chats = chats;
        this.users = users;
        this.intermediateState = intermediateState;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(newMessages, stream);
        writeTLVector(newEncryptedMessages, stream);
        writeTLVector(otherUpdates, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
        writeTLObject(intermediateState, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        newMessages = readTLVector(stream, context);
        newEncryptedMessages = readTLVector(stream, context);
        otherUpdates = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
        intermediateState = (com.github.badoualy.telegram.tl.api.updates.TLState) readTLObject(stream, context);
    }

    @Override
    public String toString() {
        return "updates.differenceSlice#a8fb1981";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLVector<TLAbsMessage> getNewMessages() {
        return newMessages;
    }

    public void setNewMessages(TLVector<TLAbsMessage> newMessages) {
        this.newMessages = newMessages;
    }

    public TLVector<TLAbsEncryptedMessage> getNewEncryptedMessages() {
        return newEncryptedMessages;
    }

    public void setNewEncryptedMessages(TLVector<TLAbsEncryptedMessage> newEncryptedMessages) {
        this.newEncryptedMessages = newEncryptedMessages;
    }

    public TLVector<TLAbsUpdate> getOtherUpdates() {
        return otherUpdates;
    }

    public void setOtherUpdates(TLVector<TLAbsUpdate> otherUpdates) {
        this.otherUpdates = otherUpdates;
    }

    public TLVector<TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }

    public TLState getIntermediateState() {
        return intermediateState;
    }

    public void setIntermediateState(TLState intermediateState) {
        this.intermediateState = intermediateState;
    }
}
