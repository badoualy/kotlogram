
package com.github.badoualy.telegram.tl.api;


import com.github.badoualy.telegram.tl.core.*;
import com.github.badoualy.telegram.tl.*;
import java.io.*;
import rx.Observable;

import static com.github.badoualy.telegram.tl.StreamUtils.*;



public class TLUpdatesCombined extends TLAbsUpdates {
    public static final int CLASS_ID = 0x725b04c3;

    public TLUpdatesCombined() {

    }


    public TLUpdatesCombined(        com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> _updates,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> _chats,         int _date,         int _seqStart,         int _seq) {
        this.updates = _updates;
        this.users = _users;
        this.chats = _chats;
        this.date = _date;
        this.seqStart = _seqStart;
        this.seq = _seq;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> updates;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> users;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> chats;

    protected int date;

    protected int seqStart;

    protected int seq;


    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> getUpdates() {
        return updates;
    }

    public void setUpdates(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUpdate> value) {
        this.updates = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> value) {
        this.users = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> getChats() {
        return chats;
    }

    public void setChats(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChat> value) {
        this.chats = value;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int value) {
        this.date = value;
    }

    public int getSeqStart() {
        return seqStart;
    }

    public void setSeqStart(int value) {
        this.seqStart = value;
    }

    public int getSeq() {
        return seq;
    }

    public void setSeq(int value) {
        this.seq = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLVector(this.updates, stream);
        writeTLVector(this.users, stream);
        writeTLVector(this.chats, stream);
        writeInt(this.date, stream);
        writeInt(this.seqStart, stream);
        writeInt(this.seq, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.updates = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
        this.chats = readTLVector(stream, context);
        this.date = readInt(stream);
        this.seqStart = readInt(stream);
        this.seq = readInt(stream);
    }



    @Override
    public String toString() {
        return "updatesCombined#725b04c3";
    }

}
