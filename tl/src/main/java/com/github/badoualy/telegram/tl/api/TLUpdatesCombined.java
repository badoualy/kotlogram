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

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLUpdatesCombined extends TLAbsUpdates {
    public static final int CONSTRUCTOR_ID = 0x725b04c3;

    protected TLVector<? extends TLAbsUpdate> updates;

    protected TLVector<? extends TLAbsUser> users;

    protected TLVector<? extends TLAbsChat> chats;

    protected int date;

    protected int seqStart;

    protected int seq;

    public TLUpdatesCombined() {
    }

    public TLUpdatesCombined(TLVector<? extends TLAbsUpdate> updates, TLVector<? extends TLAbsUser> users, TLVector<? extends TLAbsChat> chats, int date, int seqStart, int seq) {
        this.updates = updates;
        this.users = users;
        this.chats = chats;
        this.date = date;
        this.seqStart = seqStart;
        this.seq = seq;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLVector(updates, stream);
        writeTLVector(users, stream);
        writeTLVector(chats, stream);
        writeInt(date, stream);
        writeInt(seqStart, stream);
        writeInt(seq, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        updates = readTLVector(stream, context);
        users = readTLVector(stream, context);
        chats = readTLVector(stream, context);
        date = readInt(stream);
        seqStart = readInt(stream);
        seq = readInt(stream);
    }

    @Override
    public String toString() {
        return "updatesCombined#725b04c3";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    public TLVector<? extends TLAbsUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(TLVector<? extends TLAbsUpdate> updates) {
        this.updates = updates;
    }

    public TLVector<? extends TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<? extends TLAbsUser> users) {
        this.users = users;
    }

    public TLVector<? extends TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(TLVector<? extends TLAbsChat> chats) {
        this.chats = chats;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getSeqStart() {
        return seqStart;
    }

    public void setSeqStart(int seqStart) {
        this.seqStart = seqStart;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int seq) {
        this.seq = seq;
    }
}
