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
import static com.github.badoualy.telegram.tl.TLObjectUtils.SIZE_CONSTRUCTOR_ID;

/**
 * @author Yannick Badoual yann.badoual@gmail.com
 * @see <a href="http://github.com/badoualy/kotlogram">http://github.com/badoualy/kotlogram</a>
 */
public class TLChannelParticipant extends TLObject {
    public static final int CONSTRUCTOR_ID = 0xd0d9b163;

    protected TLAbsChannelParticipant participant;

    protected TLVector<? extends TLAbsUser> users;

    public TLChannelParticipant() {
    }

    public TLChannelParticipant(TLAbsChannelParticipant participant, TLVector<? extends TLAbsUser> users) {
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
        participant = readTLObject(stream, context, TLAbsChannelParticipant.class, -1);
        users = readTLVector(stream, context);
    }

    @Override
    public int computeSerializedSize() {
        int size = SIZE_CONSTRUCTOR_ID;
        size += participant.computeSerializedSize();
        size += users.computeSerializedSize();
        return size;
    }

    @Override
    public String toString() {
        return "channels.channelParticipant#d0d9b163";
    }

    @Override
    public int getConstructorId() {
        return CONSTRUCTOR_ID;
    }

    @Override
    @SuppressWarnings("PointlessBooleanExpression")
    public boolean equals(Object object) {
        if (!(object instanceof TLChannelParticipant)) return false;
        if (object == this) return true;

        TLChannelParticipant o = (TLChannelParticipant) object;

        return (participant == o.participant || (participant != null && o.participant != null && participant.equals(o.participant)))
                && (users == o.users || (users != null && o.users != null && users.equals(o.users)));
    }

    public TLAbsChannelParticipant getParticipant() {
        return participant;
    }

    public void setParticipant(TLAbsChannelParticipant participant) {
        this.participant = participant;
    }

    public TLVector<? extends TLAbsUser> getUsers() {
        return users;
    }

    public void setUsers(TLVector<? extends TLAbsUser> users) {
        this.users = users;
    }
}
