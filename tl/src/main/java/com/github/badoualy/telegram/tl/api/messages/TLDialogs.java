package com.github.badoualy.telegram.tl.api.messages;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChat;
import com.github.badoualy.telegram.tl.api.TLAbsDialog;
import com.github.badoualy.telegram.tl.api.TLAbsMessage;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLDialogs extends TLAbsDialogs {
    public static final int CONSTRUCTOR_ID = 0x15ba6c40;

    public TLDialogs() {
    }

    public TLDialogs(TLVector<? extends TLAbsDialog> dialogs, TLVector<? extends TLAbsMessage> messages, TLVector<? extends TLAbsChat> chats, TLVector<? extends TLAbsUser> users) {
        this.dialogs = dialogs;
        this.messages = messages;
        this.chats = chats;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(dialogs, stream);
        writeTLVector(messages, stream);
        writeTLVector(chats, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        dialogs = readTLVector(stream, context);
        messages = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += dialogs.computeSerializedSize();
        size += messages.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += users.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "messages.dialogs#15ba6c40";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLDialogs)) return false;
        if (object == this) return true;

        TLDialogs o = (TLDialogs) object;

        return (dialogs == o.dialogs || (dialogs != null && o.dialogs != null && dialogs.equals(o.dialogs)))
                && (messages == o.messages || (messages != null && o.messages != null && messages.equals(o.messages)))
                && (chats == o.chats || (chats != null && o.chats != null && chats.equals(o.chats)))
                && (users == o.users || (users != null && o.users != null && users.equals(o.users)));
    }

    public TLVector<? extends TLAbsDialog> getDialogs() {
        return dialogs;
    }

    public void setDialogs(TLVector<? extends TLAbsDialog> dialogs) {
        this.dialogs = dialogs;
    }

    public TLVector<? extends TLAbsMessage> getMessages() {
        return messages;
    }

    public void setMessages(TLVector<? extends TLAbsMessage> messages) {
        this.messages = messages;
    }

    public TLVector<? extends TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<? extends TLAbsChat> chats) {
        this.chats = chats;
    }

    public TLVector<? extends TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<? extends TLAbsUser> users) {
        this.users = users;
    }
}
