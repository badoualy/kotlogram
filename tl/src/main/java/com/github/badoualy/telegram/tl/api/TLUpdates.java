package com.github.badoualy.telegram.tl.api;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_INT32;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdates extends TLAbsUpdates {

    public static final int CONSTRUCTOR_ID = 0x74ae4240;

    protected TLVector<TLAbsUpdate> updates;

    protected TLVector<TLAbsUser> users;

    protected TLVector<TLAbsChat> chats;

    protected int date;

    protected int seq;

    private final String _constructor = "updates#74ae4240";

    public TLUpdates() {
    }

    public TLUpdates(TLVector<TLAbsUpdate> updates, TLVector<TLAbsUser> users, TLVector<TLAbsChat> chats, int date, int seq) {
        this.updates = updates;
        this.users = users;
        this.chats = chats;
        this.date = date;
        this.seq = seq;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(updates, stream);
        writeTLVector(users, stream);
        writeTLVector(chats, stream);
        writeInt(date, stream);
        writeInt(seq, stream);
    }

    @Override
    @SuppressWarnings({"unchecked", "SimplifiableConditionalExpression"})
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        updates = readTLVector(stream, context);
        users = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        date = readInt(stream);
        seq = readInt(stream);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += updates.computeSerializedSize();
        size += users.computeSerializedSize();
        size += chats.computeSerializedSize();
        size += SIZE_INT32;
        size += SIZE_INT32;
        return size;
    }

    @Override
    public String toString() {
        return _constructor;
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLVector<TLAbsUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(TLVector<TLAbsUpdate> updates) {
        this.updates = updates;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }

    public TLVector<TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<TLAbsChat> chats) {
        this.chats = chats;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
