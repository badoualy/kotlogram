package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLIntVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLIntVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLMessageActionChatAddUser extends TLAbsMessageAction {
    public static final int CONSTRUCTOR_ID = 0x488a7337;

    protected TLIntVector users;

    public TLMessageActionChatAddUser() {
    }

    public TLMessageActionChatAddUser(TLIntVector users) {
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        users = readTLIntVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += users.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "messageActionChatAddUser#488a7337";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLMessageActionChatAddUser)) return false;
        if (object == this) return true;

        TLMessageActionChatAddUser o = (TLMessageActionChatAddUser) object;

        return (users == o.users || (users != null && o.users != null && users.equals(o.users)));
    }

    public TLIntVector getUsers() {
        return users;
    }

    public void setUsers(TLIntVector users) {
        this.users = users;
    }
}
