
package com.github.badoualy.telegram.tl.api.channels;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readInt;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeInt;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLChannelParticipants extends TLObject {

    public static final int CLASS_ID = 0xf56ee2a8;

    public TLChannelParticipants() {

    }


    public TLChannelParticipants(        int _count,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant> _participants,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users) {
        this.count = _count;
        this.participants = _participants;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected int count;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant> participants;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> users;


    public int getCount() {
        return count;
    }

    public void setCount(int value) {
        this.count = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant> getParticipants() {
        return participants;
    }

    public void setParticipants(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant> value) {
        this.participants = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeInt(this.count, stream);
        writeTLVector(this.participants, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.count = readInt(stream);
        this.participants = readTLVector(stream, context);
        this.users = readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "channels.channelParticipants#f56ee2a8";
    }

}
