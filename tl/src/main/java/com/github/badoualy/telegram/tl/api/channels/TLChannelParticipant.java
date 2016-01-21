
package com.github.badoualy.telegram.tl.api.channels;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.core.TLObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;


public class TLChannelParticipant extends TLObject {

    public static final int CLASS_ID = 0xd0d9b163;

    public TLChannelParticipant() {

    }


    public TLChannelParticipant(        com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant _participant,         com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> _users) {
        this.participant = _participant;
        this.users = _users;

    }


    public int getClassId() {
        return CLASS_ID;
    }


    protected com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant participant;

    protected com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> users;


    public com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant getParticipant() {
        return participant;
    }

    public void setParticipant(com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant value) {
        this.participant = value;
    }

    public com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(com.github.badoualy.telegram.tl.core.TLVector<com.github.badoualy.telegram.tl.api.TLAbsUser> value) {
        this.users = value;
    }


    @Override
    public void serializeBody(OutputStream stream) throws IOException {

        writeTLObject(this.participant, stream);
        writeTLVector(this.users, stream);
    }


    @Override
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {

        this.participant = (com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant)readTLObject(stream, context);
        this.users = readTLVector(stream, context);
    }


    @Override
    public String toString() {
        return "channels.channelParticipant#d0d9b163";
    }

}
