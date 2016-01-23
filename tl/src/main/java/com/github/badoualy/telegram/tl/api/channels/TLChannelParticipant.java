package com.github.badoualy.telegram.tl.api.channels;

import com.github.badoualy.telegram.tl.TLContext;
import com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant;
import com.github.badoualy.telegram.tl.api.TLAbsUser;
import com.github.badoualy.telegram.tl.core.TLObject;
import com.github.badoualy.telegram.tl.core.TLVector;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static com.github.badoualy.telegram.tl.StreamUtils.readTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.readTLVector;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLObject;
import static com.github.badoualy.telegram.tl.StreamUtils.writeTLVector;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipant extends TLObject {
    public static final int CLASS_ID = 0xd0d9b163;

    protected TLAbsChannelParticipant participant;

    protected TLVector<TLAbsUser> users;

    public TLChannelParticipant() {
    }

    public TLChannelParticipant(TLAbsChannelParticipant participant, TLVector<TLAbsUser> users) {
        this.participant = participant;
        this.users = users;
    }

    @Override
    public void serializeBody(OutputStream stream) throws IOException {
        writeTLObject(participant, stream);
        writeTLVector(users, stream);
    }

    @Override
    @SuppressWarnings("unchecked")
    public void deserializeBody(InputStream stream, TLContext context) throws IOException {
        participant = (com.github.badoualy.telegram.tl.api.TLAbsChannelParticipant) readTLObject(stream, context);
        users = readTLVector(stream, context);
    }

    @Override
    public String toString() {
        return "channels.channelParticipant#d0d9b163";
    }

    @Override
    public int getClassId() {
        return CLASS_ID;
    }

    public TLAbsChannelParticipant getParticipant() {
        return participant;
    }

    public void setParticipant(TLAbsChannelParticipant participant) {
        this.participant = participant;
    }

    public TLVector<TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<TLAbsUser> users) {
        this.users = users;
    }
}
