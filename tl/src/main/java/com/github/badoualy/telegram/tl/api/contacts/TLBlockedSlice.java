package com.github.badoualy.telegram.tl.api.contacts;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.api.TLContactBlocked;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLBlockedSlice extends TLAbsBlocked {
    public static final int CONSTRUCTOR_ID = 0x900802a1;

    protected int count;

    public TLBlockedSlice() {
    }

    public TLBlockedSlice(int count, TLVector<? extends TLContactBlocked> blocked, TLVector<? extends TLAbsUser> users) {
        this.count = count;
        this.blocked = blocked;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeInt(count, stream);
        writeTLVector(blocked, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        count = readInt(stream);
        blocked = readTLVector(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "contacts.blockedSlice#900802a1";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public TLVector<? extends TLContactBlocked> getBlocked() {
        return blocked;
    }

    public void setBlocked(TLVector<? extends TLContactBlocked> blocked) {
        this.blocked = blocked;
    }

    public TLVector<? extends TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<? extends TLAbsUser> users) {
        this.users = users;
    }
}
